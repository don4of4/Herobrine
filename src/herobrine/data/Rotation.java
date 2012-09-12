package herobrine.data;

public class Rotation {

	public float pitch, yaw, roll;

	public Rotation(float pitch, float yaw, float roll) {
		this.pitch = pitch;
		this.yaw = yaw;
		this.roll = roll;
	}

	public Rotation() {
		
	}

	@Override
	public Rotation clone() {
		return new Rotation(pitch, yaw, roll);
	}

	@Override
	public String toString() {
		return String.format("{ pitch: %.2f, yaw: %.2f, roll: %.2f }", pitch, yaw, roll);
	}
	
}
