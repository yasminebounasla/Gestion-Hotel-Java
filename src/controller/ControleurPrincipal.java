package controller;

import model.Chambres.GestionnaireChambres;
import model.Clients.GestionnaireClients;
import model.Reservations.GestionnaireReservations;
import model.Reservations.Observer.ReservationService;
import view.VueReservationObserver;

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
        controleurReservation = new ControleurReservation(gr, controleurClient, controleurChambre);

        VueReservationObserver vueObserver = new VueReservationObserver(controleurReservation);
        service.ajouterObservateur(vueObserver);
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
