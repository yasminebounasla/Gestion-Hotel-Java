package model.Reservations;

import java.util.ArrayList;

import model.Clients.ClientVIP;
import model.Reservations.Observer.ReservationService;

/**
 * Classe représentant le gestionnaire des réservations de l'hôtel.
 * 
 * Cette classe gère la liste des réservations et applique le patron
 * Observateur pour notifier en cas des mise à jour à réservations.
 * Elle permet d'ajouter, supprimer, mettre à jour et rechercher des 
 * réservations. Elle gère aussi le calcul du prix total et les points 
 * fidélité pour les clients VIP, et aussi ajouter des services à une réservation.
 */

public class GestionnaireReservations {

    private ArrayList<Reservation> reservations; // Liste des réservations
    private ReservationService reservationService; // Service 

    public GestionnaireReservations(ReservationService reservationService) {
        this.reservations = new ArrayList<>(); // Initialisation de la liste
        this.reservationService = reservationService;
    }

    // ajouter une réservation
    public void ajouterReservation(Reservation reservation) {
        this.reservations.add(reservation);

        // Calculer le prix total
        reservation.calculerPrixTotal();
        
        // Augmenter les points si client VIP
        if (reservation.getClient() instanceof ClientVIP) { // Vérifier si le client est VIP
            ClientVIP vip = (ClientVIP) reservation.getClient(); 
            vip.ajouterPoints((int) reservation.getPrixTotal() / 1000); // 1 point par tranche de 1000 DA 
        }
        
        notifier(); // Notifier les observateurs
    }


    // supprimer une réservation
    public void supprimerReservation(Reservation reservation) {
        reservations.remove(reservation);
        notifier(); // Notifier les observateurs
    }


    // mettre à jour une réservation 
    // indexOF retourne l’indice de la première occurrence de l’objet dans la liste.

    public boolean updateReservation(Reservation oldR, Reservation newR) {
        int index = reservations.indexOf(oldR); // cherche l'ancienne réservation avec indexOf  ( -1 non trouver , >=0 trouver )

        if (index != -1) { // si trouvée

            reservations.set(index, newR); // mettre à jour avec la nouvelle réservation
            notifier(); // Notifier les observateurs
            return true; // succès
        }
        return false; // oldR non trouvé
    }

    // rechercher une réservation par ID
    public Reservation getReservationParId(int id) {
        for (Reservation r : reservations) {
            if (r.getId() == id) { // si l'ID correspond
                return r;
            }
        }
        return null;
    }

    // vider toutes les réservations
    public void clearReservations() {
        this.reservations.clear();
        notifier(); // Notifier les observateurs
    }
    
    // obtenir le nombre total des réservations
    public int getNombreReservations() {
        return this.reservations.size();
    }

    // obtenir la liste des réservations
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }


    //la fontction notifiers
    private void notifier() {
        reservationService.notifierObservateurs();
    }

    // ajouter un service à une réservation
    public void ajouterServiceAReservation(Reservation reservation, Service service) {
        reservation.getServices().add(service);
        reservation.calculerPrixTotal();
        notifier();
    }

}
