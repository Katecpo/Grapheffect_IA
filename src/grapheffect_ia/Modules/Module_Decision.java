package grapheffect_ia.Modules;

import grapheffect_ia.IA;
import grapheffect_ia.Modules.AutomateModuleDecision.*;

/**
 * Module en charge de la prise de décision
 * @author Matthieu, bd062554
 */
public class Module_Decision extends Module {
    private boolean b = false;
    private Etat etatCourant = null;

    /**
     * Initialise le module de décision
     * @param ia L'IA
     */
    public Module_Decision(IA ia) {
        super(ia);
        this.etatCourant = new Etat_Initial(this);
    }

    /**
     * Méthode principale de prise de décision
     * @param messageRecu Le message de l'automate
     * @return La décision
     */
    public String determinerNouvelleAction(String messageRecu) {
        String reponse = "";
        
        while("".equals(reponse)) {
            etatCourant = etatCourant.transition();
            reponse = etatCourant.messageAEnvoyer();
        }
        
        return reponse;
    }
    
    
}
