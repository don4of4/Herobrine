package me.herobrine.data;

import java.util.HashMap;
import java.util.Map;

import me.herobrine.world.entities.*;


public enum EntityType {
    // These strings MUST match the strings in nms.EntityTypes and are case sensitive.
    DROPPED_ITEM("Item", EntityItem.class, 1, false),
    EXPERIENCE_ORB("XPOrb", EntityExperienceOrb.class, 2),
    PAINTING("Painting", EntityPainting.class, 9),
    ARROW("Arrow", EntityArrow.class, 10),
    SNOWBALL("Snowball", EntitySnowball.class, 11),
    FIREBALL("Fireball", EntityFireball.class, 12),
    SMALL_FIREBALL("SmallFireball", EntitySmallFireball.class, 13),
    ENDER_PEARL("ThrownEnderpearl", EntityEnderPearl.class, 14),
    ENDER_SIGNAL("EyeOfEnderSignal", EntityEnderEye.class, 15),
    THROWN_EXP_BOTTLE("ThrownExpBottle", EntityExperienceBottle.class, 17),
    PRIMED_TNT("PrimedTnt", EntityTNTPrimed.class, 20),
    FALLING_BLOCK("FallingSand", EntityFallingBlock.class, 21, false),
    MINECART("Minecart", EntityMinecart.class, 40),
    BOAT("Boat", EntityBoat.class, 41),
    CREEPER("Creeper", EntityCreeper.class, 50),
    SKELETON("Skeleton", EntitySkeleton.class, 51),
    SPIDER("Spider", EntitySpider.class, 52),
    GIANT("Giant", EntityGiantZombie.class, 53),
    ZOMBIE("Zombie", EntityZombie.class, 54),
    SLIME("Slime", EntitySlime.class, 55),
    GHAST("Ghast", EntityGhast.class, 56),
    PIG_ZOMBIE("PigZombie", EntityPigZombie.class, 57),
    ENDERMAN("Enderman", EntityEnderman.class, 58),
    CAVE_SPIDER("CaveSpider", EntityCaveSpider.class, 59),
    SILVERFISH("Silverfish", EntitySilverfish.class, 60),
    BLAZE("Blaze", EntityBlaze.class, 61),
    MAGMA_CUBE("LavaSlime", EntityMagmaCube.class, 62),
    ENDER_DRAGON("EnderDragon", EntityDragon.class, 63),
    PIG("Pig", EntityPig.class, 90),
    SHEEP("Sheep", EntitySheep.class, 91),
    COW("Cow", EntityCow.class, 92),
    CHICKEN("Chicken", EntityChicken.class, 93),
    SQUID("Squid", EntitySquid.class, 94),
    WOLF("Wolf", EntityWolf.class, 95),
    MUSHROOM_COW("MushroomCow", EntityMushroomCow.class, 96),
    SNOWMAN("SnowMan", EntitySnowman.class, 97),
    OCELOT("Ozelot", EntityOcelot.class, 98),
    IRON_GOLEM("VillagerGolem", EntityIronGolem.class, 99),
    VILLAGER("Villager", EntityVillager.class, 120),
    ENDER_CRYSTAL("EnderCrystal", EntityEnderCrystal.class, 200),
    // These don't have an entity ID in nms.EntityTypes.
    SPLASH_POTION(null, EntityPotion.class, -1, false),
    EGG(null, EntityEgg.class, -1, false),
    FISHING_HOOK(null, EntityFishingHook.class, -1, false),
    
    LIGHTNING(null, EntityLightning.class, -1, false),
    WEATHER(null, EntityWeather.class, -1, false),
    PLAYER(null, EntityPlayer.class, -1, false),
    
    // An unknown entity without an Entity Class
    UNKNOWN(null, null, -1, false);

    private String name;
    private Class<? extends Entity> clazz;
    private short typeId;
    private boolean independent, living;

    private static final Map<String, EntityType> NAME_MAP = new HashMap<String, EntityType>();
    private static final Map<Short, EntityType> ID_MAP = new HashMap<Short, EntityType>();

    static {
        for (EntityType type : values()) {
            if (type.name != null) {
                NAME_MAP.put(type.name.toLowerCase(), type);
            }
            if (type.typeId > 0) {
                ID_MAP.put(type.typeId, type);
            }
        }
    }

    private EntityType(String name, Class<? extends Entity> clazz, int typeId) {
        this(name, clazz, typeId, true);
    }

    private EntityType(String name, Class<? extends Entity> clazz, int typeId, boolean independent) {
        this.name = name;
        this.clazz = clazz;
        this.typeId = (short) typeId;
        this.independent = independent;
        if (clazz != null) {
            this.living = EntityLiving.class.isAssignableFrom(clazz);
        }
    }

    public String getName() {
        return name;
    }

    public Class<? extends Entity> getEntityClass() {
        return clazz;
    }

    public short getTypeId() {
        return typeId;
    }

    public static EntityType fromName(String name) {
        if (name == null) {
            return null;
        }
        return NAME_MAP.get(name.toLowerCase());
    }

    public static EntityType fromId(int id) {
        if (id > Short.MAX_VALUE) {
            return null;
        }
        return ID_MAP.get((short) id);
    }

    /**
     * Some entities cannot be spawned using {@link World#spawnCreature(Location, EntityType)}
     * or {@link World#spawn(Location, Class)}, usually
     * because they require additional information in order to spawn.
     * @return False if the entity type cannot be spawned
     */
    public boolean isSpawnable() {
        return independent;
    }

    public boolean isAlive() {
        return living;
    }
}
