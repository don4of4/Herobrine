package herobrine.data.material;

import herobrine.data.Material;
import herobrine.data.MaterialData;
import herobrine.data.TreeSpecies;


/**
 * Represents the different types of leaves.
 */
public class Leaves extends MaterialData {
    public Leaves() {
        super(Material.LEAVES);
    }

    public Leaves(final int type, final byte data) {
        super(type, data);
    }
    
    /**
     * Gets the current species of this leave
     *
     * @return TreeSpecies of this leave
     */
    public TreeSpecies getSpecies() {
        return TreeSpecies.getByData((byte) (getData() & 3));
    }

    @Override
    public String toString() {
        return getSpecies() + " " + super.toString();
    }

    @Override
    public Leaves clone() {
        return (Leaves) super.clone();
    }
}
