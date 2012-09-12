package herobrine.world.entities;

public class EntityGhast extends EntityFlying {

	@SuppressWarnings("unused")
	private net.minecraft.src.EntityGhast entityGhast;
	
	public EntityGhast(net.minecraft.src.EntityGhast entityGhast) {
		super(entityGhast);
	}
	
	@SuppressWarnings("static-method")
	public boolean isAngry() {
		return false; // TODO
	}

}
