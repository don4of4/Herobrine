package me.herobrine.world.entities;

public class EntityPig extends EntityAnimal {

	private net.minecraft.src.EntityPig entityPig;
	
	public EntityPig(net.minecraft.src.EntityPig entityPig) {
		super(entityPig);
		this.entityPig = entityPig;
	}
	
	public boolean isSaddled() {
		return entityPig.getSaddled();
	}
	
}
