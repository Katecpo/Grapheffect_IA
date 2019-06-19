package grapheffect_ia.Metier.Carte.Cases;

import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Carte.Ressources.Ressource;
import grapheffect_ia.Metier.Carte.Ressources.TypeRessource;

/**
 * Permet de fabriquer les cases à partir de la lettre celle-ci
 * @author bd062554
 */
public class FabriqueCase {
    public static Case Creer(Coordonnee coordonnee, Character lettre) {
        Case ret = null;
        
        switch(lettre) {
            case 'E':
                ret = new Case_Espace(coordonnee); break;
            case 'A':
                ret = new Case_Asteroides(coordonnee, null); break;
            case 'D':
                ret = new Case_Asteroides(coordonnee, new Ressource(coordonnee, TypeRessource.Durantium)); break;
            case 'T':
                ret = new Case_Asteroides(coordonnee, new Ressource(coordonnee, TypeRessource.Thulium)); break;
            case 'S':
                ret = new Case_Etoile(coordonnee); break;
            case 'P':
                ret = new Case_Planete(coordonnee); break;
            case 'X':
                ret = new Case_Inconnue(coordonnee); break;
        }
        
        return ret;
    }
}
