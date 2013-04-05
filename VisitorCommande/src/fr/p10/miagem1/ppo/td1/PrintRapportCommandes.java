package fr.p10.miagem1.ppo.td1;

import java.util.Map;
import java.util.HashMap;

public class PrintRapportCommandes implements Visitor {
	
	// a visitor can have a memory space (attributes)
	private Map<String,Integer> factures;
	private int cumul_commande = 0;
	private int cumul_client = 0;
	
	public PrintRapportCommandes() {
		factures = new HashMap<String,Integer>();
		cumul_commande = 0;
		cumul_client = 0;
	}

	@Override
	public void visit(GroupeClient g) {
		for(Client c: g.getClients()) {
			System.out.println("Le client "+c.getName()+" doit "+factures.get(c.getName())+" euros.");
		}
	}

	@Override
	public void visit(Client c) {
		factures.put(c.getName(),cumul_client);
		cumul_client = 0;
	}

	@Override
	public void visit(Commande o) {
		cumul_client += cumul_commande;
		cumul_commande = 0;
	}

	@Override
	public void visit(Ligne l) {
		cumul_commande += l.getSum();
	}

}
