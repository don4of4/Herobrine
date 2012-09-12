package herobrine.data.material;

import herobrine.data.Material;

/**
 * Represents a chest
 */
public class Chest extends DirectionalContainer {

    public Chest() {
        super(Material.CHEST);
    }

    public Chest(final int type, final byte data) {
        super(type, data);
    }

    @Override
    public Chest clone() {
        return (Chest) super.clone();
    }
}
