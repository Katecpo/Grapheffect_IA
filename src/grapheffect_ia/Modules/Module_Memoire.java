package grapheffect_ia.Modules;

import grapheffect_ia.IA;
import grapheffect_ia.Metier.Carte.Carte;
import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Coordonnee;
import grapheffect_ia.Metier.Vaisseaux.FabriqueVaisseau;
import grapheffect_ia.Metier.Vaisseaux.TypeVaisseau;
import grapheffect_ia.Metier.Vaisseaux.Vaisseau;
import java.util.ArrayList;

/**
 * Module en charge de la mémorisation et de la restitution des informations obtenues
 * @author Matthieu
 */
public class Module_Memoire extends Module  {
    private Carte carte = null;
    private Coordonnee coordonneeBase = null;
    private ArrayList<Vaisseau> vaisseaux = null;
    private boolean carteAJour = false;
    private int numVaisseauEnCours = 0;

    /**
     * Initialise le module mémoire
     * @param ia L'IA
     */
    public Module_Memoire(IA ia) {
        super(ia);
        this.vaisseaux = new ArrayList();
        this.carteAJour = false;
        this.numVaisseauEnCours = 0;
        this.coordonneeBase = null;
    }

    /**
     * Permet de générer la carte dans le module mémoire
     * @param messageRecu Le message reçu de la commande CARTE
     */
    public void genererCarte(String messageRecu) {
        this.carte = new Carte(messageRecu);
        //carte.afficheConsole();
        this.setCarteAJour(true);
        
        this.getVaisseaux().forEach((v) -> {
            v.setCarte(this.carte);
        });
    }
    
    /**
     * Retourne si la carte a été créée
     * @return True si la carte est créée, false sinon
     */
    public boolean hasCarte() {
        return this.carteAJour;
    }
    
    /**
     * Retourne la carte en mémoire
     * @return La carte
     */
    public Carte getCarte() {
        return this.carte;
    }
    
    /**
     * Fixe la base à partir du message envoyé par le serveur
     * {@code 
     * String message = "8,20";
     * this.getIA().getModuleMemoire().setBase(message);}
     * @param message Les coordonnées au format "ligne,colonne" : String
     */
    public void setBase(String message) {
        coordonneeBase = Coordonnee.fromString(message);
    }
    
    /**
     * Retourne si la base est connue et fixée
     * @return Si la base est connue
     */
    public boolean hasBase() {
        return coordonneeBase != null;
    }
    
    /**
     * Retourne les vaisseaux présents
     * @return Les vaisseaux
     */
    public ArrayList<Vaisseau> getVaisseaux() {
        return this.vaisseaux;
    }
    
    /**
     * Permet d'ajouter un vaisseau à la base
     */
    public void ajouterVaisseau(TypeVaisseau t) {
        this.vaisseaux.add(FabriqueVaisseau.get().creer(t, coordonneeBase, carte, this));
    }
    
    /**
     * Setter de carteAJour
     * @param carteAJour État logique
     */
    public void setCarteAJour(boolean carteAJour) {
        this.carteAJour = carteAJour;
        
        if (!this.carteAJour) {
           this.vaisseaux.forEach((v) -> {
                v.viderOrdres();
            }); 
        }
    }
    
    /**
     * Renvoie la case où se situe la base
     * @return Case de la base
     */
    public Case getCaseBase() {
        return this.carte.getCase(coordonneeBase);
    }

    /**
     * Retourne le vaisseau en cours
     * @return Vaisseau en cours
     */
    public Vaisseau getVaisseauEnCours() {
        return getVaisseaux().get(numVaisseauEnCours);
    }
    
    /**
     * Permet de sélectionner le prochain vaisseau en mémoire
     */
    public void vaisseauSuivant() {
        if (numVaisseauEnCours == getVaisseaux().size()-1) {
            numVaisseauEnCours = 0;
        } else {
            numVaisseauEnCours++;
        }
    }
    
    /**
     * La position c est-elle libre ?
     * @param c Les coordonnées de la case
     * @return Si la case est libre
     */
    public boolean positionLibre(Coordonnee c) {
        boolean ret = true;
        
        for (Vaisseau v : this.getVaisseaux()) {
            if (v.getPosition().equals(c)) {
                ret = false;
            }
        }
        
        return ret;
    }
    
    /**
     * Renvoie le nombre de vaisseaux du type passé en paramètre
     * @param type Le type de vaisseau
     * @return Le nombre de vaisseaux du type
     */
    public int getNbVaisseaux(TypeVaisseau type) {
        int ret = 0;
        
        for (Vaisseau t : this.getVaisseaux()) {
            if (t.getType() == type) {
                ret++;
            }
        }
        
        return ret;
    }
}
