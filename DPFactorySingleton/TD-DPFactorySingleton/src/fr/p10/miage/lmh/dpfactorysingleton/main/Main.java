package fr.p10.miage.lmh.dpfactorysingleton.main;

import java.util.Random;

import fr.p10.miage.lmh.dpfactorysingleton.ShapesFactory;
import fr.p10.miage.lmh.dpfactorysingleton.Sheet;

/**
 * Lance la version de l'application Shape avec l'interface et la classe abstraite.
 * Le client ne provoque plus directement le chargement de chaque classe concrète.
 * Cette action est déléguée au ShapesLoader, sous la responsabilité du développeur
 * de l'application Shape. Le code de Factory reste inchangé, ce qui est la caractéristique
 * principale que l'extensibilité doit respecter.
 * @author lom
 *
 */
public class Main {
	protected static Random random = new Random();
	/* Seule responsabilité du client : provoquer le chargement de 
	 * la classe ShapesLoader, qui est responsable du chargement de
	 * des classes concretes de Shape.
	 */
	static
	{
		try
		{
			Class.forName("fr.p10.miage.lmh.dpfactorysingleton.ShapesLoader");
		}
		catch (ClassNotFoundException any)
		{
			any.printStackTrace();
		}
	}
	
	/**
	 * @param args les arguments fournis à cette application.
	 */
	public static void main(String[] args) {
		Sheet sh = new Sheet();
		ShapesFactory instance = ShapesFactory.getInstance();
		for(int i = 0; i<5 ; i++) sh.add(instance.createShape("Circle"));
		for(int i = 0; i<5 ; i++) sh.add(instance.createShape("Square"));
		sh.drawAll();
		sh.get(random.nextInt(sh.size())).move(5,20);
		sh.get(random.nextInt(sh.size())).move(9,3);

	}
}
