package controller;

import java.util.ArrayList;

import model.Reservations.GestionnaireReservations;
import model.Reservations.Reservation;
import model.Reservations.Service;

public class ControleurReservation {

    private GestionnaireReservations gestionnaireR ;
    private ControleurClient controleurClient;
    private ControleurChambre controleurChambre;

    public ControleurReservation(GestionnaireReservations gestionnaireR, ControleurClient controleurClient, ControleurChambre controleurChambre) {
        this.gestionnaireR = gestionnaireR;
        this.controleurClient = controleurClient;
        this.controleurChambre = controleurChambre;
    }

    public ControleurClient getControleurClient() {
        return controleurClient;
    }

    public ControleurChambre getControleurChambre() {
        return controleurChambre;
    }

    public void ajouterReservation(Reservation reservation) {
        this.gestionnaireR.ajouterReservation(reservation);
    }

    public void supprimerReservation(Reservation reservation) {
        this.gestionnaireR.supprimerReservation(reservation);
    }

    public boolean modifierReservation(Reservation oldR, Reservation newR) {
        return this.gestionnaireR.updateReservation(oldR, newR);
    }

    public Reservation getReservationParId(int id) {
        return gestionnaireR.getReservationParId(id);
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

    public void ajouterServiceAReservation(Reservation reservation, Service service) {
        gestionnaireR.ajouterServiceAReservation(reservation, service);
    }

}
