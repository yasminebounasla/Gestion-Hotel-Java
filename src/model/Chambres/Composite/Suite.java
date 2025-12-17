package model.Chambres.Composite;

import java.util.ArrayList;
import java.util.List;

public class Suite extends Chambre {
    
     private List<Chambre> sousChambres;
    public Suite(int numero, int etage, double prixBase, StatutChambre statut, List<String> equipements) {
        super(numero, etage, prixBase, statut, equipements);
        sousChambres = new ArrayList<>();
    }

    public void ajouterChambre(Chambre chambre) {
        sousChambres.add(chambre);
    }

    public void retirerChambre(Chambre chambre) {
    sousChambres.remove(chambre);
    }

    @Override
    public double calculerPrix() {
        double total = prixBase;
        for (Chambre c : sousChambres) {
            total += c.calculerPrix();
        }
        return total;
    }
}
