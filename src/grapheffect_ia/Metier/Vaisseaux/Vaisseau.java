package grapheffect_ia.Metier.Vaisseaux;

import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Cases.TypeCase;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Carte.Ressources.TypeRessource;
import grapheffect_ia.Metier.Carte.TypeMouvement;
import grapheffect_ia.Modules.Module_Memoire;
import java.util.ArrayList;

/**
 * Design pattern d'un vaisseau
 * @author bd062554
 */
public abstract class Vaisseau {
    private Coordonnee position = null;
    private ArrayList<TypeMouvement> ordres = null;
    private int PA = 0;
    private String nom = "";
    private Carte carte = null;
    private Coordonnee destination = null;
    private Module_Memoire mm = null;
    private boolean actif = true;
    private TypeRessource typeRessource = null;

    /**
     * Initialise un vaisseau aux coordonnées passées en paramètre
     * @param position La position du vaisseau
     * @param carte La carte
     * @param numero Le numéro du vaisseau
     * @param mm Le module mémoire
     */
    public Vaisseau(String nom, int PA, Coordonnee position, Carte carte, int numero, Module_Memoire mm) {
        this.position = position;
        this.ordres = new ArrayList();
        this.setPA(PA);
        this.setNom(nom + "_" + numero);
        this.carte = carte;
        this.destination = null;
        this.mm = mm;
        this.actif = true;
        this.typeRessource = null;
    }
    
    /**
     * Ajoute une liste d'ordres à la liste actuelle
     * @param liste la liste d'ordres
     */
    public void ajouterOrdres(ArrayList<TypeMouvement> liste) {
        this.ordres.addAll(liste);
    }
    
    /**
     * Renvoie le premier ordre de la liste
     * @return Renvoie le premier élément de la liste d'ordres si elle n’est pas vide et null sinon
     */
    public TypeMouvement getOrdre() {
        return this.ordres.isEmpty() ? null : this.ordres.get(0);
    }
    
    /**
     * Fait le premier ordre de la liste
     */
    public void faireOrdre() {
        if (!this.ordres.isEmpty()) {
            if (this.peutFaireOrdre()) {
                this.position = this.position.voisin(this.ordres.get(0));
                this.ordres.remove(this.ordres.get(0));
            }
            this.PA--;
        }
    }
    
    /**
     * Setter de la propriété carte
     * @param carte La carte
     */
    public void setCarte(Carte carte) {
        this.carte = carte;
    }
    
    /**
     * Demande si la carte a besoin d'être mise à jour
     * @return L'état de la mise à jour
     */
    public boolean besoinMiseAJourCarte() {
        boolean resultat = false;
        
        for(Case c : this.carte.getCase(this.position).getVoisins()) {
            for(Case j : this.carte.getCase(c.getCoordonnee()).getVoisins()) {
                if (j.getType() == TypeCase.Inconnue) {
                    resultat = true;
                }
            }
        }
        
        return resultat;
    }
    
    /**
     * Vide la liste d'ordres
     */
    public void viderOrdres() {
        this.ordres.clear();
    }

    /**
     * Getter de destination
     * @return Destination
     */
    public Coordonnee getDestination() {
        return destination;
    }

    /**
     * Setter de destination
     * @param destination La destination
     */
    public void setDestination(Coordonnee destination) {
        this.destination = destination;
    }
    
    /**
     * Le vaisseau a-t-il un ordre à effectuer ?
     * @return Si le vaisseau peut faire un ordre
     */
    public boolean peutFaireOrdre() {
        boolean ret = false;
        TypeMouvement ordre = this.getOrdre();
        
        if (ordre != null) {
            if (this.mm.positionLibre(this.position.voisin(ordre))) {
                ret = true;
            }
        }
        
        return ret;
    }
    
    /**
     * Donne la position du vaisseau
     * @return Les coordonnées
     */
    public Coordonnee getPosition() {
        return this.position;
    }
    
    /**
     * Renvoie les PA restants du vaisseau
     * @return Les PA
     */
    public int getPA() {
        return this.PA;
    }
    
    /**
     * Retourne le nom du vaisseau
     * @return Le nom
     */
    public String getNom() {
        return this.nom;
    }
    
    /**
     * Setter de PA
     * @param PA Le nombre de PA
     */
    protected void setPA(int PA) {
        this.PA = PA;
    }
    
    /**
     * Setter du nom
     * @param nom Le nom
     */
    protected void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Getter de actif
     * @return L'activité du vaisseau
     */
    public boolean isActif() {
        return this.actif;
    }
    
    /**
     * Mets le vaisseau inactif
     */
    public void setInactif() {
        this.actif = false;
    }
    
    /**
     * Setter de type ressource
     * @param typeRessource Le type de ressource
     */
    public void setTypeRessource(TypeRessource typeRessource) {
        this.typeRessource = typeRessource;
    }
    
    /**
     * Getter de typeRessource
     * @return Le type de ressource de la case
     */
    public TypeRessource getTypeRessource() {
        return this.typeRessource;
    }
    
    /**
     * Retourne le type de vaisseau
     * @return Type du vaisseau
     */
    public abstract TypeVaisseau getType();
    
    /**
     * Remets les PA à leur état initial
     */
    public abstract void resetPA();
}
