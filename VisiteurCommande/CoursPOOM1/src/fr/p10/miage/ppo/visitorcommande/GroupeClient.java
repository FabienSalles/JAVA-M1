package fr.p10.miage.ppo.visitorcommande;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public final class GroupeClient implements PrePostVisitable, Visitable {

	private String name;
	private Map<String,Client> clients = null;

	public GroupeClient(String name) {
		this.name = name;
		this.clients = new HashMap<String,Client>();
	}
	
	public String getName() {
		return name;
	}
	
	public Collection<Client> getClients() {
		return clients.values();
	}
	
	public void addClient(Client c) {
		this.clients.put(c.getName(),c);
	}
	
	public void addCommande(String cname, Commande cde) throws MonException { // manque dans UML
		Client c = clients.get(cname);
		if (c!=null) { c.addCommande(cde); }
		else throw new MonException("client inconnu");
	}
	
	public void addLigne(String cname, String cdename, Ligne l) throws MonException { // manque dans UML
		Client c = clients.get(cname);
		if (c!=null) { c.addLigne(cdename, l);}
		else throw new MonException("client inconnu");
	}
	
	@Override
	public void accept(PrePostVisitor visitor) {
		visitor.preVisit(this);
		for (Client c: clients.values())
			c.accept(visitor);
		visitor.postVisit(this);
	}

	@Override
	public void accept(Visitor visitor) {
		for (Client c: clients.values())
			c.accept(visitor);
		visitor.visit(this);
	}

}
