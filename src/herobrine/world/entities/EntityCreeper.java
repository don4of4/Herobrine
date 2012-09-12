package herobrine.world.entities;

public class EntityCreeper extends EntityMonster {

	public enum State {
		IDLE, FUSE
	}

	private net.minecraft.src.EntityCreeper entityCreeper;

	public EntityCreeper(net.minecraft.src.EntityCreeper entityCreeper) {
		super(entityCreeper);
		this.entityCreeper = entityCreeper;
	}

	public boolean isPowered() {
		return entityCreeper.getPowered();
	}

	public State getState() {
		switch (entityCreeper.getCreeperState()) {
		case -1:
			return State.IDLE;
		case 1:
			return State.FUSE;
		default:
			return State.IDLE;
		}
	}

}
