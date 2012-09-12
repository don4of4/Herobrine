package herobrine.data;

import static java.lang.Math.*;

public class Position {

	public double x, y, z;
	
	public Position(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Position() {
		
	}

	public Rotation getRotation(Position otherPosition) {
		Rotation rotation = new Rotation();
		rotation.pitch = this.getElevation(otherPosition);
		rotation.yaw = this.getBearing(otherPosition);
		return rotation;
	}
	
	public float getBearing(Position otherPosition) {
		return (float) toDegrees(atan2(otherPosition.z - this.z, otherPosition.x - this.x)) - 90f;
	}
	
	public float getElevation(Position otherPosition) {
		double xDiff = otherPosition.x - this.x;
		double zDiff = otherPosition.z - this.z;
		return (float) -toDegrees(atan2(otherPosition.y - this.y, Math.sqrt(xDiff * xDiff + zDiff * zDiff)));
	}
	
	
	@Override
	public Position clone() {
		return new Position(x, y, z);
	}

	@Override
	public String toString() {
		return String.format("{ x: %.2f, y: %.2f, z: %.2f }", x, y, z);
	}
	
}
