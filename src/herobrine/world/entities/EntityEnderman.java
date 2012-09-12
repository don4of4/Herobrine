package herobrine.world.entities;

import herobrine.data.Material;
import herobrine.data.MaterialData;


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
