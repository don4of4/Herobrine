package me.herobrine.data.material;

import me.herobrine.data.DyeColor;
import me.herobrine.data.Material;
import me.herobrine.data.MaterialData;


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
