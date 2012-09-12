package herobrine.data.material;

import herobrine.data.EntityType;
import herobrine.data.Material;
import herobrine.data.MaterialData;

/**
 * Represents a spawn egg that can be used to spawn mobs
 */
public class SpawnEgg extends MaterialData {
	
    public SpawnEgg() {
        super(Material.MONSTER_EGG);
    }

    public SpawnEgg(int type, byte data){
        super(type, data);
    }

    /**
     * Get the type of entity this egg will spawn.
     * @return The entity type.
     */
    public EntityType getSpawnedType() {
        return EntityType.fromId(getData());
    }

    @Override
    public String toString() {
        return "SPAWN EGG{" + getSpawnedType() + "}";
    }

    @Override
    public SpawnEgg clone() {
        return (SpawnEgg) super.clone();
    }
    
}
