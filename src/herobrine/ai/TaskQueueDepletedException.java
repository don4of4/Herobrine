package herobrine.ai;

public class TaskQueueDepletedException extends TaskException {

	public TaskQueueDepletedException() {
		super("No tasks remaining/scheduled.");
	}
	
}
