package me.herobrine.data.material;

import me.herobrine.data.BlockFace;
import me.herobrine.data.MaterialData;


/**
 * Represents stairs.
 */
public class Stairs extends MaterialData implements Directional {

    public Stairs(final int type, final byte data) {
        super(type, data);
    }

    /**
     * @return the direction the stairs ascend towards
     */
    public BlockFace getAscendingDirection() {
        byte data = getData();

        switch (data & 0x3) {
        case 0x0:
        default:
            return BlockFace.SOUTH;

        case 0x1:
            return BlockFace.NORTH;

        case 0x2:
            return BlockFace.WEST;

        case 0x3:
            return BlockFace.EAST;
        }
    }

    /**
     * @return the direction the stairs descend towards
     */
    public BlockFace getDescendingDirection() {
        return getAscendingDirection().getOppositeFace();
    }
    
    /**
     * @return the direction the stair part of the block is facing
     */
    public BlockFace getFacing() {
        return getDescendingDirection();
    }

    /**
     * Test if step is inverted
     * @return true if inverted (top half), false if normal (bottom half)
     */
    public boolean isInverted() {
        return ((getData() & 0x4) != 0);
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing() + (isInverted()?" inverted":"");
    }

    @Override
    public Stairs clone() {
        return (Stairs) super.clone();
    }
}
