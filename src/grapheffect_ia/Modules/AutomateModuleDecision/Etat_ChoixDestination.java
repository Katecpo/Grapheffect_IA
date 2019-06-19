package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Metier.Vaisseaux.Vaisseau;
import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente un état de choix de destination d'un vaisseau
 * @author bd062554
 */
public class Etat_ChoixDestination extends Etat {
    private Vaisseau vaisseau = null;
    
    /**
     * Créer un état pour gérer la destination d'un vaisseau
     * @param module_decision Le module de décision
     * @param vaisseau Le vaisseau
     */
    public Etat_ChoixDestination(Module_Decision module_decision, Vaisseau vaisseau) {
        super(module_decision);
        this.vaisseau = vaisseau;
    }

    @Override
    public String messageAEnvoyer() {
        return "";
    }

    @Override
    public Etat transition() {
        Etat ret = null;
        
        switch(vaisseau.getType())
        {
            case Explorateur:
                ret = new Etat_ChoixDestination_Explorateur(this.getModule(),vaisseau);
                break;
            case Constructeur:
                ret = new Etat_ChoixDestination_Constructeur(this.getModule(),vaisseau);
                break;
        }
        
        return ret;
    }
    
}
