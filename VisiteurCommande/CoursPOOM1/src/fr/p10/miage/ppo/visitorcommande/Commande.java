package fr.p10.miage.ppo.visitorcommande;

import java.util.Map;
import java.util.HashMap;

public final class Commande implements PrePostVisitable, Visitable {

	private String name;
	private Map<String,Ligne> lignes = null;

	public Commande(String name) {
		this.name = name;
		this.lignes = new HashMap<String,Ligne>();
	}
	
	// ROLE ?
	// public Commande(String name, String ligneName) {}
	
	public String getName() {
		return name;
	}
	
	public void addLigne(Ligne l) {
		this.lignes.put(l.getName(),l);
	}
	
	@Override
	public void accept(PrePostVisitor visitor) {
		visitor.preVisit(this);
		for(Ligne l: lignes.values())
			l.accept(visitor);
		visitor.postVisit(this);
	}

	@Override
	public void accept(Visitor visitor) {
		for(Ligne l: lignes.values())
			l.accept(visitor);
		visitor.visit(this);
	}

}
