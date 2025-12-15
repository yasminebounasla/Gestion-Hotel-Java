package controller;

import java.util.ArrayList;

import model.Reservations.GestionnaireReservations;
import model.Reservations.Reservation;

public class ControleurReservation {

    private GestionnaireReservations gestionnaireR ;

    public void ajouterReservation(Reservation reservation) {
        this.gestionnaireR.ajouterReservation(reservation);
    }

    public void deleteReservations(Reservation reservation) {
        this.gestionnaireR.deleteReservations(reservation);
    }

    public boolean updateReservation(Reservation oldR, Reservation newR) {
        return this.gestionnaireR.updateReservation(oldR, newR);
    }

    public void clearReservations() {
        this.gestionnaireR.clearReservations();
    }
    
    public int getNombreReservations() {
        return this.gestionnaireR.getNombreReservations();
    }

    public ArrayList<Reservation> getReservations() {
        return this.gestionnaireR.getReservations();
    }

}
