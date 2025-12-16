package controller;

import model.Chambres.GestionnaireChambres;
import model.Clients.GestionnaireClients;
import model.Reservations.GestionnaireReservations;
import model.Reservations.Observer.ReservationService;

public class ControleurPrincipal {

    private ControleurChambre controleurChambre;
    private ControleurClient controleurClient;
    private ControleurReservation controleurReservation;

    public ControleurPrincipal() {
        // init models
        GestionnaireChambres gc = new GestionnaireChambres();
        GestionnaireClients gcl = new GestionnaireClients();
        ReservationService service = new ReservationService();
        GestionnaireReservations gr = new GestionnaireReservations(service);

        // init controllers
        controleurChambre = new ControleurChambre(gc);
        controleurClient = new ControleurClient(gcl);
        controleurReservation = new ControleurReservation(gr);
    }

    public ControleurChambre getControleurChambre() {
        return controleurChambre;
    }

    public ControleurClient getControleurClient() {
        return controleurClient;
    }

    public ControleurReservation getControleurReservation() {
        return controleurReservation;
    }
}
