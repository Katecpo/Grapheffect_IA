package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Algo.ParcoursConstructeur;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Ressources.TypeRessource;
import grapheffect_ia.Metier.Vaisseaux.Vaisseau;
import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente un état qui gère la destination des vaisseaux constructeur
 * @author bd062554
 */
public class Etat_ChoixDestination_Constructeur extends Etat {
    private Vaisseau vaisseau = null;
    
    /**
     * Créer un état pour gérer la destination d'un vaisseau constructeur
     * @param module_decision Le module de décision
     * @param vaisseau Le vaisseau constructeur
     */
    public Etat_ChoixDestination_Constructeur(Module_Decision module_decision, Vaisseau vaisseau) {
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
        Case caseVaisseau = this.getModuleMemoire().getCarte().getCase(vaisseau.getPosition());
        Case caseBase = this.getModuleMemoire().getCaseBase();
        Case caseDestination = this.getModuleMemoire().getCarte().getCase(vaisseau.getDestination());
        
        if (caseVaisseau.equals(caseDestination)) {
            ret = new Etat_ConstruireStation(this.getModule(), this.vaisseau, TypeRessource.Durantium);
        } else {
            ParcoursConstructeur parcours = new ParcoursConstructeur(this.getModuleMemoire().getCarte());
            parcours.calculer(caseVaisseau, caseBase);
            
            if (caseDestination == null) {
                caseDestination = parcours.getCaseOuConstruire(TypeRessource.Durantium);
                this.vaisseau.setDestination(caseDestination.getCoordonnee());
                this.vaisseau.setTypeRessource(TypeRessource.Durantium);
            }
            
            if(caseDestination == null) {
                this.vaisseau.setInactif();
            }
                
            vaisseau.ajouterOrdres(parcours.getChemin(caseDestination));
            ret = new Etat_Mouvement(this.getModule(),vaisseau);
        }
        
        return ret;
    }
    
}
