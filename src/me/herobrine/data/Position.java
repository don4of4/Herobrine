package me.herobrine.data;

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

	public Rotation getRotation(Position other) {
		Rotation rotation = new Rotation();
		rotation.pitch = this.getElevation(other);
		rotation.yaw = this.getBearing(other);
		return rotation;
	}
	
	public float getBearing(Position other) {
		return (float) toDegrees(atan2(other.z - this.z, other.x - this.x)) - 90f;
	}
	
	public float getElevation(Position other) {
		double dx = other.x - this.x;
		double dy = other.z - this.z;
		return (float) -toDegrees(atan2(other.y - this.y, Math.sqrt(dx * dx + dy * dy)));
	}
	
	public double distanceTo(Position other) {
		double dx = other.x - this.x;
		double dy = other.y - this.y;
		double dz = other.z - this.z;
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}
	
	public Position addX(double x) {
		this.x += x;
		return this;
	}
	
	public Position addY(double y) {
		this.y += y;
		return this;
	}
	
	public Position addZ(double z) {
		this.z += z;
		return this;
	}
	
	@Override
	public Position clone() {
		return new Position(x, y, z);
	}

	@Override
	public String toString() {
		return String.format("Position { x: %.2f, y: %.2f, z: %.2f }", x, y, z);
	}
	
}
