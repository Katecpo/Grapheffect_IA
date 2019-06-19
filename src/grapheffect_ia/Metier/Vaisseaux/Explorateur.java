package grapheffect_ia.Metier.Vaisseaux;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Modules.Module_Memoire;

/**
 * Représente un vaisseau de type explorateur
 * @author bd062554
 */
public class Explorateur extends Vaisseau {
    private final int PA_INIT = 6;

    public Explorateur(Coordonnee position, Carte carte, int numero, Module_Memoire mm) {
        super("Explorateur", 6, position, carte, numero, mm);
    }

    @Override
    public void resetPA() {
        this.setPA(PA_INIT);
    }

    @Override
    public TypeVaisseau getType() {
        return TypeVaisseau.Explorateur;
    }
}
