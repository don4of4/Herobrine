package me.herobrine.event.connection;

public class KickedEvent extends ConnectionEvent {

	private String reason;

	public KickedEvent(String reason) {
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

}
