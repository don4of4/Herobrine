package herobrine.data.material;

import herobrine.data.BlockFace;
import herobrine.data.MaterialData;


/**
 * Material data for the piston extension block
 */
public class PistonExtensionMaterial extends MaterialData implements Attachable {
	
    public PistonExtensionMaterial(final int type, final byte data) {
        super(type, data);
    }

    public BlockFace getFacing() {
        byte dir = (byte) (getData() & 7);

        switch (dir) {
        case 0:
            return BlockFace.DOWN;
        case 1:
            return BlockFace.UP;
        case 2:
            return BlockFace.EAST;
        case 3:
            return BlockFace.WEST;
        case 4:
            return BlockFace.NORTH;
        case 5:
            return BlockFace.SOUTH;
        default:
            return BlockFace.SELF;
        }
    }

    /**
     * Checks if this piston extension is sticky, and returns true if so
     *
     * @return true if this piston is "sticky", or false
     */
    public boolean isSticky() {
        return (getData() & 8) == 8;
    }

    public BlockFace getAttachedFace() {
        return getFacing().getOppositeFace();
    }

    @Override
    public PistonExtensionMaterial clone() {
        return (PistonExtensionMaterial) super.clone();
    }
}
