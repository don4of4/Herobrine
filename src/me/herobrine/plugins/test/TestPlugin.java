package me.herobrine.plugins.test;

import me.herobrine.ai.TaskManager;
import me.herobrine.ai.tasks.MoveEntityTask;
import me.herobrine.event.EventHandler;
import me.herobrine.event.EventManager;
import me.herobrine.event.connection.ConnectEvent;
import me.herobrine.event.connection.DisconnectEvent;
import me.herobrine.event.connection.LoginEvent;
import me.herobrine.event.controller.ChatEvent;
import me.herobrine.event.interfaces.OpenInterfaceEvent;
import me.herobrine.plugin.Plugin;
import me.herobrine.plugin.PluginDescription;
import me.herobrine.plugin.PluginVersion;
import me.herobrine.world.Controller;
import me.herobrine.world.World;
import me.herobrine.world.entities.EntityPlayer;


public class TestPlugin extends Plugin implements EventHandler {
	
	public TestPlugin() {
		super(new PluginDescription("Test", new PluginVersion(1, 0, 0)));
	}
	
	@Override
	public void onLoad() {
		this.setEnabled(true);
	}

	@Override
	public void onEnable() {
		EventManager.register(this, this);
	}

	@Override
	public void onDisable() {

	}
	
	public void handleEvent(ChatEvent event) {
		if(event.getMessage().startsWith("<") && event.getMessage().contains(">") && event.getMessage().contains("get here")) {
			String username = event.getMessage().substring(1, event.getMessage().indexOf('>'));
			EntityPlayer target = null;
			for(EntityPlayer player : World.getEntities(EntityPlayer.class)) {
				if(player.getUsername().equals(username)) {
					target = player;
					break;
				}
			}
			
			if(target == null) {
				Controller.say(username + ", I can't find you!");
			} else {
				TaskManager.schedule(new MoveEntityTask(target));
			}
		}
	}
	
	public void handleEvent(ConnectEvent event) {
		System.out.println("Connecting...");
	}
	
	public void handleEvent(LoginEvent event) {
		System.out.println("Logged in.");
	}
	
	//This doesn't work atm
	/*public void handleEvent(DisconnectEvent event) {
		System.out.println("Disconnected.");
	}*/

}
