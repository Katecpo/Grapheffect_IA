package grapheffect_ia.Algo;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Cases.TypeCase;
import grapheffect_ia.Metier.Carte.TypeMouvement;
import java.util.ArrayList;

/**
 * Gère le parcours d'exploration des explorateurs à partir du parcours en largeur
 * @author bd062554
 */
public class ParcoursExploration {
    private Carte carte = null;
    private ParcoursLargeur parcoursDepuisVaisseau = null;
    private ParcoursLargeur parcoursDepuisBase = null;
    
    /**
     * Créer un parcours exploration avec une carte
     * @param carte La carte utilisée pour le parcours
     */
    public ParcoursExploration(Carte carte) {
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
     * Retourne une case inconnue à visiter
     * @return La case inconnue
     */
    public Case getCaseInconnueAVisiter() {
        Case resultat = null;
        int coutMin = Integer.MAX_VALUE;
        
        for (Case c : this.carte.getCases()) {
            if (parcoursDepuisBase.estAtteignable(c) && parcoursDepuisVaisseau.estAtteignable(c) && c.getType() == TypeCase.Inconnue)
            {
                int coutDistance = parcoursDepuisBase.getDistance(c) + parcoursDepuisVaisseau.getDistance(c);
                
                int coutVoisin = 0;
                for (Case j : c.getVoisins()) {
                    if (j.getType() != TypeCase.Inconnue) {
                        coutVoisin++;
                    }
                }
                
                int cout = coutDistance + coutVoisin;
                
                if (cout < coutMin) {
                    resultat = c;
                    coutMin = cout;
                }
            }
        }
        
        return resultat;
    }
    
    /**
     * La case c est-elle atteignable depuis le vaisseau
     * @param c La case
     * @return L'accessibilité de c depuis le vaisseau
     */
    public boolean estAtteignable(Case c) {
        return parcoursDepuisVaisseau.estAtteignable(c);
    }
}
