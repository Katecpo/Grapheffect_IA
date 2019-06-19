package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Metier.Vaisseaux.Vaisseau;
import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente un état pour la gestion des vaisseaux en mémoire
 * @author bd062554
 */
public class Etat_GestionDesVaisseaux extends Etat {
    
    /**
     * Créer un état qui gère les vaisseaux en mémoire
     * @param module_decision Le module de décision
     */
    public Etat_GestionDesVaisseaux(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "";
    }

    @Override
    public Etat transition() {
        this.getModuleMemoire().vaisseauSuivant(); 
        Etat nouvelEtat = new Etat_FinDeTour(getModule()); 
        int sommePA = 0; 
        
        for(Vaisseau v : this.getModuleMemoire().getVaisseaux()) { 
            if (v.isActif()) {
                sommePA += v.getPA(); 
            }
        } 
        
        if(sommePA > 0) { 
            while(this.getModuleMemoire().getVaisseauEnCours().getPA() == 0 && this.getModuleMemoire().getVaisseauEnCours().isActif()) { 
                this.getModuleMemoire().vaisseauSuivant(); 
            } 
            
            nouvelEtat = new Etat_Mouvement(getModule(),this. getModuleMemoire().getVaisseauEnCours()); 
            if(this.getModuleMemoire().getVaisseauEnCours().getOrdre() == null) { 
                nouvelEtat = new Etat_ChoixDestination(getModule(), this.getModuleMemoire().getVaisseauEnCours()); 
            } 
        } 
        
        return nouvelEtat; 
    }
    
}
