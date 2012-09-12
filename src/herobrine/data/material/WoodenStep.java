package herobrine.data.material;

import herobrine.data.Material;
import herobrine.data.MaterialData;
import herobrine.data.TreeSpecies;


/**
 * Represents the different types of wooden steps.
 */
public class WoodenStep extends MaterialData {

    public WoodenStep() {
        super(Material.WOOD_STEP);
    }

    public WoodenStep(final int type, final byte data) {
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
     * Test if step is inverted
     * @return true if inverted (top half), false if normal (bottom half)
     */
    public boolean isInverted() {
        return ((getData() & 0x8) != 0);
    }
    
    @Override
    public WoodenStep clone() {
        return (WoodenStep) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + " " + getSpecies() + (isInverted()?" inverted":"");
    }
}
