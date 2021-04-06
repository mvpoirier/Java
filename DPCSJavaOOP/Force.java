public class Force {
	// Data
	// private = no direct access outside of this class
	private double mass;
	private double acceleration;
	private int angle;

	// Constructor
	Force (double mass, double acceleration, int angle){
		this.mass = mass;
		this.acceleration = acceleration;
		this.angle = angle;
	}

	// Actions
	public double getForce() {
		return mass * acceleration;
	}

	public void print() {
		System.out.println("mass = " + mass + " kg");
		System.out.println("acceleration = " + acceleration + " m/s/s");
		System.out.println("angle = " + angle + " degrees");
		System.out.println("force = " + this.getForce() + " N");
	}
}