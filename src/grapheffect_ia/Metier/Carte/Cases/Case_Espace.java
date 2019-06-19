package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

/**
 * Représente une case vide
 * @author bd062554
 */
public class Case_Espace extends Case {
    
    /**
     * Créer une case vide
     * @param coordonnee Les coordonnées de la case
     */
    public Case_Espace(Coordonnee coordonnee) {
        super(coordonnee);
    }
    
    @Override
    public TypeCase getType() {
        return TypeCase.Espace;
    }

    @Override
    public boolean isAccessible() {
        return true;
    }
}
