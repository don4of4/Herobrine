package me.herobrine.data.material;


import java.util.ArrayList;
import java.util.List;

import me.herobrine.data.Material;


/**
 * Represents the different types of steps.
 */
public class Step extends TexturedMaterial {
	
    private static final List<Material> textures = new ArrayList<Material>();
    static {
        textures.add(Material.STONE);
        textures.add(Material.SANDSTONE);
        textures.add(Material.WOOD);
        textures.add(Material.COBBLESTONE);
        textures.add(Material.BRICK);
        textures.add(Material.SMOOTH_BRICK);
    }

    public Step() {
        super(Material.STEP);
    }

    public Step(final int type, final byte data) {
        super(type, data);
    }

    @Override
    public List<Material> getTextures() {
        return textures;
    }

    /**
     * Test if step is inverted
     * @return true if inverted (top half), false if normal (bottom half)
     */
    public boolean isInverted() {
        return ((getData() & 0x8) != 0);
    }
    
    @Override
    protected int getTextureIndex() {
        return getData() & 0x7;
    }

    @Override
    public Step clone() {
        return (Step) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + (isInverted()?"inverted":"");
    }
    
}
