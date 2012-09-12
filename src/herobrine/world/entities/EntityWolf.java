package herobrine.world.entities;

public class EntityWolf extends EntityTameable {

	private net.minecraft.src.EntityWolf entityWolf;
	
	public EntityWolf(net.minecraft.src.EntityWolf entityWolf) {
		super(entityWolf);
		this.entityWolf = entityWolf;
	}

	public boolean isAngry() {
		return entityWolf.isAngry();
	}
	
	public boolean isShaking() {
		return entityWolf.getWolfShaking();
	}
	
	public int getHealth() {
		return entityWolf.getDataWatcher().getWatchableObjectInt(18);
	}
	
}
