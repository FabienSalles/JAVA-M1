package fr.p10.miage.ppo.visitorcommande;

public final class XMLRapportCommandes implements PrePostVisitor {

	@Override
	public void preVisit(GroupeClient g) {
		System.out.println("<groupe>");
	}
	
	@Override
	public void postVisit(GroupeClient g) {
		System.out.println("</groupe>");
	}
	
	@Override
	public void preVisit(Client c) {
		System.out.println("<client name=\""+c.getName()+"\">");
	}
	
	@Override
	public void postVisit(Client c) {
		System.out.println("</client>");
	}
	
	@Override
	public void preVisit(Commande o) {
		System.out.println("<commande name=\""+o.getName()+"\">");
	}

	@Override
	public void postVisit(Commande o) {
		System.out.println("</commande>");
	}

	@Override
	public void preVisit(Ligne l) {
		System.out.println("<ligne name=\""+l.getName()+"\" sum="+l.getSum()+" />");
	}

	@Override
	public void postVisit(Ligne l) {
	}

}
