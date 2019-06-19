package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Metier.Carte.Ressources.TypeRessource;
import grapheffect_ia.Metier.Vaisseaux.Vaisseau;
import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente un état pour construire une station
 * @author bd062554
 */
public class Etat_ConstruireStation extends Etat {
    private Vaisseau vaisseau = null;
    private TypeRessource typeRessource = null;

    /**
     * Créer un état pour construire une station
     * @param module_decision Le module de décision
     * @param vaisseau Le vaisseau à partir duquel créer la station
     * @param typeRessource Le type de ressource qui est exploité par ce vaisseau
     */
    public Etat_ConstruireStation(Module_Decision module_decision, Vaisseau vaisseau, TypeRessource typeRessource) {
        super(module_decision);
        this.vaisseau = vaisseau;
        this.typeRessource = typeRessource;
    }

    @Override
    public String messageAEnvoyer() {
        return "CONSTRUIRE|" + this.vaisseau.getNom() + "|Minage|" + this.typeRessource;
    }

    @Override
    public Etat transition() {
        this.vaisseau.setInactif();
        return new Etat_BesoinVaisseau(this.getModule());
    }
}
