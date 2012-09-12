package herobrine.plugins.test;

import java.util.Random;

import herobrine.ai.Task;
import herobrine.ai.TaskDelayed;
import herobrine.ai.TaskManager;
import herobrine.ai.TaskUnsuccessfulException;
import herobrine.event.EventHandler;
import herobrine.event.EventManager;
import herobrine.event.controller.ChatEvent;
import herobrine.plugin.Plugin;
import herobrine.plugin.PluginDescription;
import herobrine.plugin.PluginVersion;
import herobrine.world.Controller;

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
		if(event.getMessage().startsWith("<arco123> ")) {
			
			TaskManager.schedule(new TaskDelayed(new Task() {

				@Override
				public Task execute() throws TaskUnsuccessfulException {
					Controller.say("STFU ARCO.");
					return null;
				}

				@Override
				public boolean handleException(TaskUnsuccessfulException exception) {
					return false;
				}
				
			}, 1000 + new Random().nextInt(1000)));
			
		}
	}

}
