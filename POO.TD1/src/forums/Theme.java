package forums;

public class Theme extends Composite<Salon> {
	
	public Theme(String subject) {super(subject);}
	
	@Override
	public void add(Salon composant)
	{
		super.add(composant);
	}
		
	@Override
	public String toString()
	{
		return "Theme: " + super.toString();
	}

}
