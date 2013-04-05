package fr.p10.miage.lhm.dpsingleton.tests;

public final class Singleton {
	private Singleton() {} // Constructeur prive ...

		  private static final class SingletonHolder {
		     private static final Singleton INSTANCE =  new Singleton();
		  }

		  public static Singleton getInstance() { // Il n'y a plus de synchronisation
		      return SingletonHolder.INSTANCE;
		  } 
}
