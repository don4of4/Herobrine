package herobrine.data.material;

import herobrine.data.BlockFace;
import herobrine.data.Material;
import herobrine.data.MaterialData;


/**
 * Represents a bed.
 */
public class Bed extends MaterialData implements Directional {

    /**
     * Default constructor for a bed.
     */
    public Bed() {
        super(Material.BED_BLOCK);
    }

    public Bed(final int type, final byte data) {
        super(type, data);
    }

    /**
     * Determine if this block represents the head of the bed
     *
     * @return true if this is the head of the bed, false if it is the foot
     */
    public boolean isHeadOfBed() {
        return (getData() & 0x8) == 0x8;
    }
    
    /**
     * Get the direction that this bed's head is facing toward
     *
     * @return the direction the head of the bed is facing
     */
    public BlockFace getFacing() {
        byte data = (byte) (getData() & 0x7);

        switch (data) {
        case 0x0:
            return BlockFace.WEST;

        case 0x1:
            return BlockFace.NORTH;

        case 0x2:
            return BlockFace.EAST;

        case 0x3:
        default:
            return BlockFace.SOUTH;
        }
    }

    @Override
    public String toString() {
        return (isHeadOfBed() ? "HEAD" : "FOOT") + " of " + super.toString() + " facing " + getFacing();
    }

    @Override
    public Bed clone() {
        return (Bed) super.clone();
    }
}
