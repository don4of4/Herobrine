package herobrine.data.material;

import herobrine.data.Material;
import herobrine.data.MaterialData;


/**
 * Represents the tripwire
 */
public class Tripwire extends MaterialData {
    
    public Tripwire() {
        super(Material.TRIPWIRE);
    }

    public Tripwire(final int type, final byte data) {
        super(type, data);
    }

    /**
     * Test if tripwire is currently activated
     * @return true if activated, false if not
     */
    public boolean isActivated() {
        return (getData() & 0x4) != 0;
    }
    
    /**
     * Test if object triggering this tripwire directly
     * @return true if object activating tripwire, false if not
     */
    public boolean isObjectTriggering() {
        return (getData() & 0x1) != 0;
    }

    @Override
    public Tripwire clone() {
        return (Tripwire) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + (isActivated()?" Activated":"") + (isObjectTriggering()?" Triggered":"");
    }
    
}
