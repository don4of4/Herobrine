package me.herobrine.data.material;

import me.herobrine.data.BlockFace;
import me.herobrine.data.Material;
import me.herobrine.data.MaterialData;


/**
 * MaterialData for signs
 */
public class Sign extends MaterialData implements Attachable {
	
    public Sign() {
        super(Material.SIGN_POST);
    }
    
    public Sign(final int type, final byte data) {
        super(type, data);
    }
    
    /**
     * Check if this sign is attached to a wall
     *
     * @return true if this sign is attached to a wall, false if set on top of a
     *         block
     */
    public boolean isWallSign() {
        return getItemType() == Material.WALL_SIGN;
    }

    /**
     * Gets the face that this block is attached on
     *
     * @return BlockFace attached to
     */
    public BlockFace getAttachedFace() {
        if (isWallSign()) {
            byte data = getData();

            switch (data) {
            case 0x2:
                return BlockFace.WEST;

            case 0x3:
                return BlockFace.EAST;

            case 0x4:
                return BlockFace.SOUTH;

            case 0x5:
                return BlockFace.NORTH;
            }

            return null;
        }
		return BlockFace.DOWN;
    }

    /**
     * Gets the direction that this sign is currently facing
     *
     * @return BlockFace indicating where this sign is facing
     */
    public BlockFace getFacing() {
        byte data = getData();

        if (!isWallSign()) {
            switch (data) {
            case 0x0:
                return BlockFace.WEST;

            case 0x1:
                return BlockFace.WEST_NORTH_WEST;

            case 0x2:
                return BlockFace.NORTH_WEST;

            case 0x3:
                return BlockFace.NORTH_NORTH_WEST;

            case 0x4:
                return BlockFace.NORTH;

            case 0x5:
                return BlockFace.NORTH_NORTH_EAST;

            case 0x6:
                return BlockFace.NORTH_EAST;

            case 0x7:
                return BlockFace.EAST_NORTH_EAST;

            case 0x8:
                return BlockFace.EAST;

            case 0x9:
                return BlockFace.EAST_SOUTH_EAST;

            case 0xA:
                return BlockFace.SOUTH_EAST;

            case 0xB:
                return BlockFace.SOUTH_SOUTH_EAST;

            case 0xC:
                return BlockFace.SOUTH;

            case 0xD:
                return BlockFace.SOUTH_SOUTH_WEST;

            case 0xE:
                return BlockFace.SOUTH_WEST;

            case 0xF:
                return BlockFace.WEST_SOUTH_WEST;
            }

            return null;
        }
		return getAttachedFace().getOppositeFace();
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing();
    }

    @Override
    public Sign clone() {
        return (Sign) super.clone();
    }
}
