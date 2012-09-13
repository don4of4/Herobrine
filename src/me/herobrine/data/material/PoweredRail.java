package me.herobrine.data.material;

import me.herobrine.data.Material;

/**
 * Represents a powered rail
 */
public class PoweredRail extends ExtendedRails implements Redstone {
    
	public PoweredRail() {
        super(Material.POWERED_RAIL);
    }

    public PoweredRail(final int type, final byte data) {
        super(type, data);
    }

    public boolean isPowered() {
        return (getData() & 0x8) == 0x8;
    }

    @Override
    public PoweredRail clone() {
        return (PoweredRail) super.clone();
    }

}
