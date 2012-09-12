package herobrine.data.material;

import herobrine.data.DyeColor;
import herobrine.data.Material;
import herobrine.data.MaterialData;


/**
 * Represents a Wool/Cloth block
 */
public class Wool extends MaterialData implements Colorable {
	
    public Wool() {
        super(Material.WOOL);
    }

    public Wool(final int type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current color of this dye
     *
     * @return DyeColor of this dye
     */
    public DyeColor getColor() {
        return DyeColor.getByData(getData());
    }

    @Override
    public String toString() {
        return getColor() + " " + super.toString();
    }

    @Override
    public Wool clone() {
        return (Wool) super.clone();
    }
}
