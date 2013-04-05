package fr.p10.miagem1.ppo.td1;

public interface Visitor extends AbstractVisitor {

	 void visit(GroupeClient g);
	 void visit(Client c);
	 void visit(Commande o);
	 void visit(Ligne l);
	
}
