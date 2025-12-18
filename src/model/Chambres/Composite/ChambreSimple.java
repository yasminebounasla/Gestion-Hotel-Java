package model.Chambres.Composite;

import java.util.List;
/**
 * Représente une chambre simple.
*/
public class ChambreSimple extends Chambre {

    public ChambreSimple(int numero, int etage, double prixBase, StatutChambre statut, List<String> equipements) {
        super(numero, etage, prixBase, statut, equipements);
    }
    /** 
     * Prix d'une chambre simple = prix de base
     */
    @Override
    public double calculerPrix() {
        return prixBase;
    }



}
