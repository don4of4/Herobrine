package me.herobrine.plugins.test;

import java.util.Random;

import me.herobrine.ai.Task;
import me.herobrine.ai.TaskDelayed;
import me.herobrine.ai.TaskManager;
import me.herobrine.ai.TaskUnsuccessfulException;
import me.herobrine.event.EventHandler;
import me.herobrine.event.EventManager;
import me.herobrine.event.controller.ChatEvent;
import me.herobrine.plugin.Plugin;
import me.herobrine.plugin.PluginDescription;
import me.herobrine.plugin.PluginVersion;
import me.herobrine.world.Controller;


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
