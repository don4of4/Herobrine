package herobrine.world.entities;

public abstract class EntityAgeable extends EntityCreature {

	private net.minecraft.src.EntityAgeable entityAgeable;
	
	public EntityAgeable(net.minecraft.src.EntityAgeable entityAgeable) {
		super(entityAgeable);
	}

	public boolean isChild() {
		return entityAgeable.isChild();
	}
	
	public int getAge() {
		return entityAgeable.getGrowingAge();
	}
	
}
