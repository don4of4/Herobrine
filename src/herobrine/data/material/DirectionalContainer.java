package herobrine.data.material;

import herobrine.data.BlockFace;
import herobrine.data.Material;
import herobrine.data.MaterialData;


/**
 * Represents a furnace or a dispenser.
 */
public class DirectionalContainer extends MaterialData implements Directional {

	public DirectionalContainer(final Material type) {
		super(type);
	}

	public DirectionalContainer(final int type, final byte data) {
		super(type, data);
	}

	public BlockFace getFacing() {
		byte data = getData();

		switch (data) {
		case 0x2:
			return BlockFace.EAST;

		case 0x3:
			return BlockFace.WEST;

		case 0x4:
			return BlockFace.NORTH;

		case 0x5:
		default:
			return BlockFace.SOUTH;
		}
	}

	@Override
	public String toString() {
		return super.toString() + " facing " + getFacing();
	}

	@Override
	public DirectionalContainer clone() {
		return (DirectionalContainer) super.clone();
	}
}
