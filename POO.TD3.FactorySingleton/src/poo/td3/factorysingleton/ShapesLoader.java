package poo.td3.factorysingleton;

/**
 * Provoque le chargement des classes concrètes.
 * Sera modifié chaque fois qu'une nouvelle classe concrete sera ajoutée.
 * On peut aussi utiliser les .properties pour provoquer dynamiquement
 * ce chargement. 
 * @author lom
 *
 */
public class ShapesLoader {
	static {
		try {
			Class.forName("poo.td3.factorysingleton.Circle");
			Class.forName("poo.td3.factorysingleton.Square");
		} catch (ClassNotFoundException any) {
			any.printStackTrace();
		}
	}
}
