package me.herobrine.world.entities;

public class EntityDragonPart extends Entity {

	private net.minecraft.src.EntityDragonPart entityDragonPart;
	
	public EntityDragonPart(net.minecraft.src.EntityDragonPart entityDragonPart) {
		super(entityDragonPart);
		this.entityDragonPart = entityDragonPart;
	}
	
	public String getName() {
		return entityDragonPart.name;
	}

	public EntityDragonBase getBase() {
		return (EntityDragonBase) Entity.getEntity(entityDragonPart.entityDragonObj);
	}
	
}
