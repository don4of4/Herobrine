package me.herobrine.data;


/**
 * Handles specific metadata for certain items or blocks
 */
public class MaterialData implements Cloneable {
    private final int type;
    private byte data = 0;

    public MaterialData(final int type) {
        this(type, (byte) 0);
    }

    public MaterialData(final Material type) {
        this(type, (byte) 0);
    }

    public MaterialData(final int type, final byte data) {
        this.type = type;
        this.data = data;
    }

    public MaterialData(final Material type, final byte data) {
        this(type.getId(), data);
    }

    /**
     * Gets the raw data in this material
     *
     * @return Raw data
     */
    public byte getData() {
        return data;
    }

    /**
     * Gets the Material that this MaterialData represents
     *
     * @return Material represented by this MaterialData
     */
    public Material getItemType() {
        return Material.getMaterial(type);
    }

    /**
     * Gets the Material Id that this MaterialData represents
     *
     * @return Material Id represented by this MaterialData
     */
    public int getItemTypeId() {
        return type;
    }

    @Override
    public String toString() {
        return getItemType() + "(" + getData() + ")";
    }

    @Override
    public int hashCode() {
        return ((getItemTypeId() << 8) ^ getData());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MaterialData) {
            MaterialData md = (MaterialData) obj;

            return (md.getItemTypeId() == getItemTypeId() && md.getData() == getData());
        }
		return false;
    }

    @Override
    public MaterialData clone() {
        try {
            return (MaterialData) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error(e);
        }
    }
}
