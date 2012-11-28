package poo.td3.factorysingleton;

import java.util.HashMap;
import java.util.Map;

public final class ShapesFactory {
	private static volatile ShapesFactory instance = null;
	private static final Map<String, Shapes> REGISTRY = new HashMap<String, Shapes>();

	/**
	 * Constructeur doit être privé.
	 */
	private ShapesFactory() {
		super();
	}

	/**
	 * Double check locking pour l'initialisation du
	 * singleton.
	 * 
	 * @return l'instance du singleton de ShapesFactory
	 */
	public final static ShapesFactory getInstance() {
		ShapesFactory result = instance;
		if (result == null) { // 1er verif sans verrou
			synchronized (ShapesFactory.class) {
				result = instance;
				if (result == null) { // 2eme verif, apres acquisition du verrou
					result = instance = new ShapesFactory();
				}
			}
		}
		return instance;
	}

	public static void registerShape(String name, Shapes s) {
		if (!REGISTRY.containsKey(name))
			REGISTRY.put(name, s);
	}

	public Shapes createShape(String name) {
		if (REGISTRY.containsKey(name))
			return REGISTRY.get(name).createShape();
		else 
			return null;
	}

}
