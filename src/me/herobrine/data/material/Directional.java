package me.herobrine.data.material;

import me.herobrine.data.BlockFace;

public interface Directional {

    /**
     * Gets the direction this block is facing
     *
     * @return the direction this block is facing
     */
    public BlockFace getFacing();
}
