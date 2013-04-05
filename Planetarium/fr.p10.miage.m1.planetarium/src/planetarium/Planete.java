package planetarium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Observable;

public class Planete extends Observable {
	/**
	 * Association entre les planetes et leur description.
	 */
	private static HashMap<String, StringBuffer> planeteDescription = new HashMap<String, StringBuffer>();
	/**
	 * Association entre les planetes et l'adresse de leur image
	 */
	private static HashMap<String, URL> planeteImageURL = new HashMap<String, URL>();

	private static String[] listePlanetes;
	
	private static final String descPath = "descriptions/";
	
	private static final String imagePath = "images/";
	/**
	 * Planete actuellement selectionnee dans le GUI.
	 */
	private PlaneteSolaire selectedPlanet;

	/**
	 * Initialement, charger les descriptions des planetes.
	 */
	public Planete() {
		listePlanetes = PlanetesLoader.getListeNomsPlanetes();
		ClassLoader cl = getClass().getClassLoader();
		// Charger la description des planetes et les URLs des fichiers d'image
		for (String pl : listePlanetes) {
			StringBuffer plDesc = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(cl
					.getResourceAsStream(descPath + PlaneteSolaire
							.getPlanetDescFileName(pl))));
			String line;
			try {
				while ((line = br.readLine()) != null) {
					plDesc.append(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			planeteDescription.put(Enum.valueOf(PlaneteSolaire.class, pl.toUpperCase()).getName(),
					plDesc);
			//charger les URL des fichiers d'image.
			URL plImageURL = getURLOfResource(imagePath + PlaneteSolaire.getPlanetImageFileName(pl));
			planeteImageURL.put(Enum.valueOf(PlaneteSolaire.class, pl.toUpperCase()).getName(), plImageURL);
		}
	}

	public void setSelectedPlanet(PlaneteSolaire pl) {
		selectedPlanet = pl;
		setChanged();
		notifyObservers();
	}

	public String getSelectedPlanetDescription() {
		return planeteDescription.get(selectedPlanet.getName()).toString();
	}

	public URL getSelectedPlanetImageURL() {
		return planeteImageURL.get(selectedPlanet.getName());
	}

	public URL getURLOfResource(String res) {
		return getClass().getClassLoader().getResource(res);
	}

	public String getSelectedPlanetName() {
		// TODO Auto-generated method stub
		return this.selectedPlanet.getName();
	}

}
