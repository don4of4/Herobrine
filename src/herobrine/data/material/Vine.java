package herobrine.data.material;

import herobrine.data.BlockFace;
import herobrine.data.Material;
import herobrine.data.MaterialData;

import java.util.EnumSet;


/**
 * Represents a vine
 */
public class Vine extends MaterialData {
	
    private static final int VINE_NORTH = 0x4;
    private static final int VINE_EAST = 0x8;
    private static final int VINE_WEST = 0x2;
    private static final int VINE_SOUTH = 0x1;
    EnumSet<BlockFace> possibleFaces = EnumSet.of(BlockFace.NORTH, BlockFace.EAST, BlockFace.WEST, BlockFace.SOUTH);

    public Vine() {
        super(Material.VINE);
    }

    public Vine(int type, byte data) {
        super(type, data);
    }

    /**
     * Check if the vine is attached to the specified face of an adjacent block. You can
     * check two faces at once by passing eg {@link BlockFace#NORTH_EAST}.
     *
     * @param face The face to check.
     * @return Whether it is attached to that face.
     */
    public boolean isOnFace(BlockFace face) {
        switch (face) {
            case NORTH:
                return (getData() & VINE_NORTH) > 0;
            case EAST:
                return (getData() & VINE_EAST) > 0;
            case WEST:
                return (getData() & VINE_WEST) > 0;
            case SOUTH:
                return (getData() & VINE_SOUTH) > 0;
            case NORTH_EAST:
                return isOnFace(BlockFace.NORTH) && isOnFace(BlockFace.EAST);
            case NORTH_WEST:
                return isOnFace(BlockFace.NORTH) && isOnFace(BlockFace.WEST);
            case SOUTH_EAST:
                return isOnFace(BlockFace.SOUTH) && isOnFace(BlockFace.EAST);
            case SOUTH_WEST:
                return isOnFace(BlockFace.SOUTH) && isOnFace(BlockFace.WEST);
            case UP: // It's impossible to be accurate with this since it's contextual
                return true;
            default:
                return false;
        }
    }

    @Override
    public String toString() {
        return "VINE";
    }

    @Override
    public Vine clone() {
        return (Vine) super.clone();
    }
}
