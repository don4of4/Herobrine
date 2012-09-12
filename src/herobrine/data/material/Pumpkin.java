package herobrine.data.material;

import herobrine.data.BlockFace;
import herobrine.data.Material;
import herobrine.data.MaterialData;


/**
 * Represents a pumpkin.
 */
public class Pumpkin extends MaterialData implements Directional {

    public Pumpkin() {
        super(Material.PUMPKIN);
    }

    public Pumpkin(final int type, final byte data) {
        super(type, data);
    }
    
    public boolean isLit() {
        return getItemType() == Material.JACK_O_LANTERN;
    }

    public BlockFace getFacing() {
        byte data = getData();

        switch (data) {
        case 0x0:
            return BlockFace.EAST;

        case 0x1:
            return BlockFace.SOUTH;

        case 0x2:
            return BlockFace.WEST;

        case 0x3:
        default:
            return BlockFace.SOUTH;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing() + " " + (isLit() ? "" : "NOT ") + "LIT";
    }

    @Override
    public Pumpkin clone() {
        return (Pumpkin) super.clone();
    }
}
