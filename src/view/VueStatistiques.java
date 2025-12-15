package view;

import model.Reservations.GestionnaireReservations;
import model.Reservations.Observer.Observateur;
import model.Reservations.Observer.Sujet;

public class VueStatistiques implements Observateur{

      private GestionnaireReservations gestionnaire;


    public VueStatistiques(GestionnaireReservations gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    @Override
    public void mettreAJour(Sujet sujet) {
        int nbReservations = gestionnaire.getNombreReservations();

        System.out.println("\n=== Statistiques ===");
        System.out.println("Nombre total de réservations : " + nbReservations);
    }
}
