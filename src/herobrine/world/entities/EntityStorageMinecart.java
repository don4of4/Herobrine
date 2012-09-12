package herobrine.world.entities;

public class EntityStorageMinecart extends EntityMinecart {

	public EntityStorageMinecart(net.minecraft.src.EntityMinecart entityStorageMinecart) {
		super(entityStorageMinecart);
		if(entityStorageMinecart.minecartType != Type.StorageMinecart.getId()) {
			throw new IllegalArgumentException();
		}
	}

}
