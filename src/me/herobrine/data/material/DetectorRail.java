package me.herobrine.data.material;

import me.herobrine.data.Material;

/**
 * Represents a detector rail
 */
public class DetectorRail extends ExtendedRails implements PressureSensor {
	
    public DetectorRail() {
        super(Material.DETECTOR_RAIL);
    }

    public DetectorRail(final int type, final byte data) {
        super(type, data);
    }

    public boolean isPressed() {
        return (getData() & 0x8) == 0x8;
    }

    @Override
    public DetectorRail clone() {
        return (DetectorRail) super.clone();
    }
}
