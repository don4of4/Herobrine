package me.herobrine.world;

import me.herobrine.Herobrine;
import me.herobrine.data.Position;
import me.herobrine.data.Rotation;
import me.herobrine.world.entities.Entity;
import me.herobrine.world.entities.EntityPlayer;

public class Controller {

	public static boolean forward, backwards, left, right, sneak, jump;
	
	public static EntityPlayer getEntity() {
		return (EntityPlayer) Entity.getEntity(Herobrine.mc.thePlayer);
	}
	
	public static void setPitch(float pitch) {
		Herobrine.mc.thePlayer.rotationPitch = pitch;
	}
	
	public static void setYaw(float yaw) {
		Herobrine.mc.thePlayer.rotationYaw = yaw;
	}

	public static float getPitch() {
		return Herobrine.mc.thePlayer.rotationPitch;
	}
	
	public static float getYaw() {
		return Herobrine.mc.thePlayer.rotationYaw;
	}
	
	public static void changePitch(float pitch) {
		Herobrine.mc.thePlayer.rotationPitch += pitch;
	}
	
	public static void changeYaw(float yaw) {
		Herobrine.mc.thePlayer.rotationYaw += yaw;
	}

	public static void setRotation(Rotation rotation) {
		Herobrine.mc.thePlayer.rotationPitch = rotation.pitch;
		Herobrine.mc.thePlayer.rotationYaw = rotation.yaw;
	}
	
	public static void setSprinting(boolean sprinting) {
		Herobrine.mc.thePlayer.setSprinting(sprinting);
	}

	public static void lookAt(Position position) {
		Controller.setRotation(Controller.getEntity().getPosition().getRotation(position));
	}
	
	public static void say(String message) {
		Herobrine.mc.thePlayer.sendChatMessage(message);
	}
	
	public static boolean exists() {
		return Herobrine.mc.thePlayer != null;
	}
	
}
