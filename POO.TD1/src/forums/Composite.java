package forums;


import java.util.List;
import java.util.ArrayList;

public class Composite<E> extends Composant {
	
	private List<E> content;
	
	public Composite(String subject)
	{
		super(subject);
		this.content = new ArrayList<E>();
	}
 
	public void add(E composant)
	{
		if (composant != null) {content.add(composant);}
	}
	
	public void remove(int i)
	{
		if (i < 0 || i >= content.size()) return;
		
		content.remove(i);
	}
	
	public int size()
	{
		return content.size();
	}
	
	@Override
	public String toString()
	{
		String s = super.toString() + "\n";
		
		for(E composant : content) {s += composant.toString();}
		
		return s;
	}
	
}
