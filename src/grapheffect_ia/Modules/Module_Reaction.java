package grapheffect_ia.Modules;

import grapheffect_ia.IA;
import grapheffect_ia.Metier.Vaisseaux.Vaisseau;

/**
 * Module en charge de la réaction de l'IA à un message du serveur
 * @author Matthieu
 */
public class Module_Reaction extends Module {

    /**
     * Initialise le module de réaction
     * @param ia L'IA
     */
    public Module_Reaction(IA ia) {
        super(ia);
    }
    
    /**
     * Méthode principale de réaction à un message reçu
     * @param messageEnvoye Le message envoyé par le client
     * @param messageRecu Le message reçu par le serveur
     */
    public void reagirAuMessageRecu(String messageEnvoye, String messageRecu) {
        switch(messageEnvoye) {
            case "CARTE" : reactionCarte(messageRecu); break;
            case "BASE" : reactionBase(messageRecu); break;
            case "FINTOUR" : reactionFinTour(messageRecu); break;
        }
    }

    /**
     * Réagi au message de création de la carte
     * @param messageRecu Le message de la carte
     */
    public void reactionCarte(String messageRecu) {
        this.getIA().getModuleMemoire().genererCarte(messageRecu);
    }
    
    /**
     * Réagi au message BASE
     * @param messageRecu Le message de la base
     */
    public void reactionBase(String messageRecu) {
        this.getIA().getModuleMemoire().setBase(messageRecu);
    }
    
    /**
     * Réagi au message FINTOUR
     * @param messageRecu Le message de fintour
     */
    public void reactionFinTour(String messageRecu) {
        if (messageRecu == "OK") {
            for (Vaisseau v : this.getIA().getModuleMemoire().getVaisseaux()) {
                v.resetPA();
            }
        }
    }
}
