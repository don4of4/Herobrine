package me.herobrine.data.material;

import me.herobrine.data.BlockFace;
import me.herobrine.data.Material;


/**
 * Represents Ladder data
 */
public class Ladder extends SimpleAttachableMaterialData {
	
    public Ladder() {
        super(Material.LADDER);
    }

    public Ladder(final int type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the face that this block is attached on
     *
     * @return BlockFace attached to
     */
    public BlockFace getAttachedFace() {
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

    @Override
    public Ladder clone() {
        return (Ladder) super.clone();
    }
}
