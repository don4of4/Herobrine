package herobrine.world.entities;

public class EntityDragon extends EntityDragonBase {

	private net.minecraft.src.EntityDragon entityDragon;
	
	public EntityDragon(net.minecraft.src.EntityDragon entityDragon) {
		super(entityDragon);
		this.entityDragon = entityDragon;
	}

	public int getHealth() {
		return entityDragon.getHealth();
	}

	public EntityDragonPart[] getParts() {
		net.minecraft.src.Entity[] parts = entityDragon.getParts();
		EntityDragonPart[] ret = new EntityDragonPart[parts.length];
		for(int i = 0; i < parts.length; i++) {
			ret[i] = (EntityDragonPart) Entity.getEntity(parts[i]);
		}
		return ret;
	}
	
}
