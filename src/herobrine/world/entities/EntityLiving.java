package herobrine.world.entities;


public abstract class EntityLiving extends Entity {

	private net.minecraft.src.EntityLiving entityLiving;
	
	public EntityLiving(net.minecraft.src.EntityLiving entityLiving) {
		super(entityLiving);
		this.entityLiving = entityLiving;
	}

	public int getMaxHealth() {
		return entityLiving.getMaxHealth();
	}
	
}
