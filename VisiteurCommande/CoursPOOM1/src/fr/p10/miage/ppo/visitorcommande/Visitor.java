package fr.p10.miage.ppo.visitorcommande;

public interface Visitor extends AbstractVisitor {

	 void visit(GroupeClient g);
	 void visit(Client c);
	 void visit(Commande o);
	 void visit(Ligne l);
	
}
