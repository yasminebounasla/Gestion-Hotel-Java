package model.Chambres.Composite;

import java.util.List;
 /**
 * Représente une chambre double.
 */
public class ChambreDouble extends Chambre {

    public ChambreDouble(int numero, int etage, double prixBase, StatutChambre statut, List<String> equipements) {
        super(numero, etage, prixBase, statut, equipements);
    }

    @Override
    public double calculerPrix() {
        // Pour une chambre double, le prix est majoré de 20% par rapport au prix de base
       // 100% du prix de base + 20% = 120% -> prixBase * 1.2
        return prixBase * 1.2;
    }
}
