package herobrine.world.entities;

public class EntityVillager extends EntityAgeable {

	/**
     * Represents the various different Villager professions there may be.
     */
    public enum Profession {
        FARMER(0),
        LIBRARIAN(1),
        PRIEST(2),
        BLACKSMITH(3),
        BUTCHER(4);

        private static final Profession[] professions = new Profession[Profession.values().length];
        private final int id;

        static {
            for (Profession type : values()) {
                professions[type.getId()] = type;
            }
        }

        private Profession(int id) {
            this.id = id;
        }

        /**
         * Gets the ID of this profession.
         *
         * @return Profession ID.
         */
        public int getId() {
            return id;
        }

        /**
         * Gets a profession by its ID.
         *
         * @param id ID of the profession to get.
         * @return Resulting profession, or null if not found.
         */
        public static Profession getProfession(int id) {
            return (id >= professions.length) ? null : professions[id];
        }
    }
	
	private net.minecraft.src.EntityVillager entityVillager;
	
	public EntityVillager(net.minecraft.src.EntityVillager entityVillager) {
		super(entityVillager);
		this.entityVillager = entityVillager;
	}

	public Profession getProfession() {
		return Profession.getProfession(entityVillager.getProfession());
	}

}
