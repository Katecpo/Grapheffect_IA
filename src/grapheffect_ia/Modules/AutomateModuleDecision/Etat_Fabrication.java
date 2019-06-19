package grapheffect_ia.Modules.AutomateModuleDecision;

import grapheffect_ia.Metier.Vaisseaux.TypeVaisseau;
import grapheffect_ia.Modules.Module_Decision;

/**
 * Représente un état de fabrication d'un vaisseau
 * @author bd062554
 */
public class Etat_Fabrication extends Etat {
    TypeVaisseau typeVaisseau = null;
    
    /**
     * Créer un état pour fabriquer un vaisseau du type passé en paramètre
     * @param module_decision Le module de décision
     * @param typeVaisseau Le type de vaisseau à fabriquer
     */
    public Etat_Fabrication(Module_Decision module_decision, TypeVaisseau typeVaisseau) {
        super(module_decision);
        this.typeVaisseau = typeVaisseau;
    }

    @Override
    public String messageAEnvoyer() {
        return "FABRIQUER|" + typeVaisseau;
    }

    @Override
    public Etat transition() {
        this.getModuleMemoire().ajouterVaisseau(this.typeVaisseau);
        return new Etat_GestionDesVaisseaux(this.getModule());
    }
    
}
