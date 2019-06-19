package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

/**
 * Représente une case avec des étoiles
 * @author bd062554
 */
public class Case_Etoile extends Case {
    
    /**
     * Créer une case avec des étoiles
     * @param coordonnee Les coordonnées de la case
     */
    public Case_Etoile(Coordonnee coordonnee) {
        super(coordonnee);
    }
    
    @Override
    public TypeCase getType() {
        return TypeCase.Etoile;
    }

    @Override
    public boolean isAccessible() {
        return false;
    }
}
