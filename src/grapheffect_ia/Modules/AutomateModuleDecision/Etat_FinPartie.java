package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente un état pour finir la partie
 * @author bd062554
 */
public class Etat_FinPartie extends Etat {

    /**
     * Créer un nouvel état de fin de partie
     * @param module_decision 
     */
    public Etat_FinPartie(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "FIN";
    }

    @Override
    public Etat transition() {
        return this;
    }
    
}
