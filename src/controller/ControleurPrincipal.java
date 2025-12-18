package controller;

import model.Chambres.GestionnaireChambres;
import model.Clients.GestionnaireClients;
import model.Reservations.GestionnaireReservations;
import model.Reservations.Observer.ReservationService;
import view.VueReservationObserver;

/**
 * Classe principale du contrôleur de l'application.
 * 
 * Cette classe initialise les différents gestionnaires (chambres, clients, réservations)
 * ainsi que leurs contrôleurs correspondants. Elle met également en place 
 * le pattern Observer pour les réservations afin de notifier la vue en 
 * cas de changements.
 * 
 * Elle sert de point d'entrée pour accéder aux contrôleurs spécifiques 
 * depuis la vue.
 */
public class ControleurPrincipal {

    private ControleurChambre controleurChambre; // Contrôleur des chambres
    private ControleurClient controleurClient; // Contrôleur des clients
    private ControleurReservation controleurReservation; // Contrôleur des réservations

    public ControleurPrincipal() {
        // init models
        GestionnaireChambres gc = new GestionnaireChambres(); 
        GestionnaireClients gcl = new GestionnaireClients();
        ReservationService service = new ReservationService();
        GestionnaireReservations gr = new GestionnaireReservations(service);

        // init controllers
        controleurChambre = new ControleurChambre(gc);
        controleurClient = new ControleurClient(gcl);
        controleurReservation = new ControleurReservation(gr, controleurClient, controleurChambre);

        VueReservationObserver vueObserver = new VueReservationObserver(controleurReservation);
        service.ajouterObservateur(vueObserver); // Ajouter la vue comme observateur du service de réservation
    }

    // Getters pour le contrôleur des chambres
    public ControleurChambre getControleurChambre() {
        return controleurChambre;
    }

    // Getter pour le contrôleur des clients
    public ControleurClient getControleurClient() {
        return controleurClient;
    }

    // Getter pour le contrôleur des réservations
    public ControleurReservation getControleurReservation() {
        return controleurReservation;
    }
}
