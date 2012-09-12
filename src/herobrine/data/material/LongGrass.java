package herobrine.data.material;

import herobrine.data.GrassSpecies;
import herobrine.data.Material;
import herobrine.data.MaterialData;


/**
 * Represents the different types of long grasses.
 */
public class LongGrass extends MaterialData {
    public LongGrass() {
        super(Material.LONG_GRASS);
    }

    public LongGrass(final int type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current species of this grass
     *
     * @return GrassSpecies of this grass
     */
    public GrassSpecies getSpecies() {
        return GrassSpecies.getByData(getData());
    }

    @Override
    public String toString() {
        return getSpecies() + " " + super.toString();
    }

    @Override
    public LongGrass clone() {
        return (LongGrass) super.clone();
    }
}
