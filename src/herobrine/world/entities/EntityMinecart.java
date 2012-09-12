package herobrine.world.entities;

import java.util.HashMap;
import java.util.Map;

public class EntityMinecart extends Entity {

	public enum Type {
        Minecart(0),
        StorageMinecart(1),
        PoweredMinecart(2);

        private final static Map<Integer, Type> BY_ID = new HashMap<Integer, Type>();
        
        private final int id;

        private Type(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
        
        public static Type byId(int id) {
        	return BY_ID.get(id);
        }
    }
	
	private net.minecraft.src.EntityMinecart entityMinecart;
	
	public EntityMinecart(net.minecraft.src.EntityMinecart entityMinecart) {
		super(entityMinecart);
	}
	
	public Type getType() {
		return Type.byId(entityMinecart.minecartType);
	}

}
