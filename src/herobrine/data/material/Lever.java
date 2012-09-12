package herobrine.data.material;

import herobrine.data.BlockFace;
import herobrine.data.Material;


/**
 * Represents a lever
 */
public class Lever extends SimpleAttachableMaterialData implements Redstone {
	
    public Lever() {
        super(Material.LEVER);
    }

    public Lever(final int type, final byte data) {
        super(type, data);
    }
    
    /**
     * Gets the current state of this Material, indicating if it's powered or
     * unpowered
     *
     * @return true if powered, otherwise false
     */
    public boolean isPowered() {
        return (getData() & 0x8) == 0x8;
    }

    /**
     * Gets the face that this block is attached on
     *
     * @return BlockFace attached to
     */
    public BlockFace getAttachedFace() {
        byte data = (byte) (getData() & 0x7);

        switch (data) {
        case 0x1:
            return BlockFace.NORTH;

        case 0x2:
            return BlockFace.SOUTH;

        case 0x3:
            return BlockFace.EAST;

        case 0x4:
            return BlockFace.WEST;

        case 0x5:
        case 0x6:
            return BlockFace.DOWN;
        
        case 0x0:
        case 0x7:
            return BlockFace.UP;
            
        }

        return null;
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing() + " " + (isPowered() ? "" : "NOT ") + "POWERED";
    }

    @Override
    public Lever clone() {
        return (Lever) super.clone();
    }
}
