package fr.p10.miage.lmh.dpfactorysingleton;


public final class Circle extends Shapes {

	private int radius;
	
	static {
		ShapesFactory.registerShape("Circle", new Circle());
	}

	private Circle() {
		super();
		this.radius = random.nextInt(100)+1;
	}

	private Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println ("Drawing CIRCLE #"+this.getID() + " : Origin=[" + this.getX() + "," + this.getY() + "], Radius=" + this.radius);
	}

	@Override
	public void move(int dX, int dY)
	{
		super.move(dX,dY);
		System.out.println ("Moving CIRCLE #" + this.getID() + " by x=" + dX + ", y=" + dY);
		this.draw();
	}

	@Override
	protected Shapes createShape() {
		return new Circle();
	}
}
