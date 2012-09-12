package herobrine.data.material;

import herobrine.data.Material;
import herobrine.data.MaterialData;
import herobrine.data.SandstoneType;

/**
 * Represents the different types of sandstone.
 */
public class Sandstone extends MaterialData {
	
    public Sandstone() {
        super(Material.SANDSTONE);
    }
    
    public Sandstone(final int type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current type of this sandstone
     *
     * @return SandstoneType of this sandstone
     */
    public SandstoneType getType() {
        return SandstoneType.getByData(getData());
    }
    
    @Override
    public String toString() {
        return getType() + " " + super.toString();
    }

    @Override
    public Sandstone clone() {
        return (Sandstone) super.clone();
    }
    
}
