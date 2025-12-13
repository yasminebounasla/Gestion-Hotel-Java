package model.Chambres.Composite;

import java.util.List;

public class Suite extends Chambre {
    
    public Suite(int numero, int etage, double prixBase, StatutChambre statut, List<String> equipements) {
        super(numero, etage, prixBase, statut, equipements);
    }

    @Override
    public double calculerPrix() {
        return prixBase * 1.5;
    }
}
