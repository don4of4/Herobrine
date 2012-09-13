package me.herobrine.data.material;

import me.herobrine.data.BlockFace;
import me.herobrine.data.Material;
import me.herobrine.data.MaterialData;


/**
 * Material data for the piston base block
 */
public class PistonBaseMaterial extends MaterialData implements Directional, Redstone {

    public PistonBaseMaterial(final int type, final byte data) {
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

    public boolean isPowered() {
        return (getData() & 0x8) == 0x8;
    }

    /**
     * Checks if this piston base is sticky, and returns true if so
     *
     * @return true if this piston is "sticky", or false
     */
    public boolean isSticky() {
        return this.getItemType() == Material.PISTON_STICKY_BASE;
    }

    @Override
    public PistonBaseMaterial clone() {
        return (PistonBaseMaterial) super.clone();
    }
}
