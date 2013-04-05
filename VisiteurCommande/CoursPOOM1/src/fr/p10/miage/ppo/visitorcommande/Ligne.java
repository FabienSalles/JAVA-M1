package fr.p10.miage.ppo.visitorcommande;

public final class Ligne implements PrePostVisitable, Visitable {

	private String name;
	private int sum;
	
	public Ligne(String name) {
		this.name = name;
		this.sum = 0;
	}
	
	public Ligne(String name, int sum) {
		this(name);
		this.sum = sum;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSum() {
		return sum;
	}
	
	@Override
	public void accept(PrePostVisitor visitor) {
		visitor.preVisit(this);
		visitor.postVisit(this);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
