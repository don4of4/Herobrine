package me.herobrine.data.material;


import java.util.List;

import me.herobrine.data.Material;
import me.herobrine.data.MaterialData;


/**
 * Represents textured materials like steps and smooth bricks
 */
public abstract class TexturedMaterial extends MaterialData {

    public TexturedMaterial(Material m) {
        super(m);
    }

    public TexturedMaterial(final int type, final byte data) {
        super(type, data);
    }

    /**
     * Retrieve a list of possible textures. The first element of the list will be used as a default.
     *
     * @return a list of possible textures for this block
     */
    public abstract List<Material> getTextures();

    /**
     * Gets the current Material this block is made of
     *
     * @return Material of this block
     */
    public Material getMaterial() {
        int n = getTextureIndex();
        if (n > getTextures().size() - 1) {
            n = 0;
        }

        return getTextures().get(n);
    }

    /**
     * Get material index from data
     * @return index of data in textures list
     */
    protected int getTextureIndex() {
        return getData(); // Default to using all bits - override for other mappings
    }

    @Override
    public String toString() {
        return getMaterial() + " " + super.toString();
    }

    @Override
    public TexturedMaterial clone() {
        return (TexturedMaterial) super.clone();
    }
}
