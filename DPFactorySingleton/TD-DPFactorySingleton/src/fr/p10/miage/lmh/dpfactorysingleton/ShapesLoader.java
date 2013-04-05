package fr.p10.miage.lmh.dpfactorysingleton;

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
			Class.forName("fr.p10.miage.lmh.dpfactorysingleton.Circle");
			Class.forName("fr.p10.miage.lmh.dpfactorysingleton.Square");
		} catch (ClassNotFoundException any) {
			any.printStackTrace();
		}
	}
}
