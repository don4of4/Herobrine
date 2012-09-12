package herobrine.data.material;

import herobrine.data.CropState;
import herobrine.data.Material;
import herobrine.data.MaterialData;


/**
 * Represents the different types of crops.
 */
public class Crops extends MaterialData {
	
    public Crops() {
        super(Material.CROPS);
    }

    public Crops(final int type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current growth state of this crop
     *
     * @return CropState of this leave
     */
    public CropState getState() {
        return CropState.getByData(getData());
    }

    @Override
    public String toString() {
        return getState() + " " + super.toString();
    }

    @Override
    public Crops clone() {
        return (Crops) super.clone();
    }
}
