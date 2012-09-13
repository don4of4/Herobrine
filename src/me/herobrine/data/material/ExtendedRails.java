package me.herobrine.data.material;

import me.herobrine.data.Material;

/**
 * This is the superclass for the {@link DetectorRail} and {@link PoweredRail} classes
 */
public class ExtendedRails extends Rails {

    public ExtendedRails(final Material type) {
        super(type);
    }

    public ExtendedRails(final int type, final byte data) {
        super(type, data);
    }

    @Override
    public boolean isCurve() {
        return false;
    }

    @Override
    protected byte getConvertedData() {
        return (byte) (getData() & 0x7);
    }

    @Override
    public ExtendedRails clone() {
        return (ExtendedRails) super.clone();
    }
}
