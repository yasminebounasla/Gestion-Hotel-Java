package model.Reservations;
/**
 * Classe représentant un service supplémentaire d'une réservation.
 */
public class Service {
    private String nom;
    private double prix;

    public Service(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }
    // Getters
    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return nom + " (" + prix + " DA)";
    }
}
