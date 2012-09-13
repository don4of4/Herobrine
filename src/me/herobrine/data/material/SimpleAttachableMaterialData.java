package me.herobrine.data.material;

import me.herobrine.data.BlockFace;
import me.herobrine.data.Material;
import me.herobrine.data.MaterialData;


/**
 * Simple utility class for attachable MaterialData subclasses
 */
public abstract class SimpleAttachableMaterialData extends MaterialData implements Attachable {

    protected SimpleAttachableMaterialData(Material type) {
        super(type);
    }

    public SimpleAttachableMaterialData(int type, byte data) {
        super(type, data);
    }
    
    public BlockFace getFacing() {
        BlockFace attachedFace = getAttachedFace();
        return attachedFace == null ? null : attachedFace.getOppositeFace();
    }

    @Override
    public String toString() {
        return super.toString() + " facing " + getFacing();
    }

    @Override
    public SimpleAttachableMaterialData clone() {
        return (SimpleAttachableMaterialData) super.clone();
    }
}
