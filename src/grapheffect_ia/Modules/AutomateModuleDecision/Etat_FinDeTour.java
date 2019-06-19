package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente un état de fin de tour
 * @author bd062554
 */
public class Etat_FinDeTour extends Etat {
    
    /**
     * Créer un état pour finir le tour
     * @param module_decision Le module de décision
     */
    public Etat_FinDeTour(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "FINTOUR";
    }

    @Override
    public Etat transition() {
        /*
        if (this.getModuleMemoire().getVaisseaux().get(0).getOrdre() == null) {
            return new Etat_FinPartie(this.getModule());
        } else {
            return new Etat_GestionVaisseau(this.getModule());
        }
        */
        this.getModuleMemoire().getVaisseaux().forEach((v) -> {
                v.resetPA();
                        
            }); 
        
        return new Etat_GestionDesVaisseaux(this.getModule());
    }
    
}
