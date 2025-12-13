package model.reservations;

public class Service {
    private String nom;
    private double prix;

    public Service(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

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
