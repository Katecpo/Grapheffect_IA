package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;
import grapheffect_ia.Modules.Module_Memoire;

/**
 * État d'un automate fini
 * @author bd062554
 */
public abstract class Etat {
    private Module_Decision module_decision = null;

    /**
     * Créer un état
     * @param module_decision Le module de décision
     */
    public Etat(Module_Decision module_decision) {
        this.module_decision = module_decision;
    }
    
    /**
     * Renvoie le module de décision
     * @return Module de décision
     */
    public Module_Decision getModule() {
        return this.module_decision;
    }
    
    /**
     * Renvoie le module mémoire
     * @return Module mémoire
     */
    public Module_Memoire getModuleMemoire() {
        return this.module_decision.getIA().getModuleMemoire();
    }
    
    /**
     * Déduit le message à envoyer au serveur
     * @return Message
     */
    public abstract String messageAEnvoyer();
    
    /**
     * Retourne la transition suivante
     * @return Etat
     */
    public abstract Etat transition();
    
    
}
