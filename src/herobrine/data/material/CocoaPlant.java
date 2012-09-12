package herobrine.data.material;

import herobrine.data.BlockFace;
import herobrine.data.Material;
import herobrine.data.MaterialData;


/**
 * Represents the cocoa plant
 */
public class CocoaPlant extends MaterialData implements Directional {

    public enum CocoaPlantSize {
        SMALL,
        MEDIUM,
        LARGE
    }
    
    public CocoaPlant() {
        super(Material.COCOA);
    }

    public CocoaPlant(final int type, final byte data) {
        super(type, data);
    }

    /**
     * Get size of plant
     * @return size
     */
    public CocoaPlantSize getSize() {
        switch (getData() & 0xC) {
            case 0:
                return CocoaPlantSize.SMALL;
            case 4:
                return CocoaPlantSize.MEDIUM;
            default:
                return CocoaPlantSize.LARGE;
        }
    }

    public BlockFace getFacing() {
        switch (getData() & 0x3) {
            case 0:
                return BlockFace.WEST;
            case 1:
                return BlockFace.NORTH;
            case 2:
                return BlockFace.EAST;
            case 3:
                return BlockFace.SOUTH;
        }
        return null;
    }
    
    @Override
    public CocoaPlant clone() {
        return (CocoaPlant) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing() + " " + getSize();
    }
}
