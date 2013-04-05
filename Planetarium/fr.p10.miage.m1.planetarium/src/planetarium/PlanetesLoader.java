package planetarium;

public final class PlanetesLoader {

	private PlanetesLoader() {
		super();
	}
	
	private static PlaneteSolaire planetes[] = PlaneteSolaire.values();
	private static String[] listePlanetes;
	
	public static String[] getListeNomsPlanetes(){
		listePlanetes = new String[planetes.length];
		for (int i = 0; i < planetes.length; i++) {
			listePlanetes[i] = planetes[i].getName();
		}
		return listePlanetes;
	}
	
	public static PlaneteSolaire[] getListePlanetes(){
		return planetes;
	}
}
