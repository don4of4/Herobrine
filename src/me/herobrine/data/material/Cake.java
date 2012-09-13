package me.herobrine.data.material;

import me.herobrine.data.Material;
import me.herobrine.data.MaterialData;


public class Cake extends MaterialData {
	
    public Cake() {
        super(Material.CAKE_BLOCK);
    }

    public Cake(int type, byte data) {
        super(type, data);
    }

    /**
     * Gets the number of slices eaten from this cake
     *
     * @return The number of slices eaten
     */
    public int getSlicesEaten() {
        return getData();
    }

    /**
     * Gets the number of slices remaining on this cake
     *
     * @return The number of slices remaining
     */
    public int getSlicesRemaining() {
        return 6 - getData();
    }

    @Override
    public String toString() {
        return super.toString() + " " + getSlicesEaten() + "/" + getSlicesRemaining() + " slices eaten/remaining";
    }

    @Override
    public Cake clone() {
        return (Cake) super.clone();
    }
}
