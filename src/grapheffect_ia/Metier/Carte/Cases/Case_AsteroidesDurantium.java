package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;

/**
 * Représente une case d'astéroides avec du Durantium
 * @author bd062554
 */
public class Case_AsteroidesDurantium extends Case {

    /**
     * Créer une case d'astéroides avec du Durantium
     * @param coordonnee Les coordonnées de la case
     */
    public Case_AsteroidesDurantium(Coordonnee coordonnee) {
        super(coordonnee);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.AsteroidesDurantium;
    }

    @Override
    public boolean isAccessible() {
        return false;
    }
    
}
