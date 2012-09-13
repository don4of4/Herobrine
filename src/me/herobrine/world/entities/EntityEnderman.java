package me.herobrine.world.entities;

import me.herobrine.data.Material;
import me.herobrine.data.MaterialData;


public class EntityEnderman extends EntityMonster {

	private net.minecraft.src.EntityEnderman entityEnderman;
	
	public EntityEnderman(net.minecraft.src.EntityEnderman entityEnderman) {
		super(entityEnderman);
		this.entityEnderman = entityEnderman;
	}
	
	public MaterialData getCarriedMaterial() {
		return Material.getMaterial(entityEnderman.getCarried()).getNewData((byte) entityEnderman.getCarryingData());
	}

}
