package me.herobrine.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import me.herobrine.plugin.Plugin;
import me.herobrine.util.MapSet;


public class EventManager {

	private static MapSet<Plugin, EventHandler> pluginHandlers = new MapSet<Plugin, EventHandler>();
	private static MapSet<Class<? extends Event>, EventHandler> eventHandlers = new MapSet<Class<? extends Event>, EventHandler>();
	
	private static BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<Event>();
	
	public static void process() {
		while(!eventQueue.isEmpty()) {
			handle(eventQueue.remove());
		}
	}
	
	public static void handle(Event event) {
		Set<EventHandler> handlers = eventHandlers.get(event.getClass());
		for(EventHandler handler : handlers) {
			try {
				Method method = handler.getClass().getMethod("handleEvent", event.getClass());
				method.invoke(handler, event);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void queue(Event event) {
		eventQueue.add(event);
	}
	
	public static void register(Plugin plugin, EventHandler eventHandler) {
		if(!plugin.isEnabled()) {
			return;
		}
		
		pluginHandlers.add(plugin, eventHandler);
		for(Method method : eventHandler.getClass().getMethods()) {
			if(method.getName().equals("handleEvent")) {
				Class<?>[] types = method.getParameterTypes();
				if(types.length == 1 && Event.class.isAssignableFrom(types[0])) {
					eventHandlers.add(types[0].asSubclass(Event.class), eventHandler);
				}
			}
		}
	}

	public static void unregister(Plugin plugin, EventHandler eventHandler) {
		pluginHandlers.remove(plugin, eventHandler);
		eventHandlers.removeElement(eventHandler);
	}
	
	public static void unregister(Plugin plugin) {
		Set<EventHandler> handlers = pluginHandlers.get(plugin);
		
		for(EventHandler handler : handlers) {
			eventHandlers.removeElement(handler);
		}
		
		pluginHandlers.remove(plugin);
	}
	
	public static EventHandler[] getHandlers(Plugin plugin) {
		return pluginHandlers.get(plugin).toArray(new EventHandler[0]);
	}
	
	public static EventHandler[] getHandlers(Class<? extends Event> type) {
		return eventHandlers.get(type).toArray(new EventHandler[0]);
	}
	
	public static EventHandler[] getHandlers(Plugin plugin, Class<? extends Event> type) {
		Set<EventHandler> handlers = new HashSet<EventHandler>();
		
		handlers.addAll(pluginHandlers.get(plugin));
		if(!handlers.isEmpty()) {
			EventHandler handler;
			for(Iterator<EventHandler> iterator = handlers.iterator(); iterator.hasNext();) {
				handler = iterator.next();
				if(!eventHandlers.get(type).contains(handler)) {
					iterator.remove();
				}
			}
		}
		
		return handlers.toArray(new EventHandler[0]);
	}
	
}
