package planetarium;

import java.util.HashMap;

/**
 * Enumeration specificant les planetes du systeme solaire.
 * @author lom
 *
 */
public enum PlaneteSolaire {
MERCURE("Mercure"), VENUS("Venus"), TERRE("Terre"), MARS("Mars"), JUPITER(
			"Jupiter"), SATURNE("Saturne"), URANUS("Uranus"), NEPTUNE("Neptune");

	/**
	 * Association entre les noms des planetes et les noms des fichiers de
	 * description des planetes
	 */
	private static HashMap<String, String> planeteDescFile = new HashMap<String, String>();

	/**
	 * Association entre les noms des planetes et les noms des fichiers images
	 * des planetes
	 */
	private static HashMap<String, String> planeteImageFile = new HashMap<String, String>();

	static {
		planeteDescFile.put(MERCURE.getName(), "mercure.txt");
		planeteDescFile.put(VENUS.getName(), "venus.txt");
		planeteDescFile.put(TERRE.getName(), "terre.txt");
		planeteDescFile.put(MARS.getName(), "mars.txt");
		planeteDescFile.put(JUPITER.getName(), "jupiter.txt");
		planeteDescFile.put(SATURNE.getName(), "saturne.txt");
		planeteDescFile.put(URANUS.getName(), "uranus.txt");
		planeteDescFile.put(NEPTUNE.getName(), "neptune.txt");
	}

	static {
		planeteImageFile.put(MERCURE.getName(), "mercure.png");
		planeteImageFile.put(VENUS.getName(), "venus.png");
		planeteImageFile.put(TERRE.getName(), "terre.png");
		planeteImageFile.put(MARS.getName(), "mars.png");
		planeteImageFile.put(JUPITER.getName(), "jupiter.png");
		planeteImageFile.put(SATURNE.getName(), "saturne.png");
		planeteImageFile.put(URANUS.getName(), "uranus.png");
		planeteImageFile.put(NEPTUNE.getName(), "neptune.png");
	}

	private String name;

	private PlaneteSolaire(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static String getPlanetDescFileName(String planetName) {
		return planeteDescFile.get(planetName);
	}
	
	public static String getPlanetImageFileName(String planetName) {
		return planeteImageFile.get(planetName);
	}

}
