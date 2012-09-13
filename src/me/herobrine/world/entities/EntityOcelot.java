package me.herobrine.world.entities;

public class EntityOcelot extends EntityTameable {

	public enum SkinType {
		WILD,

		TAMED_BLACK, TAMED_RED, TAMED_SIAMESE
	}

	private net.minecraft.src.EntityOcelot entityOcelot;

	public EntityOcelot(net.minecraft.src.EntityOcelot entityOcelot) {
		super(entityOcelot);
		this.entityOcelot = entityOcelot;
	}

	public SkinType getType() {
		switch (entityOcelot.getTameSkin()) {
		case 0:
			return SkinType.WILD;
		case 1:
			return SkinType.TAMED_BLACK;
		case 2:
			return SkinType.TAMED_RED;
		case 3:
			return SkinType.TAMED_SIAMESE;
		default:
			return SkinType.WILD;
		}
	}

}
