package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente un état pour gérer la position de la base
 * @author bd062554
 */
public class Etat_Base extends Etat {
    
    /**
     * Créer un état de gestion de la base
     * @param module_decision Le module de décision
     */
    public Etat_Base(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "BASE";
    }

    @Override
    public Etat transition() {
        return new Etat_BesoinVaisseau(this.getModule());
    }
    
}
