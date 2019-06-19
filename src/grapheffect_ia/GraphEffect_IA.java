package grapheffect_ia;

import java.io.IOException;

/**
 * Point d'entrée du programme
 * @author Matthieu
 */
public class GraphEffect_IA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            IA nouvelleIA = new IA();
            nouvelleIA.start();
        } catch (IOException ex) {
            System.err.println("Problème de connexion avec le serveur");
        }
    }
    
}
