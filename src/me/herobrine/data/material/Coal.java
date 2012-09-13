package me.herobrine.data.material;

import me.herobrine.data.CoalType;
import me.herobrine.data.Material;
import me.herobrine.data.MaterialData;


/**
 * Represents the different types of coals.
 */
public class Coal extends MaterialData {
	
    public Coal() {
        super(Material.COAL);
    }

    public Coal(final int type, final byte data) {
        super(type, data);
    }

    /**
     * Gets the current type of this coal
     *
     * @return CoalType of this coal
     */
    public CoalType getType() {
        return CoalType.getByData(getData());
    }

    @Override
    public String toString() {
        return getType() + " " + super.toString();
    }

    @Override
    public Coal clone() {
        return (Coal) super.clone();
    }
}
