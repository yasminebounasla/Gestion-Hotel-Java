package model.Chambres.Composite;

import java.util.List;
/**
 * Classe abstraite représentant une chambre d'hôtel.
 * 
 * Chaque chambre possède un numéro, un étage, un prix de base,
 * un statut (libre, occupée, maintenance) et une liste d'équipements.
 * Les sous-classes doivent définir la méthode calculerPrix().
 */
public abstract class Chambre {
    protected int numero;
    protected int etage;
    protected double prixBase;
    protected StatutChambre statut;
    protected List<String> equipements;

     /**
     * Constructeur protégé pour les sous-classes.
     */
    protected  Chambre(int numero, int etage, double prixBase, StatutChambre statut, List<String> equipements) {
        this.numero = numero;
        this.etage = etage;
        this.prixBase = prixBase;
        this.statut = statut;
        this.equipements = equipements;
    }
     /** 
     * Calcul du prix de la chambre (implémentation spécifique aux sous-classes).
     */
    public abstract double calculerPrix();

     /**
     * Affiche les détails de la chambre.
     */
    public void afficherDetails() {
        System.out.println("Chambre n°" + numero + " | Étage : " + etage + " | Prix de base : " + prixBase + " | Statut : " + statut);
        System.out.println("Équipements : " + equipements);
    }
    
    // Getters
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
