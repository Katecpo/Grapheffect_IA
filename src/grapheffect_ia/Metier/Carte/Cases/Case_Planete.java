package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

/**
 * Représente une case avec une planète
 * @author bd062554
 */
public class Case_Planete extends Case {
    
    /**
     * Créer une case avec une planète
     * @param coordonnee Les coordonnées de la case
     */
    public Case_Planete(Coordonnee coordonnee) {
        super(coordonnee);
    }
    
    @Override
    public TypeCase getType() {
        return TypeCase.Planete;
    }

    @Override
    public boolean isAccessible() {
        return false;
    }
}
