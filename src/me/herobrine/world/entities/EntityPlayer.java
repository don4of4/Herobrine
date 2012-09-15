package me.herobrine.world.entities;

import me.herobrine.data.Position;
import net.minecraft.src.EntityClientPlayerMP;

public class EntityPlayer extends EntityLiving {

	private net.minecraft.src.EntityPlayer entityPlayer;
	
	public EntityPlayer(net.minecraft.src.EntityPlayer entityPlayer) {
		super(entityPlayer);
		this.entityPlayer = entityPlayer;
	}

	public boolean isSwinging() {
		return entityPlayer.isSwinging;
	}
	
	public boolean isSprinting() {
		return entityPlayer.isSprinting();
	}
	
	public boolean isEating() {
		return entityPlayer.isEating();
	}
	
	public String getUsername() {
		return entityPlayer.username;
	}

	@Override
	public Position getPosition() {
		Position position = super.getPosition();
		if(!(entityPlayer instanceof EntityClientPlayerMP)) {
			position.y += 1.62;
		}
		return position;
	}

	@Override
	public void getPosition(Position position) {
		super.getPosition(position);
		if(!(entityPlayer instanceof EntityClientPlayerMP)) {
			position.y += 1.62;
		}
	}
	

	@Override
	public String toString() {
		return String.format("%s { username: \"%s\", position: %s }", this.getClass().getSimpleName(), this.getUsername(), this.getPosition());
	}
	
}
