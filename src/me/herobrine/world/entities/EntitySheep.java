package me.herobrine.world.entities;

import me.herobrine.data.DyeColor;

public class EntitySheep extends EntityAnimal {

	private net.minecraft.src.EntitySheep entitySheep;
	
	public EntitySheep(net.minecraft.src.EntitySheep entitySheep) {
		super(entitySheep);
		this.entitySheep = entitySheep;
	}
	
	public boolean isSheared() {
		return entitySheep.getSheared();
	}
	
	public DyeColor getColor() {
		return DyeColor.getByData((byte) entitySheep.getFleeceColor());
	}

}
