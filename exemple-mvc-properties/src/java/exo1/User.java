package exo1;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.util.NoSuchElementException;

public class User {

    private String firstName;
    private String lastName;
    private int userId;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getUserId() {
        return userId;
    }

    public void connect(String path, String user, String password) throws errors,Exception {
        // ContrÙle des paramËtres en entrÈe 

        if (user == "" || user == null || password == "" || password == null) {
            throw new errors("Utilisateur ou mot de passe non renseignÈ !");
        } else {

            // Lecture du fichier des utilisateurs users.properties 
            Properties prop = new Properties();
            FileInputStream in = null;
            try {
                in = new FileInputStream(path + "/WEB-INF/users.properties");
                
            } catch (FileNotFoundException e) {
                throw new errors("erreur sur le fichier");
            }

            prop.load(in);

            String pUser = prop.getProperty(user);

            if (pUser == null) {
                throw new errors("Utilisateur inconnus");
            } else {
                String[] b = pUser.split(";");
                firstName = b[0];
                lastName = b[1];
                if (!(b[2].equals(password))) {
                    throw new errors("Mot de passe invalide");
                }

            }

        }
    }
}
