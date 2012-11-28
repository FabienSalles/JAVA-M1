package poo.td3.factorysingleton;

public final class Square extends Shapes {
	static {
		ShapesFactory.registerShape("Square", new Square());
	}
	
	private int side;

	private Square() {
		super();
		this.side = random.nextInt(100) + 1;
	}

	private Square(int x, int y, int side) {
		super(x, y);
		this.side = side;
	}

	@Override
	public void draw() {
		System.out.println("Drawing SQUARE #" + this.getID() + " : Origin=["
				+ this.getX() + "," + this.getY() + "], Side=" + this.side);
	}

	@Override
	public void move(int dX, int dY) {
		super.move(dX, dY);
		System.out.println("Moved SQUARE #" + this.getID() + " by x=" + dX
				+ ", y=" + dY);
		this.draw();
	}

	@Override
	protected Shapes createShape() {
		return new Square();
	}

}
