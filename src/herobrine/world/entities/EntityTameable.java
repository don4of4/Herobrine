package herobrine.world.entities;

public abstract class EntityTameable extends EntityAnimal {

	private net.minecraft.src.EntityTameable entityTameable;
	
	public EntityTameable(net.minecraft.src.EntityTameable entityTameable) {
		super(entityTameable);
		this.entityTameable = entityTameable;
	}

	public boolean isTamed() {
		return entityTameable.isTamed();
	}
	
	public boolean isSitting() {
		return entityTameable.isSitting();
	}
	
}
