package herobrine.ai.tasks;

import herobrine.ai.Task;
import herobrine.ai.TaskUnsuccessfulException;

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
