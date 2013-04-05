package calculette;

//import fr.p10.convertisseur.convertisseurGUI;

public class calculetteMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	new Calculatrice();
            }
        });
		 //Calculatrice calculette = new Calculatrice();
	}

}
