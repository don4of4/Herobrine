package herobrine.data.material;

import herobrine.data.BlockFace;
import herobrine.data.Material;
import herobrine.data.MaterialData;
import herobrine.data.TreeSpecies;


/**
 * Represents the different types of Trees.
 */
public class Tree extends MaterialData {
	
    public Tree() {
        super(Material.LOG);
    }

    public Tree(final int type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current species of this tree
     *
     * @return TreeSpecies of this tree
     */
    public TreeSpecies getSpecies() {
        return TreeSpecies.getByData((byte) (getData() & 0x3));
    }

    /**
     * Get direction of the log
     * 
     * @return BlockFace.TOP for upright (default), BlockFace.EAST (east-west), BlockFace.NORTH (north-sout), BlockFace.SELF (directionless)
     */
    public BlockFace getDirection() {
        switch ((getData() >> 2) & 0x3) {
            case 0: // Up-down
            default:
                return BlockFace.UP;
            case 1: // North-south
                return BlockFace.NORTH;
            case 2: // East-west
                return BlockFace.EAST;
            case 3: // Directionless (bark on all sides)
                return BlockFace.SELF;
        }
    }

    @Override
    public String toString() {
        return getSpecies() + " " + getDirection() + " " + super.toString();
    }

    @Override
    public Tree clone() {
        return (Tree) super.clone();
    }
}
