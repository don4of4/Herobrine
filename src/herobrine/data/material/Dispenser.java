package herobrine.data.material;

import herobrine.data.Material;

/**
 * Represents a dispenser.
 */
public class Dispenser extends FurnaceAndDispenser {

    public Dispenser() {
        super(Material.DISPENSER);
    }

    public Dispenser(final int type, final byte data) {
        super(type, data);
    }

    @Override
    public Dispenser clone() {
        return (Dispenser) super.clone();
    }
}
