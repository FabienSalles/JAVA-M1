package fr.p10.miage.ppo.visitorcommande;

public interface PrePostVisitor extends AbstractVisitor {

	 void preVisit(GroupeClient g);
	 void preVisit(Client c);
	 void preVisit(Commande o);
	 void preVisit(Ligne l);
	 void postVisit(GroupeClient g);
	 void postVisit(Client c);
	 void postVisit(Commande o);
	 void postVisit(Ligne l);
	
}
