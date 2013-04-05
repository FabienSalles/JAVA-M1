package sphere;

import java.util.Observable;

public class Sphere extends Observable {

	private double myRadius;
	private double myCenterX;
	private double myCenterY;

	public Sphere(double x, double y, double r) {
		myCenterX = x;
		myCenterY = y;
		myRadius = r;
	}

	// Eventuellement d'autres constructeurs

	public double getRadius() {
		return myRadius;
	}

	public void setRadius(double r) {
		myRadius = r;
		setChanged();
		notifyObservers();
	}

	// Eventuellement d'autres accesseurs et modificateurs

	public double volume() {
		return 4.0 / 3.0 * Math.PI * Math.pow(myRadius, 3);
	}

	public double surfaceArea() {
		return 4.0 * Math.PI * Math.pow(myRadius, 2);
	}

	public String toString() {
		return "Sphere [Center = (" + myCenterX + ", " + myCenterY
				+ ") Radius = " + myRadius + "]";
	}
}
