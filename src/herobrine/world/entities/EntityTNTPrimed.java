package herobrine.world.entities;

public class EntityTNTPrimed extends Entity {

	private net.minecraft.src.EntityTNTPrimed entityTNTPrimed;
	
	public EntityTNTPrimed(net.minecraft.src.EntityTNTPrimed entityTNTPrimed) {
		super(entityTNTPrimed);
		this.entityTNTPrimed = entityTNTPrimed;
	}
	
	public int getFuse() {
		return entityTNTPrimed.fuse;
	}
	
}
