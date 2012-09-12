package herobrine.data.material;

import herobrine.data.DyeColor;
import herobrine.data.Material;
import herobrine.data.MaterialData;


/**
 * Represents dye
 */
public class Dye extends MaterialData implements Colorable {
	
    public Dye() {
        super(Material.INK_SACK);
    }
    
    public Dye(final int type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current color of this dye
     *
     * @return DyeColor of this dye
     */
    public DyeColor getColor() {
        return DyeColor.getByData((byte) (15 - getData()));
    }

    @Override
    public String toString() {
        return getColor() + " DYE(" + getData() + ")";
    }

    @Override
    public Dye clone() {
        return (Dye) super.clone();
    }
}
