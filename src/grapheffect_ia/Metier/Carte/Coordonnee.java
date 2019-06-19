package grapheffect_ia.Metier.Carte;

/**
 * Représente des coordonnées sur la carte
 * @author bd062554
 */
public class Coordonnee {
    private int ligne = 0;
    private int colonne = 0;
    
    /**
     * Créer une coordonnée à partir d'une ligne et d'une colonne
     * @param ligne La ligne
     * @param colonne La colonne
     */
    public Coordonnee(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }
    
    /**
     * Converti les coordonnées reçues du format String à Coordonnee
     * @param message Le message de coordonnées
     * @return Les coordonnées au format Coordonnee
     */
    public static Coordonnee fromString(String message) {
        String[] coor = message.split(",");
        return new Coordonnee(Integer.valueOf(coor[0]), Integer.valueOf(coor[1]));
    }
    
    /**
     * Retourne les coordonnées du voisin selon le type de mouvement par rapport aux
     * coordonnées actuelles
     * @param mouvement Le type de mouvement 
     * @return Coordonnées du voisin, null si erreur 
     */
    public Coordonnee voisin(TypeMouvement mouvement) {
        if (!((getColonne() & 1) == 0)) 
        {
            // pair
            switch(mouvement) {
                case HautGauche: return 
                        new Coordonnee(getLigne(),      getColonne()-1);
                case Haut: return 
                        new Coordonnee(getLigne()-1,    getColonne());
                case HautDroit: return 
                        new Coordonnee(getLigne(),      getColonne()+1);
                case BasGauche: return 
                        new Coordonnee(getLigne()+1,    getColonne()-1);
                case Bas: return 
                        new Coordonnee(getLigne()+1,    getColonne());
                case BasDroit: return 
                        new Coordonnee(getLigne()+1,    getColonne()+1);
            }
        } 
        else 
        { 
            // impair
            switch(mouvement) {
                case HautGauche: return 
                        new Coordonnee(getLigne()-1,    getColonne()-1);
                case Haut: return 
                        new Coordonnee(getLigne()-1,    getColonne());
                case HautDroit: return 
                        new Coordonnee(getLigne()-1,    getColonne()+1);
                case BasGauche: return 
                        new Coordonnee(getLigne(),      getColonne()-1);
                case Bas: return 
                        new Coordonnee(getLigne()+1,    getColonne());
                case BasDroit: return 
                        new Coordonnee(getLigne(),      getColonne()+1);
            }
        }
        
        return null;
    }
    
    /**
     * Retourne la ligne de la coordonnée
     * @return La ligne
     */
    public int getLigne() {
        return this.ligne;
    }
    
    /**
     * Retourne la colonne de la coordonnée
     * @return La colonne
     */
    public int getColonne() {
        return this.colonne;
    }

    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.ligne;
        hash = 83 * hash + this.colonne;
        return hash;
    }

    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordonnee other = (Coordonnee) obj;
        if (this.ligne != other.ligne) {
            return false;
        }
        if (this.colonne != other.colonne) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return String.format("Coordonnées de la case : (%s, %s)", ligne, colonne);
    }
}
