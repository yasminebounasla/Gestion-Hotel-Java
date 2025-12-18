package model.Chambres.Composite;

import java.util.ArrayList;
import java.util.List;
/**
 * Représente une suite composée de plusieurs chambres.
*/
public class Suite extends Chambre {
    
     private List<Chambre> sousChambres;
    public Suite(int numero, int etage, double prixBase, StatutChambre statut, List<String> equipements) {
        super(numero, etage, prixBase, statut, equipements);
        sousChambres = new ArrayList<>();
    }
     /**
     * Ajoute une sous-chambre à la suite.
     */
    public void ajouterChambre(Chambre chambre) {
        sousChambres.add(chambre);
    }
    /**
     * Retire une sous-chambre de la suite.
     */
    public void retirerChambre(Chambre chambre) {
    sousChambres.remove(chambre);
    }
    /**
     * Calcul du prix total de la suite = prix de base + prix des sous-chambres.
     */
    @Override
    public double calculerPrix() {
        double total = prixBase;
        for (Chambre c : sousChambres) {
            total += c.calculerPrix();
        }
        return total;
    }

    @Override
    public void afficherDetails() {
        // Affiche les détails de la suite principale
        super.afficherDetails();
        // Affiche ensuite les détails de toutes les sous-chambres composant cette suite
        System.out.println("Sous-chambres :");
        for (Chambre c : sousChambres) {
         // Appel récursif pour afficher chaque sous-chambre
         c.afficherDetails();
        }
    }
}
