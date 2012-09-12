package herobrine.ai.tasks;

import herobrine.ai.Task;
import herobrine.ai.TaskUnsuccessfulException;

public class MoveTask extends Task {

	@Override
	public Task execute() throws TaskUnsuccessfulException {
		return null;
	}

	@Override
	public boolean handleException(TaskUnsuccessfulException exception) {
		return false;
	}

}
