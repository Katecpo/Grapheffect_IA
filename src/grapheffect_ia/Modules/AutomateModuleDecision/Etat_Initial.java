package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente l'état initial de l'IA & de l'automate
 * @author bd062554
 */
public class Etat_Initial extends Etat {
    
    /**
     * Créer l'état initial de l'automate
     * @param module_decision Le module de décision
     */
    public Etat_Initial(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "";
    }

    @Override
    public Etat transition() {
        //return new Etat_Cheat(this.getModule());
        return new Etat_Carte(this.getModule()); // Test avec 2 explorateurs + 1 constructeur
    }
    
}
