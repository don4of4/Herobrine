package herobrine.data.material;

import herobrine.data.BlockFace;
import herobrine.data.Material;
import herobrine.data.MaterialData;


/**
 * Represents a door.
 */
public class Door extends MaterialData implements Directional, Openable {
	
    public Door() {
        super(Material.WOODEN_DOOR);
    }
    public Door(final int type, final byte data) {
        super(type, data);
    }

    public boolean isOpen() {
        return ((getData() & 0x4) == 0x4);
    }

    /**
     * @return whether this is the top half of the door
     */
    public boolean isTopHalf() {
        return ((getData() & 0x8) == 0x8);
    }

    /**
     * @return the location of the hinges
     */
    public BlockFace getHingeCorner() {
        byte d = getData();

        if ((d & 0x3) == 0x3) {
            return BlockFace.NORTH_WEST;
        } else if ((d & 0x1) == 0x1) {
            return BlockFace.SOUTH_EAST;
        } else if ((d & 0x2) == 0x2) {
            return BlockFace.SOUTH_WEST;
        }

        return BlockFace.NORTH_EAST;
    }

    @Override
    public String toString() {
        return (isTopHalf() ? "TOP" : "BOTTOM") + " half of " + (isOpen() ? "an OPEN " : "a CLOSED ") + super.toString() + " with hinges " + getHingeCorner();
    }

    /**
     * Get the direction that this door is facing.
     *
     * @return the direction
     */
    public BlockFace getFacing() {
        byte data = (byte) (getData() & 0x3);
        switch (data) {
        case 0:
            return BlockFace.NORTH;

        case 1:
            return BlockFace.EAST;

        case 2:
            return BlockFace.SOUTH;

        case 3:
            return BlockFace.WEST;
        }
        return null; // shouldn't happen
    }

    @Override
    public Door clone() {
        return (Door) super.clone();
    }
    
}
