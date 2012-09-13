package me.herobrine.data.material;

import me.herobrine.data.Material;

/**
 * Represents a furnace.
 */
public class Furnace extends FurnaceAndDispenser {

    public Furnace() {
        super(Material.FURNACE);
    }

    public Furnace(final int type, final byte data) {
        super(type, data);
    }

    @Override
    public Furnace clone() {
        return (Furnace) super.clone();
    }
    
}
