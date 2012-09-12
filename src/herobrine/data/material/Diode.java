package herobrine.data.material;

import herobrine.data.BlockFace;
import herobrine.data.Material;
import herobrine.data.MaterialData;


public class Diode extends MaterialData implements Directional {
	
    public Diode() {
        super(Material.DIODE_BLOCK_ON);
    }

    public Diode(int type, byte data) {
        super(type, data);
    }
    
    /**
     * Gets the delay of the repeater in ticks
     *
     * @return The delay (1-4)
     */
    public int getDelay() {
        return (getData() >> 2) + 1;
    }

    public BlockFace getFacing() {
        byte data = (byte) (getData() & 0x3);

        switch (data) {
        case 0x0:
        default:
            return BlockFace.EAST;

        case 0x1:
            return BlockFace.SOUTH;

        case 0x2:
            return BlockFace.WEST;

        case 0x3:
            return BlockFace.NORTH;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing() + " with " + getDelay() + " ticks delay";
    }

    @Override
    public Diode clone() {
        return (Diode) super.clone();
    }
}
