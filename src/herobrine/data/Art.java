package herobrine.data;

import java.util.HashMap;

import net.minecraft.src.EnumArt;

import org.apache.commons.lang.Validate;

import com.google.common.collect.Maps;

/**
 * Represents the art on a painting
 */
public enum Art {
    KEBAB(0, 1, 1),
    AZTEC(1, 1, 1),
    ALBAN(2, 1, 1),
    AZTEC2(3, 1, 1),
    BOMB(4, 1, 1),
    PLANT(5, 1, 1),
    WASTELAND(6, 1, 1),
    POOL(7, 2, 1),
    COURBET(8, 2, 1),
    SEA(9, 2, 1),
    SUNSET(10, 2, 1),
    CREEBET(11, 2, 1),
    WANDERER(12, 1, 2),
    GRAHAM(13, 1, 2),
    MATCH(14, 2, 2),
    BUST(15, 2, 2),
    STAGE(16, 2, 2),
    VOID(17, 2, 2),
    SKULL_AND_ROSES(18, 2, 2),
    FIGHTERS(19, 4, 2),
    POINTER(20, 4, 4),
    PIGSCENE(21, 4, 4),
    BURNINGSKULL(22, 4, 4),
    SKELETON(23, 4, 3),
    DONKEYKONG(24, 4, 3);

    private int id, width, height;
    private static final HashMap<String, Art> BY_NAME = Maps.newHashMap();
    private static final HashMap<Integer, Art> BY_ID = Maps.newHashMap();

    private Art(int id, int width, int height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the width of the painting, in blocks
     *
     * @return The width of the painting, in blocks
     */
    public int getBlockWidth() {
        return width;
    }

    /**
     * Gets the height of the painting, in blocks
     *
     * @return The height of the painting, in blocks
     */
    public int getBlockHeight() {
        return height;
    }

    /**
     * Get the ID of this painting.
     *
     * @return The ID of this painting
     */
    public int getId() {
        return id;
    }

    /**
     * Get a painting by its numeric ID
     *
     * @param id The ID
     * @return The painting
     */
    public static Art getById(int id) {
        return BY_ID.get(id);
    }

    /**
     * Get a painting by its unique name
     * <p />
     * This ignores underscores and capitalization
     *
     * @param name The name
     * @return The painting
     */
    public static Art getByName(String name) {
        Validate.notNull(name, "Name cannot be null");

        return BY_NAME.get(name.toLowerCase().replaceAll("_", ""));
    }
    
    public static Art convert(EnumArt art) {
        switch (art) {
            case Kebab: return Art.KEBAB;
            case Aztec: return Art.AZTEC;
            case Alban: return Art.ALBAN;
            case Aztec2: return Art.AZTEC2;
            case Bomb: return Art.BOMB;
            case Plant: return Art.PLANT;
            case Wasteland: return Art.WASTELAND;
            case Pool: return Art.POOL;
            case Courbet: return Art.COURBET;
            case Sea: return Art.SEA;
            case Sunset: return Art.SUNSET;
            case Creebet: return Art.CREEBET;
            case Wanderer: return Art.WANDERER;
            case Graham: return Art.GRAHAM;
            case Match: return Art.MATCH;
            case Bust: return Art.BUST;
            case Stage: return Art.STAGE;
            case Void: return Art.VOID;
            case SkullAndRoses: return Art.SKULL_AND_ROSES;
            case Fighters: return Art.FIGHTERS;
            case Pointer: return Art.POINTER;
            case Pigscene: return Art.PIGSCENE;
            case BurningSkull: return Art.BURNINGSKULL;
            case Skeleton: return Art.SKELETON;
            case DonkeyKong: return Art.DONKEYKONG;
        }
        return null;
    }

    public static EnumArt convert(Art art) {
        switch (art) {
            case KEBAB: return EnumArt.Kebab;
            case AZTEC: return EnumArt.Aztec;
            case ALBAN: return EnumArt.Alban;
            case AZTEC2: return EnumArt.Aztec2;
            case BOMB: return EnumArt.Bomb;
            case PLANT: return EnumArt.Plant;
            case WASTELAND: return EnumArt.Wasteland;
            case POOL: return EnumArt.Pool;
            case COURBET: return EnumArt.Courbet;
            case SEA: return EnumArt.Sea;
            case SUNSET: return EnumArt.Sunset;
            case CREEBET: return EnumArt.Creebet;
            case WANDERER: return EnumArt.Wanderer;
            case GRAHAM: return EnumArt.Graham;
            case MATCH: return EnumArt.Match;
            case BUST: return EnumArt.Bust;
            case STAGE: return EnumArt.Stage;
            case VOID: return EnumArt.Void;
            case SKULL_AND_ROSES: return EnumArt.SkullAndRoses;
            case FIGHTERS: return EnumArt.Fighters;
            case POINTER: return EnumArt.Pointer;
            case PIGSCENE: return EnumArt.Pigscene;
            case BURNINGSKULL: return EnumArt.BurningSkull;
            case SKELETON: return EnumArt.Skeleton;
            case DONKEYKONG: return EnumArt.DonkeyKong;
        }
        return null;
    }

    static {
        for (Art art : values()) {
            BY_ID.put(art.id, art);
            BY_NAME.put(art.toString().toLowerCase().replaceAll("_", ""), art);
        }
    }
}
