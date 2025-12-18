package controller;

import java.util.ArrayList;

import model.Reservations.GestionnaireReservations;
import model.Reservations.Reservation;
import model.Reservations.Service;

/**
 * Classe contrôleur pour les réservations.
 * 
 * Cette classe sert d'intermédiaire entre la vue et le gestionnaire 
 * de réservations. Elle permet de réaliser toutes les opérations sur 
 * les réservations, telles que l'ajout, la suppression, la modification, 
 * la consultation et la gestion des services associés à une réservation.
 * 
 * Elle donne également accès aux contrôleurs des clients et des chambres 
 * pour faciliter les interactions.
 */

public class ControleurReservation {

    private GestionnaireReservations gestionnaireR ; // Référence au gestionnaire de réservations
    private ControleurClient controleurClient;   // Référence au contrôleur des clients
    private ControleurChambre controleurChambre;    // Référence au contrôleur des chambres


    // constructeur
    public ControleurReservation(GestionnaireReservations gestionnaireR, ControleurClient controleurClient, ControleurChambre controleurChambre) {
        this.gestionnaireR = gestionnaireR;
        this.controleurClient = controleurClient;
        this.controleurChambre = controleurChambre;
    }

    // getters pour le contrôleur des clients
    public ControleurClient getControleurClient() {
        return controleurClient;
    }

    // getter pour le contrôleur des chambres
    public ControleurChambre getControleurChambre() {
        return controleurChambre;
    }


    // ajouter une réservation
    public void ajouterReservation(Reservation reservation) {
        this.gestionnaireR.ajouterReservation(reservation);
    }

    // supprimer une réservation
    public void supprimerReservation(Reservation reservation) {
        this.gestionnaireR.supprimerReservation(reservation);
    }

    // modifier une réservation
    public boolean modifierReservation(Reservation oldR, Reservation newR) {
        return this.gestionnaireR.updateReservation(oldR, newR);
    }

    // obtenir une réservation par son ID
    public Reservation getReservationParId(int id) {
        return gestionnaireR.getReservationParId(id);
    }

    //  vider toutes les réservations
    public void clearReservations() {
        this.gestionnaireR.clearReservations();
    }
    
    // obtenir le nombre total des réservations
    public int getNombreReservations() {
        return this.gestionnaireR.getNombreReservations();
    }

    // obtenir la liste des réservations
    public ArrayList<Reservation> getReservations() {
        return this.gestionnaireR.getReservations();
    }

    // ajouter un service à une réservation
    public void ajouterServiceAReservation(Reservation reservation, Service service) {
        gestionnaireR.ajouterServiceAReservation(reservation, service);
    }

}
