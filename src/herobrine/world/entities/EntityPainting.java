package herobrine.world.entities;

import herobrine.data.Art;

public class EntityPainting extends Entity {

	private net.minecraft.src.EntityPainting entityPainting;
	
	public EntityPainting(net.minecraft.src.EntityPainting entityPainting) {
		super(entityPainting);
		this.entityPainting = entityPainting;
	}

	public Art getArt() {
		return Art.convert(entityPainting.art);
	}
	
	
}
