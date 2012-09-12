package herobrine.world.entities;

public class EntityPoweredMinecart extends EntityMinecart {

	public EntityPoweredMinecart(net.minecraft.src.EntityMinecart entityPoweredMinecart) {
		super(entityPoweredMinecart);
		if(entityPoweredMinecart.minecartType != Type.PoweredMinecart.getId()) {
			throw new IllegalArgumentException();
		}
	}

}
