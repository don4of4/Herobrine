package me.herobrine.world.entities;

public class EntityIronGolem extends EntityGolem {

	private net.minecraft.src.EntityIronGolem entityIronGolem;
	
	public EntityIronGolem(net.minecraft.src.EntityIronGolem entityIronGolem) {
		super(entityIronGolem);
		this.entityIronGolem = entityIronGolem;
	}
	
	public boolean isAngry() {
		return entityIronGolem.getBit1Flag();
	}

}
