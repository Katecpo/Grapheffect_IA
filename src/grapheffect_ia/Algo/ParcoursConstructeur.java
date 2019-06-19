package grapheffect_ia.Algo;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Cases.TypeCase;
import grapheffect_ia.Metier.Carte.Ressources.TypeRessource;
import grapheffect_ia.Metier.Carte.TypeMouvement;
import java.util.ArrayList;

/**
 * Représente le parcours calculé pour le constructeur
 * @author bd062554
 */
public class ParcoursConstructeur {
    private Carte carte = null;
    private ParcoursLargeur parcoursDepuisVaisseau = null;
    private ParcoursLargeur parcoursDepuisBase = null;
    
    /**
     * Créer un parcours constructeur avec une carte
     * @param carte La carte utilisée pour le parcours
     */
    public ParcoursConstructeur(Carte carte) {
        this.carte = carte;
        this.parcoursDepuisVaisseau = new ParcoursLargeur(this.carte);
        this.parcoursDepuisBase = new ParcoursLargeur(this.carte);
    }
    
    /**
     * Calcule les parcours en largeur
     * @param caseVaisseau La case du vaisseau
     * @param caseBase La case de la base
     */
    public void calculer(Case caseVaisseau, Case caseBase) {
        parcoursDepuisVaisseau.calculer(caseVaisseau);
        parcoursDepuisBase.calculer(caseBase);
    }
    
    /**
     * Retourne le chemin avec une suite d'ordres depuis le vaisseau
     * @param arrivee La case d'arrivée
     * @return Suite d'ordres pour arriver à l'arrivée
     */
    public ArrayList<TypeMouvement> getChemin(Case arrivee) {
        return parcoursDepuisVaisseau.getChemin(arrivee);
    }
    
    /**
     * La case c est-elle atteignable depuis le vaisseau
     * @param c La case
     * @return L'accessibilité de c depuis le vaisseau
     */
    public boolean estAtteignable(Case c) {
        return parcoursDepuisVaisseau.estAtteignable(c);
    }
    
    /**
     * Retourne une case sur laquelle on peut construire
     * @param type Le type de ressource
     * @return La case où la construction est possible
     */
    public Case getCaseOuConstruire(TypeRessource type) {
        Case resultat = null;
        int coutMin = Integer.MAX_VALUE;
        
        for (Case c : this.carte.getCases()) {
            if (parcoursDepuisBase.estAtteignable(c) && parcoursDepuisVaisseau.estAtteignable(c) && c.getType() == TypeCase.Espace)
            {
                int coutDistance = parcoursDepuisBase.getDistance(c);
                
                int coutRessource = 0;
                for (Case j : this.carte.getListCasesDistance3(c)) {
                    if (j.getRessource() != null) {
                        if (j.getRessource().getType() == type && !j.getRessource().isExploite()) {
                            coutRessource++;
                        }
                    }
                }
                coutRessource *= -10;
                
                
                int cout = Integer.MAX_VALUE;
                if (coutRessource != 0) {
                    resultat = c;
                    cout = coutDistance + coutRessource;
                }
                
                coutMin = Integer.MAX_VALUE;
            }
        }
        
        return resultat;
    }
}
