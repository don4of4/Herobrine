package herobrine.world.entities;

public class EntitySlime extends EntityLiving {

	private net.minecraft.src.EntitySlime entitySlime;
	
	public EntitySlime(net.minecraft.src.EntitySlime entitySlime) {
		super(entitySlime);
		this.entitySlime = entitySlime;
	}
	
	public int getSize() {
		return entitySlime.getSlimeSize();
	}
	
}
