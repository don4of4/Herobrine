package herobrine.world.entities;

public class EntityAnimal extends EntityAgeable {
	
	private net.minecraft.src.EntityAnimal entityAnimal;
	
	public EntityAnimal(net.minecraft.src.EntityAnimal entityAnimal) {
		super(entityAnimal);
		this.entityAnimal = entityAnimal;
	}
	
	public boolean isInLove() {
		return entityAnimal.isInLove();
	}

}
