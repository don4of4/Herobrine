package herobrine.data.material;

import herobrine.data.BlockFace;
import herobrine.data.Material;
import herobrine.data.MaterialData;

import java.util.EnumSet;
import java.util.Set;

import org.apache.commons.lang.Validate;

/**
 * Represents a huge mushroom block
 */
public class Mushroom extends MaterialData {
    private static final byte SHROOM_NONE = 0;
    private static final byte SHROOM_STEM = 10;
    private static final byte NORTH_LIMIT = 4;
    private static final byte SOUTH_LIMIT = 6;
    private static final byte EAST_WEST_LIMIT = 3;
    private static final byte EAST_REMAINDER = 0;
    private static final byte WEST_REMAINDER = 1;
    @SuppressWarnings("unused")
	private static final byte NORTH_SOUTH_MOD = 3;
    @SuppressWarnings("unused")
	private static final byte EAST_WEST_MOD = 1;

    public Mushroom(int type, byte data) {
        super(type, data);
        Validate.isTrue(type == Material.HUGE_MUSHROOM_1.getId() || type == Material.HUGE_MUSHROOM_2.getId(), "Not a mushroom!");
    }

    /**
     * @return Whether this is a mushroom stem.
     */
    public boolean isStem() {
        return getData() == SHROOM_STEM;
    }

    /**
     * Checks whether a face of the block is painted.
     * @param face The face to check.
     * @return True if it is painted.
     */
    public boolean isFacePainted(BlockFace face) {
        byte data = getData();

        if (data == SHROOM_NONE || data == SHROOM_STEM) {
            return false;
        }

        switch (face) {
            case NORTH:
                return data < NORTH_LIMIT;
            case SOUTH:
                return data > SOUTH_LIMIT;
            case EAST:
                return data % EAST_WEST_LIMIT == EAST_REMAINDER;
            case WEST:
                return data % EAST_WEST_LIMIT == WEST_REMAINDER;
            case UP:
                return true;
            default:
                return false;
        }
    }
    
    /**
     * @return A set of all faces that are currently painted (an empty set if it is a stem)
     */
    public Set<BlockFace> getPaintedFaces() {
        EnumSet<BlockFace> faces = EnumSet.noneOf(BlockFace.class);

        if (isFacePainted(BlockFace.NORTH)) {
            faces.add(BlockFace.NORTH);
        }

        if (isFacePainted(BlockFace.EAST)) {
            faces.add(BlockFace.EAST);
        }

        if (isFacePainted(BlockFace.WEST)) {
            faces.add(BlockFace.WEST);
        }

        if (isFacePainted(BlockFace.SOUTH)) {
            faces.add(BlockFace.SOUTH);
        }

        if (isFacePainted(BlockFace.UP)) {
            faces.add(BlockFace.UP);
        }

        return faces;
    }

    @Override
    public String toString() {
        return Material.getMaterial(getItemTypeId()).toString() + (isStem() ? "{STEM}" : getPaintedFaces());
    }

    @Override
    public Mushroom clone() {
        return (Mushroom) super.clone();
    }
}
