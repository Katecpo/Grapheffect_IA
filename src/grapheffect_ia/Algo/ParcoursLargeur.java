package grapheffect_ia.Algo;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Carte.TypeMouvement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Gère le parcours en largeur
 * @author bd062554
 */
public class ParcoursLargeur {
    private HashMap<Case, Integer> distances = null;
    private Carte carte = null;

    /**
     * Créer un objet pour le parcours en largeur
     * @param carte 
     */
    public ParcoursLargeur(Carte carte) {
        distances = new HashMap();
        this.carte = carte;
    }
    
    /**
     * Permet de calculer les distances
     * @param depart La case de départ pour le calcul
     */
    public void calculer(Case depart) {
        // Remise à zéro
        ArrayList<Case> aTraiter = new ArrayList();
        this.distances.clear();
        
        // Init
        aTraiter.add(depart);
        this.distances.put(depart, 0);
        
        // Calcul
        while(!aTraiter.isEmpty()) {
            Case caseEnCours = aTraiter.get(0);
            aTraiter.remove(aTraiter.get(0));
            
            caseEnCours.getVoisins().forEach((v) -> {
                if (!this.distances.containsKey(v)) {
                    if (v.isAccessible()) {
                        this.distances.put(v, (this.distances.get(caseEnCours))+1);
                        aTraiter.add(v);
                    } else {
                        this.distances.put(v, -1);
                    }
                }
            });
        }
    }
    
    /**
     * Renvoie la distance entre la case actuelle et la case c
     * @param c La case à partir de laquelle la distance sera calculée
     * @return La distance entre les 2 cases
     */
    public int getDistance(Case c) {
        int ret = -1;
        
        if (distances.containsKey(c)) {
            ret = distances.get(c);
        }
        
        return ret;
    }
    
    /**
     * Calcule le mouvement à effectuer pour passer d'une case voisine à une autre
     * @param depart Le case départ
     * @param arrivee La case d'arrivée
     * @return Le mouvement à effectuer
     */
    private TypeMouvement mouvement(Case depart,Case arrivee) {
        TypeMouvement[] all = {
                            TypeMouvement.Bas, 
                            TypeMouvement.BasDroit, 
                            TypeMouvement.BasGauche,
                            TypeMouvement.Haut,
                            TypeMouvement.HautDroit,
                            TypeMouvement.HautGauche
                        };
        
        Coordonnee c = new Coordonnee(depart.getCoordonnee().getLigne(),depart.getCoordonnee().getColonne());
        TypeMouvement mvt = null;
        
        for (TypeMouvement t : all) {
            if (carte.getCase(c.voisin(t)) == arrivee) {
                mvt = t;
            }
        }
        
        return mvt;
    }
    
    /**
     * Renvoie le chemin pour accéder à l'arrivée en partant de la case
     * qui a servi de point de départ pour le calcul
     * @param arrivee Le case d'arrivée
     * @return Une séquence de TypeMouvement pour arriver à la case
     */
    public ArrayList<TypeMouvement> getChemin(Case arrivee) {
        // Init
        ArrayList<TypeMouvement> resultat = new ArrayList<>();
        Case caseEnCours = arrivee;
        
        if (!((this.getDistance(arrivee) == -1) || (arrivee == null))) {
            // Calcul
            while(distances.get(caseEnCours) > 0) {
                Case casePrecedente = null;

                for (Case cc : caseEnCours.getVoisins()) {
                    if (distances.get(cc) == (distances.get(caseEnCours)-1)) {
                        casePrecedente = cc;
                    }
                }

                resultat.add(this.mouvement(casePrecedente, caseEnCours));
                caseEnCours = casePrecedente;
            }
            Collections.reverse(resultat);
        }
        
        return resultat;
    }
    
    /**
     * Renvoie l'état d'accessibilité de la case
     * @param c La case à tester
     * @return L'accessibilité
     */
    public boolean estAtteignable(Case c) {
        return ((this.getDistance(c) != -1) && this.distances.containsKey(c)); // Todo: Vérifier TP7.2
    }
}
