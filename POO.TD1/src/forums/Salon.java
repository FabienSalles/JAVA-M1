package forums;


public class Salon extends Composite<Message> {
	
	public Salon(String subject) {super(subject);}
	
	@Override
	public void add(Message composant)
	{
		super.add(composant);
	}
	
	@Override
	public String toString()
	{
		return "Salon: " + super.toString();
	}

}
