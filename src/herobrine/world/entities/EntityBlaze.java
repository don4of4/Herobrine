package herobrine.world.entities;

public class EntityBlaze extends EntityMonster {

	private net.minecraft.src.EntityBlaze entityBlaze;
	
	public EntityBlaze(net.minecraft.src.EntityBlaze entityBlaze) {
		super(entityBlaze);
		this.entityBlaze = entityBlaze;
	}
	
	public boolean isAngry() {
		return entityBlaze.func_70845_n();
	}

}
