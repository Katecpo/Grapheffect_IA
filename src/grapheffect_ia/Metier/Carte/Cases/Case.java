package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Carte.Ressources.Ressource;
import java.util.ArrayList;

/**
 * Design pattern d'une case
 * @author bd062554
 */
public abstract class Case {
    
    private Coordonnee coordonnee = null;
    private ArrayList<Case> voisins = null;
    
    /**
     * Créer une case aux coordonnées entrées
     * @param coordonnee Coordonnées de la case
     */
    public Case(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
        this.voisins = new ArrayList<>();
    }
    
    /**
     * Renvoie les coordonnées de la case
     * @return Les coordonnées
     */
    public Coordonnee getCoordonnee() {
        return this.coordonnee;
    }
    
    /**
     * Renvoie les voisins de la case
     * @return Un ArrayList des voisins
     */
    public ArrayList<Case> getVoisins() {
        return this.voisins;
    }
    
    /**
     * Ajoute un voisin à la case
     * @param voisin Le voisin à ajouter
     */
    public void ajouterVoisin(Case voisin) {
        this.voisins.add(voisin);
    }
    
    /**
     * Renvoie la ressource de la case
     * @return La ressource
     */
    public Ressource getRessource() {
        return null;
    }
    
    /**
     * Renvoie le type de la case
     * @return Le type
     */
    public abstract TypeCase getType();
    
    /**
     * Permet de savoir si une case est accessible
     * @return L'accessibilité de la case
     */
    public abstract boolean isAccessible();
}
