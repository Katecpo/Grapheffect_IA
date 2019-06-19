package grapheffect_ia.Metier.Carte;

import grapheffect_ia.Metier.Carte.Cases.Case;
import grapheffect_ia.Metier.Carte.Cases.FabriqueCase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Représente la carte du jeu
 * @author bd062554
 */
public class Carte {
    private HashMap<Coordonnee, Case> cases = null;
    
    /**
     * Créer une carte à partir du message reçu de la commande "CARTE"
     * @param messageRecu La carte au format String
     */
    public Carte(String messageRecu) {
        this.cases = new HashMap<>();
        
        // Mappage de la carte
        for (int i = 0; i < 41; i++) {
            for (int j = 0; j < 55; j++) {
                this.ajouterCase(new Coordonnee(i,j), messageRecu.charAt(j+55*i));
            }
        }
        
        // Création des voisins
        for(int i=0 ;i<41 ;i++) {
            for(int j=0 ;j<55 ;j++) {
                Coordonnee cooCase = new Coordonnee(i,j) ;
                
                for(TypeMouvement mouvement : TypeMouvement.values()) {
                    Coordonnee cooVoisin = cooCase.voisin(mouvement) ;
                
                    if(this.cases.get(cooVoisin) != null) 
                    {
                        this.cases.get(cooCase).ajouterVoisin(this.cases.get(cooVoisin));
                    }
                }
            }
        }
        
        /* // Test des voisins d'une case
        for (Case c : this.cases.get(new Coordonnee(3,3)).getVoisins()) {
            System.out.println(c.getCoordonnee());
        }
        
        for (Case c : this.cases.get(new Coordonnee(6,4)).getVoisins()) {
            System.out.println(c.getCoordonnee());
        }
        */
    }
    
    /**
     * Ajoute une case dans la hashmap
     * @param coordonne Les coordonnées de cette case
     * @param lettre La lettre de cette case
     */
    private void ajouterCase(Coordonnee coordonnee, Character lettre) {
        cases.put(coordonnee, FabriqueCase.Creer(coordonnee, lettre));
    }
    
    /**
     * Permet de récupérer une case
     * @param c Les coordonnées de la case
     * @return 
     */
    public Case getCase(Coordonnee c) {
        return cases.get(c);
    }
    
    /**
     * Affiche la carte dans la console
     */
    public void afficheConsole() {
        for (int i = 0; i < 41; i++) {
            for (int j = 0; j < 55; j++) {
                switch(this.cases.get(new Coordonnee(i,j)).getType()) {
                    case Inconnue : System.out.print("X"); break;
                    case Espace : System.out.print("0"); break;
                    case Asteroides : System.out.print("A"); break;
                    case Planete : System.out.print("P"); break;
                    case Etoile : System.out.print("E"); break;
                }
            }
            System.out.println("");
        }
    }
    
    /**
     * Renvoie toutes les cases de manière non ordonnée de la carte
     * @return Les cases
     */
    public Collection<Case> getCases() {
        return this.cases.values();
    }
    
    /**
     * Renvoie la liste des cases à distance (vol d’oiseau)
     * 3 ou moins de la case passée en paramètre
     * @param centre La case depuis laquelle calculer
     * @return Les cases à distance 3 ou moins du centre
     */
    public ArrayList<Case> getListCasesDistance3(Case centre) {
        ArrayList<Case> ret = new ArrayList();
        
        for (Case voisin1 : centre.getVoisins()) {
            for (Case voisin2 : voisin1.getVoisins()) {
                for (Case voisin3 : voisin2.getVoisins()) {
                    if (!ret.contains(voisin3)) {
                        ret.add(voisin3);
                    }
                }
            }
        }
        
        return ret;
    }
}
