package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Carte.Ressources.Ressource;
import grapheffect_ia.Metier.Carte.Ressources.TypeRessource;

/**
 * Représente une case avec des astéroides quelconques
 * @author bd062554
 */
public class Case_Asteroides extends Case {
    private Ressource ressource = null;
    
    /**
     * Créer une case d'astéroides quelconques
     * @param coordonnee Les coordonnées de la case
     * @param ressource La ressource de la case
     */
    public Case_Asteroides(Coordonnee coordonnee, Ressource ressource) {
        super(coordonnee);
        this.ressource = ressource;
    }

    @Override
    public TypeCase getType() {
        return TypeCase.Asteroides;
    }

    @Override
    public boolean isAccessible() {
        return false;
    }
    
    @Override
    public Ressource getRessource() {
        return this.ressource;
    }
    
}
