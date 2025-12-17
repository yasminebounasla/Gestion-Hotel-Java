package model.Reservations;

import java.util.ArrayList;

import model.Clients.ClientVIP;
import model.Reservations.Observer.ReservationService;

public class GestionnaireReservations {

    private ArrayList<Reservation> reservations;
    private ReservationService reservationService;

    public GestionnaireReservations(ReservationService reservationService) {
        this.reservations = new ArrayList<>();
        this.reservationService = reservationService;
    }

    public void ajouterReservation(Reservation reservation) {
        this.reservations.add(reservation);
        // Calculer le prix total
        reservation.calculerPrixTotal();
        
        // Augmenter les points si client VIP
        if (reservation.getClient() instanceof ClientVIP) {
            ClientVIP vip = (ClientVIP) reservation.getClient();
            vip.ajouterPoints((int) reservation.getPrixTotal() / 1000); // exemple : 1 point pour 1000 DA
        }
        
        notifier();
    }


    public void supprimerReservation(Reservation reservation) {
        reservations.remove(reservation);
        notifier();
    }


    public boolean updateReservation(Reservation oldR, Reservation newR) {
        int index = reservations.indexOf(oldR); // cherche l'ancienne réservation
        if (index != -1) {
            reservations.set(index, newR); 
            notifier();
            return true; // succès
        }
        return false; // oldR non trouvé
    }

    public Reservation getReservationParId(int id) {
    for (Reservation r : reservations) {
        if (r.getId() == id) {
            return r;
        }
    }
    return null;
}

    public void clearReservations() {
        this.reservations.clear();
        notifier();
    }
    
    public int getNombreReservations() {
        return this.reservations.size();
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }


    private void notifier() {
        reservationService.notifierObservateurs();
    }
}
