package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

/**
 * Représente une case d'astéroides avec du Thulium
 * @author bd062554
 */
public class Case_AsteroidesThulium extends Case {

    /**
     * Créer une case d'astéroides avec du Thulium
     * @param coordonnee Les coordonnées de la case
     */
    public Case_AsteroidesThulium(Coordonnee coordonnee) {
        super(coordonnee);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.AsteroidesThulium;
    }

    @Override
    public boolean isAccessible() {
        return false;
    }
    
}
