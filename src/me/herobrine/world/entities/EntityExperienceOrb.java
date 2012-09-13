package me.herobrine.world.entities;

public class EntityExperienceOrb extends Entity {

	private net.minecraft.src.EntityXPOrb entityExperienceOrb;
	
	public EntityExperienceOrb(net.minecraft.src.EntityXPOrb entityExperienceOrb) {
		super(entityExperienceOrb);
		this.entityExperienceOrb = entityExperienceOrb;
	}

	public int getExperience() {
		return entityExperienceOrb.getXpValue();
	}
	
}
