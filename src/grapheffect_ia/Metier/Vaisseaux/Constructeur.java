package grapheffect_ia.Metier.Vaisseaux;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Modules.Module_Memoire;

/**
 * Représente un vaisseau de type Constructeur
 * @author bd062554
 */
public class Constructeur extends Vaisseau {
    private final int PA_INIT = 3;
    
    /**
     * Créer un vaisseau constructeur en mémoire
     * @param position La position du constructeur
     * @param carte La carte
     * @param numero Son numéro
     * @param mm Le module mémoire
     */
    public Constructeur(Coordonnee position, Carte carte, int numero, Module_Memoire mm) {
        super("Constructeur", 3, position, carte, numero, mm);
    }

    @Override
    public void resetPA() {
        this.setPA(PA_INIT);
    }

    @Override
    public TypeVaisseau getType() {
        return TypeVaisseau.Constructeur;
    }
    
}
