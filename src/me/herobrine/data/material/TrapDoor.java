package me.herobrine.data.material;

import me.herobrine.data.BlockFace;
import me.herobrine.data.Material;


/**
 * Represents a trap door
 */
public class TrapDoor extends SimpleAttachableMaterialData implements Openable {
	
    public TrapDoor() {
        super(Material.TRAP_DOOR);
    }
    
    public TrapDoor(final int type, final byte data) {
        super(type, data);
    }

    public boolean isOpen() {
        return ((getData() & 0x4) == 0x4);
    }

    public BlockFace getAttachedFace() {
        byte data = (byte) (getData() & 0x3);

        switch (data) {
            case 0x0:
                return BlockFace.WEST;

            case 0x1:
                return BlockFace.EAST;

            case 0x2:
                return BlockFace.SOUTH;

            case 0x3:
                return BlockFace.NORTH;
        }

        return null;

    }

    @Override
    public String toString() {
        return (isOpen() ? "OPEN " : "CLOSED ") + super.toString() + " with hinges set " + getAttachedFace();
    }

    @Override
    public TrapDoor clone() {
        return (TrapDoor) super.clone();
    }
    
}