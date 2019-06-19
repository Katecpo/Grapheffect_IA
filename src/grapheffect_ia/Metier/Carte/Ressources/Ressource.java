package grapheffect_ia.Metier.Carte.Ressources;

import grapheffect_ia.Metier.Carte.Coordonnee;

/**
 * Représente une ressource
 * @author bd062554
 */
public class Ressource {
    private Coordonnee position = null;
    private TypeRessource type = null;
    
    /**
     * Créer une ressource à une coordonnée et avec un type
     * @param position La position de la ressource
     * @param type Le type de ressource
     */
    public Ressource(Coordonnee position, TypeRessource type) {
        this.position = position;
        this.type = type;
    }
    
    /**
     * Getter de position
     * @return La position
     */
    public Coordonnee getPosition() {
        return this.position;
    }
    
    /**
     * Getter de type
     * @return Le type
     */
    public TypeRessource getType() {
        return this.type;
    }
    
    /**
     * La ressource est-elle exploitée ?
     * @return L'état d'exploitation de la ressource
     */
    public boolean isExploite() {
        return false;
    }
}
