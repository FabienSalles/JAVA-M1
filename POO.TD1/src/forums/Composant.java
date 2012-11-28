package forums;

abstract public class Composant {
	
	private String subject;
	
	public Composant(String subject)
	{
		this.subject = subject;
	}
	
	@Override
	public String toString()
	{
		return subject;
	}
	
}
