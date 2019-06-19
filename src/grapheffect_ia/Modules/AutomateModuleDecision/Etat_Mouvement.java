package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Metier.Vaisseaux.Vaisseau;
import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente un état pour le mouvement des vaisseaux
 * @author bd062554
 */
public class Etat_Mouvement extends Etat {
    private Vaisseau vaisseau = null;
    
    /**
     * Créer un état mouvement
     * @param module_decision Le module de décision
     */
    public Etat_Mouvement(Module_Decision module_decision, Vaisseau vaisseau) {
        super(module_decision);
        this.vaisseau = vaisseau;
    }

    @Override
    public String messageAEnvoyer() {
        String ret = "";
        
        if (this.vaisseau.getOrdre() != null) {
            if (this.vaisseau.peutFaireOrdre()) {
                ret = "MOUVEMENT|"+this.vaisseau.getNom()+"|"+vaisseau.getOrdre().name();
            }
        } else {
            ret = "";
        }
        
        return ret;
    }

    @Override
    public Etat transition() {
        Etat ret = null;
        
        if (vaisseau.getOrdre() != null) {
            vaisseau.faireOrdre();
        }
        
        this.getModuleMemoire().setCarteAJour(!vaisseau.besoinMiseAJourCarte());
        
        if (!vaisseau.besoinMiseAJourCarte()) {
            ret = new Etat_BesoinVaisseau(this.getModule());
        } else {
            ret = new Etat_Carte(this.getModule());
        }
    
        return ret;
    }
    
}
