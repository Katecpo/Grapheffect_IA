package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

/**
 * Représente une case non découverte (inconnue)
 * @author bd062554
 */
public class Case_Inconnue extends Case {
    
    /**
     * Créer une case inconnue
     * @param coordonnee Les coordonnées de la case
     */
    public Case_Inconnue(Coordonnee coordonnee) {
        super(coordonnee);
    }
    
    @Override
    public TypeCase getType() {
        return TypeCase.Inconnue;
    }

    @Override
    public boolean isAccessible() {
        return true;
    }
}
