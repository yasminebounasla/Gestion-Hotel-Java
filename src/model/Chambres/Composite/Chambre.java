package model.Chambres.Composite;

import java.util.List;

public abstract class Chambre {
    protected int numero;
    protected int etage;
    protected double prixBase;
    protected StatutChambre statut;
    protected List<String> equipements;

    protected  Chambre(int numero, int etage, double prixBase, StatutChambre statut, List<String> equipements) {
        this.numero = numero;
        this.etage = etage;
        this.prixBase = prixBase;
        this.statut = statut;
        this.equipements = equipements;
    }

    public abstract double calculerPrix();

    public void afficherDetails() {
        System.out.println("Chambre n°" + numero + " | Étage : " + etage + " | Prix de base : " + prixBase + " | Statut : " + statut);
        System.out.println("Équipements : " + equipements);
    }
    public int getNumero() {
        return numero;
    }

    public int getEtage() {
        return etage;
    }

    public double getPrixBase() {
       return prixBase;
    }

    public StatutChambre getStatut() {
        return statut;
    }

    public List<String> getEquipements() {
        return equipements;
    }

}

