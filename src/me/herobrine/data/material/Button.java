package me.herobrine.data.material;

import me.herobrine.data.BlockFace;
import me.herobrine.data.Material;


/**
 * Represents a button
 */
public class Button extends SimpleAttachableMaterialData implements Redstone {
	
    public Button() {
        super(Material.STONE_BUTTON);
    }
    
    public Button(final int type, final byte data) {
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
        }

        return null;
    }

    @Override
    public String toString() {
        return super.toString() + " " + (isPowered() ? "" : "NOT ") + "POWERED";
    }

    @Override
    public Button clone() {
        return (Button) super.clone();
    }
}
