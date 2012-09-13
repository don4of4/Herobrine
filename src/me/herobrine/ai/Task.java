package me.herobrine.ai;

public abstract class Task {

	public abstract Task execute() throws TaskUnsuccessfulException;
	
	public abstract boolean handleException(TaskUnsuccessfulException exception);

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
}
