package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente un état qui demande la carte
 * @author bd062554
 */
public class Etat_Carte extends Etat{
    
    /**
     * Créer un état pour gérer la carte
     * @param module_decision Le module de décision
     */
    public Etat_Carte(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "CARTE";
    }

    @Override
    public Etat transition() {
        Etat ret = null;
        
        if (this.getModuleMemoire().hasBase()) {
            ret = new Etat_BesoinVaisseau(this.getModule());
        } else {
            ret = new Etat_Base(this.getModule());
        }
        
        return ret;
    }
    
}
