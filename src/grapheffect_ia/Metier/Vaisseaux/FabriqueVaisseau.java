package grapheffect_ia.Metier.Vaisseaux;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Modules.Module_Memoire;
import java.util.HashMap;

/**
 * Fabrique des vaisseaux
 * @author bd062554
 */
public class FabriqueVaisseau {
    private static FabriqueVaisseau instance = null;
    private HashMap<TypeVaisseau, Integer> numeros = null;
    
    /**
     * Créer une instance du singleton
     */
    private FabriqueVaisseau() {
        numeros = new HashMap();
        
        for (TypeVaisseau t : TypeVaisseau.values()) {
            numeros.put(t,0);
        }
    }
    
    /**
     * Retourne l'instance de la fabrique de vaisseaux
     * @return 
     */
    public static FabriqueVaisseau get() {
        if (instance == null) {
            instance = new FabriqueVaisseau();
        }
        
        return instance;
    }
    
    /**
     * Créer un vaisseau
     * @param type Type du vaisseau
     * @param position La position du vaisseau
     * @param carte La carte
     * @param mm Le module mémoire
     * @return Le vaisseau créé
     */
    public Vaisseau creer(TypeVaisseau type, Coordonnee position, Carte carte, Module_Memoire mm) {
        Vaisseau ret = null;
        
        switch(type)
        {
            case Explorateur:
                ret = new Explorateur(position, carte, mm.getNbVaisseaux(type)+1, mm);
                break;
            case Constructeur:
                ret = new Constructeur(position, carte, mm.getNbVaisseaux(type)+1, mm);
                break;
        }
        
        return ret;
    }
}
