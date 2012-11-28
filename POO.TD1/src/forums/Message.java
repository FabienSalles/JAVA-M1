package forums;


public class Message extends Composant {
	
	private String content;
	
	public Message(String subject,String content)
	{
		super(subject);
		this.content = content;
	}
	
	@Override
	public String toString()
	{
		return "Message: " + super.toString() + "\n" + content + "\n"; 
	}
}
