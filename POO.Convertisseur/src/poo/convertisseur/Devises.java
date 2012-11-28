package poo.convertisseur;

public enum Devises {
	DOLLAR_US("dollar US"), DOLLAR_CAN("dollar CAN"), EURO("euro");
	
	private Devises(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public static Devises getDeviseFromString(String name) {
		
		if ("dollar US".equalsIgnoreCase(name)) 
			return Devises.DOLLAR_US;
		else if ("dollar CAN".equalsIgnoreCase(name))
			return Devises.DOLLAR_CAN;
		else
			return Devises.EURO;
	}
	
	public static double rate(Devises dev1, Devises dev2) {
		if(dev1 == DOLLAR_US && dev2 == DOLLAR_CAN)
			return 1.227;
		else if (dev1 == DOLLAR_CAN && dev2 == DOLLAR_US)
			return 0.815;
		else if (dev1 == EURO && dev2 == DOLLAR_US)
			return 1.323;
		else if (dev1 == DOLLAR_US && dev2 == EURO)
			return 0.756;
		else if (dev1 == DOLLAR_CAN && dev2 == EURO)
			return 0.616;
		else if (dev1 == EURO && dev2 == DOLLAR_CAN)
			return 1.623;
		else 
			return 1;
	}
	
	private String name;
}
