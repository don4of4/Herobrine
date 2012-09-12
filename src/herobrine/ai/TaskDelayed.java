package herobrine.ai;

public class TaskDelayed {

	private Task task;
	private long delay;
	
	private long activateTime;
	
	public TaskDelayed(Task task, long delay) {
		this.task = task;
		this.delay = delay;
	}
	
	public void activate() {
		this.activateTime = System.currentTimeMillis();
	}
	
	public boolean isReady() {
		return System.currentTimeMillis() - activateTime >= delay;
	}

	public Task getTask() {
		return task;
	}
	
	
	
}
