package me.herobrine.ai.tasks;

import me.herobrine.ai.Task;
import me.herobrine.ai.TaskUnsuccessfulException;

public class IdleTask extends Task {

	@Override
	public Task execute() throws TaskUnsuccessfulException {
		return this;
	}

	@Override
	public boolean handleException(TaskUnsuccessfulException exception) {
		return false;
	}

}
