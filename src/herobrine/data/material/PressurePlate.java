package herobrine.data.material;

import herobrine.data.Material;
import herobrine.data.MaterialData;


/**
 * Represents a pressure plate
 */
public class PressurePlate extends MaterialData implements PressureSensor {
    public PressurePlate() {
        super(Material.WOOD_PLATE);
    }
    
    public PressurePlate(int type, byte data) {
        super(type, data);
    }

    public boolean isPressed() {
        return getData() == 0x1;
    }

    @Override
    public String toString() {
        return super.toString() + (isPressed() ? " PRESSED" : "");
    }

    @Override
    public PressurePlate clone() {
        return (PressurePlate) super.clone();
    }
}
