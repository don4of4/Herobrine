package herobrine.data.material;

import herobrine.data.Material;

/**
 * Represents an ender chest
 */
public class EnderChest extends DirectionalContainer {

    public EnderChest() {
        super(Material.ENDER_CHEST);
    }

    public EnderChest(final int type, final byte data) {
        super(type, data);
    }

    @Override
    public EnderChest clone() {
        return (EnderChest) super.clone();
    }
    
}
