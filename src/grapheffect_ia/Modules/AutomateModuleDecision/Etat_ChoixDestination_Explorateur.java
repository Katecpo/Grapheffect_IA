package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Algo.ParcoursExploration;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Vaisseaux.Vaisseau;
import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente un état pour choisir la destination d'un vaisseau explorateur
 * @author bd062554
 */
public class Etat_ChoixDestination_Explorateur extends Etat {
    private Vaisseau vaisseau = null;
    
    /**
     * Créer un état pour gérer la destination d'un vaisseau explorateur
     * @param module_decision Le module de décision
     * @param vaisseau Le vaisseau explorateur
     */
    public Etat_ChoixDestination_Explorateur(Module_Decision module_decision, Vaisseau vaisseau) {
        super(module_decision);
        this.vaisseau = vaisseau;
    }

    @Override
    public String messageAEnvoyer() {
        return "";
    }

    @Override
    public Etat transition() {
        Case caseVaisseau = this.getModuleMemoire().getCarte().getCase(vaisseau.getPosition());
        Case caseBase = this.getModuleMemoire().getCaseBase();
        
        ParcoursExploration parcours = new ParcoursExploration(this.getModuleMemoire().getCarte());
        parcours.calculer(caseVaisseau, caseBase);

        Case destination = this.getModuleMemoire().getCarte().getCase(vaisseau.getDestination());
        
        if (destination == null || !parcours.estAtteignable(destination) || destination == caseVaisseau) {
            destination = parcours.getCaseInconnueAVisiter();
            
            if (destination == null) {
                vaisseau.setInactif();
            } else {
                vaisseau.setDestination(destination.getCoordonnee());
            }
        }
        
        vaisseau.ajouterOrdres(parcours.getChemin(destination));
        
        return new Etat_Mouvement(this.getModule(),vaisseau);
    }
    
}
