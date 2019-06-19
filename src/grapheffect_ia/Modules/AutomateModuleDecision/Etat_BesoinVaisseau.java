package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Metier.Vaisseaux.TypeVaisseau;
import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente un état pour gérer le besoin des vaisseaux
 * @author bd062554
 */
public class Etat_BesoinVaisseau extends Etat {
    
    /**
     * Créer un état pour gérer le besoin des vaisseaux
     * @param module_decision Le module de décision
     */
    public Etat_BesoinVaisseau(Module_Decision module_decision) {
        super(module_decision);
    }

    @Override
    public String messageAEnvoyer() {
        return "";
    }

    @Override
    public Etat transition() {
        Etat ret = null;
        
        if (this.getModuleMemoire().getNbVaisseaux(TypeVaisseau.Explorateur) < 2 && this.getModuleMemoire().positionLibre(this.getModuleMemoire().getCaseBase().getCoordonnee())) {
            ret = new Etat_Fabrication(this.getModule(), TypeVaisseau.Explorateur);
        } else if (this.getModuleMemoire().getNbVaisseaux(TypeVaisseau.Constructeur) < 1 && this.getModuleMemoire().positionLibre(this.getModuleMemoire().getCaseBase().getCoordonnee())) {
            ret = new Etat_Fabrication(this.getModule(), TypeVaisseau.Constructeur);
        } else {
            ret = new Etat_GestionDesVaisseaux(this.getModule());
        }
        
        return ret;
    }
    
}
