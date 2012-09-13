package me.herobrine.world.entities;

import me.herobrine.data.Material;
import me.herobrine.data.MaterialData;

public class EntityItem extends Entity {

	private net.minecraft.src.EntityItem entityItem;
	
	public EntityItem(net.minecraft.src.EntityItem entityItem) {
		super(entityItem);
		this.entityItem = entityItem;
	}
	
	public MaterialData getMaterial() {
		return Material.getMaterial(entityItem.item.itemID).getNewData((byte) entityItem.item.getItemDamage());
	}
	
}
