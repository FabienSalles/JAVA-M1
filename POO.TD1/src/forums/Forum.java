package forums;


public class Forum extends Composite<Theme> {
	
	public Forum(String subject) {super(subject);}
	
	@Override
	public void add(Theme composant)
	{
		super.add(composant);
	}
	
	@Override
	public String toString()
	{
		return "Forum:" + super.toString();
	}
	
	
	public static void main(String[] args)
	{
		Forum forum = new Forum("Programmation orientée objet");
		
		Theme theme1 = new Theme("Constructeurs");
		
		Theme theme2 = new Theme("Design patterns");
		
		Salon salon1 = new Salon("Héritage");
		
		Salon salon2 = new Salon("Composition");
		
		Salon salon3 = new Salon("Pattern Composite");
		
		Message message1 = new Message("J'ai un problème", "voila, j'ai essayé ...");
		Message message2 = new Message("Au secours","ça marche pas ...");
		Message message3 = new Message("Différence ?", "quelle est la différence entre ... ");
		Message message4 = new Message("Question","quand utilise-t-on le pattern composite ?");
		
		forum.add(theme1);
		forum.add(theme2);
		
		theme1.add(salon1);
		theme1.add(salon2);
		theme2.add(salon3);
		
		salon1.add(message1);
		salon1.add(message2);
		salon2.add(message3);
		salon3.add(message4);
		
		System.out.println(forum.toString());
	}
}
