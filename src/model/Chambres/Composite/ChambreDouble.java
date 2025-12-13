package model.Chambres.Composite;

import java.util.List;

public class ChambreDouble extends Chambre {

    public ChambreDouble(int numero, int etage, double prixBase, StatutChambre statut, List<String> equipements) {
        super(numero, etage, prixBase, statut, equipements);
    }

    @Override
    public double calculerPrix() {
        return prixBase * 1.2;
    }
}
