package me.herobrine.data.material;

import me.herobrine.data.BlockFace;
import me.herobrine.data.Material;


/**
 * Represents the tripwire hook
 */
public class TripwireHook extends SimpleAttachableMaterialData implements Redstone {

    public TripwireHook() {
        super(Material.TRIPWIRE_HOOK);
    }

    public TripwireHook(final int type, final byte data) {
        super(type, data);
    }
    
    /**
     * Test if tripwire is connected
     * @return true if connected, false if not
     */
    public boolean isConnected() {
        return (getData() & 0x4) != 0;
    }

    /**
     * Test if hook is currently activated
     * @return true if activated, false if not
     */
    public boolean isActivated() {
        return (getData() & 0x8) != 0;
    }

    public BlockFace getAttachedFace() {
        switch (getData() & 0x3) {
        case 0:
            return BlockFace.EAST;
        case 1:
            return BlockFace.SOUTH;
        case 2:
            return BlockFace.WEST;
        case 3:
            return BlockFace.NORTH;
        }
        return null;
    }

    public boolean isPowered() {
        return isActivated();
    }

    @Override
    public TripwireHook clone() {
        return (TripwireHook) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing() + (isActivated()?" Activated":"") + (isConnected()?" Connected":"");
    }
}
