package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente un état qui envoie un code de triche pour découvrir toute la map
 * @author bd062554
 */
public class Etat_Cheat extends Etat {

    /**
     * Créer un état pour découvrir toute la map (cheatcode)
     * @param module_decision Le module de décision
     */
    public Etat_Cheat(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "ISEEDEADPEOPLE";
    }

    @Override
    public Etat transition() {
        return new Etat_Carte(this.getModule());
    }
    
}
