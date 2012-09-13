package me.herobrine.event.controller;

public class ChatEvent extends ControllerEvent {

	private String message;
	
	public ChatEvent(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
