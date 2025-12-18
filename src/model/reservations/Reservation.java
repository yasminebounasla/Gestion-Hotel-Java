package model.Reservations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Chambres.Composite.Chambre;
import model.Clients.Client;
/**
 * Classe représentant une réservation.
 * 
 * Une réservation est associée à un client et une chambre, avec des dates
 * de début et de fin, et éventuellement des services supplémentaires.
 */
public class Reservation {

    private static int compteurId = 1;
    private int id;
    private Client client;
    private Chambre chambre;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private List<Service> services;
    private double prixTotal;

    public Reservation(Client client, Chambre chambre, LocalDate dateDebut, LocalDate dateFin, List<Service> services) {
        this.id = compteurId++;
        this.client = client;
        this.chambre = chambre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.services = services != null ? services : new ArrayList<>();
        this.prixTotal = 0;
    }
    /**
     * Calcule le prix total de la réservation (chambre + services)
    */
    public double calculerPrixTotal() {
        double total = chambre.calculerPrix();
        for (Service s : services) {
            total += s.getPrix();
        }
        this.prixTotal = total;
        return total;
    }
    // Getters
    public Client getClient() { return client; }
    public Chambre getChambre() { return chambre; }
    public LocalDate getDateDebut() { return dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public List<Service> getServices() { return services; }
    public double getPrixTotal() { return prixTotal; }
    public int getId() { return id; }

    @Override
    public String toString() {
        return "Reservation #" + id +
               " | Client: " + client.getNomComplet() +
               " | Chambre: " + chambre.getNumero() +
               " | Du " + dateDebut + " au " + dateFin +
               " | Prix: " + prixTotal + " DA";
    }
}
