package model.Chambres.Composite;

import java.util.List;

public class ChambreSimple extends Chambre {

    public ChambreSimple(int numero, int etage, double prixBase, StatutChambre statut, List<String> equipements) {
        super(numero, etage, prixBase, statut, equipements);
    }

    @Override
    public double calculerPrix() {
        return prixBase;
    }



}
