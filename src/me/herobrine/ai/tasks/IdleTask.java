package me.herobrine.ai.tasks;

import java.util.Random;

import me.herobrine.ai.Task;
import me.herobrine.ai.TaskUnsuccessfulException;
import me.herobrine.world.Controller;

public class IdleTask extends Task {

	@Override
	public Task execute() throws TaskUnsuccessfulException {
		/*Controller.setYaw(new Random().nextFloat() * 360);
		Controller.setPitch(new Random().nextFloat() * 180 - 90);
		Controller.forward = true;
		Controller.setSprinting(false);*/
		return this;
	}

	@Override
	public boolean handleException(TaskUnsuccessfulException exception) {
		return false;
	}

}
