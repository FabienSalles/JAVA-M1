package fr.p10.miage.lmh.dpfactorysingleton;

import java.util.Random;

public abstract class Shapes implements Shape2D {

	protected static Random random = new Random();
	private static int idGenerator = 0;

	// Identifiant, abscisse et ordonnée.
	private int id;
	private int x;
	private int y;

	protected Shapes() {
		this.x = random.nextInt(100) + 1;
		this.y = random.nextInt(100) + 1;
		this.id = genid();
	}

	/**
	 * Jamais utilisée en pratique, puisque son équivalent n'est
	 * pas proposé dans l'interface Shape2D.
	 * @param x
	 * @param y
	 */
	protected Shapes(int x, int y) {
		this();
		this.x = x;
		this.y = y;
	}

	public int getID() {
		return this.id;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	/* Non implémentées. Déléguée aux classes filles. */

	// public abstract void draw();
	
	protected abstract Shapes createShape();

	public void move(int dX, int dY) {
		this.x += dX;
		this.y += dY;
	}

	// Generates id for shapes.
	private static int genid() {
		return ++idGenerator;
	}

}
