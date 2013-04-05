package fr.p10.miage.ppo.visitorcommande;

import java.util.Map;
import java.util.HashMap;

public final class Client implements PrePostVisitable, Visitable {

	private String name;
	protected Map<String,Commande> commandes = null;
	
	public Client(String name) {
		this.name = name;
		this.commandes = new HashMap<String,Commande>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addCommande(Commande c) {
		this.commandes.put(c.getName(),c);
	}
	
	public void addLigne(String cdename, Ligne l) throws MonException { // manque dans UML
		Commande c = this.commandes.get(cdename);
		if (c!=null) { c.addLigne(l); }
		else throw new MonException("commande inconnue");
	}
	
	public void accept(PrePostVisitor visitor) {
		visitor.preVisit(this);
		for(Commande c: commandes.values())
			c.accept(visitor);
		visitor.postVisit(this);
	}

	@Override
	public void accept(Visitor visitor) {
		for(Commande c: commandes.values())
			c.accept(visitor);
		visitor.visit(this);		
	}

}
