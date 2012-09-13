package me.herobrine.world.entities;

import me.herobrine.data.Material;
import me.herobrine.data.MaterialData;

public class EntityFallingBlock extends Entity {

	private net.minecraft.src.EntityFallingSand entityFallingBlock;
	
	public EntityFallingBlock(net.minecraft.src.EntityFallingSand entityFallingBlock) {
		super(entityFallingBlock);
		this.entityFallingBlock = entityFallingBlock;
	}
	
	public MaterialData getBlockMaterial() {
		return Material.getMaterial(entityFallingBlock.blockID).getNewData((byte) entityFallingBlock.field_70285_b);
	}

}
