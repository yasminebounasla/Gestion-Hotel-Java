package view;

import model.reservations.GestionnaireReservations;
import model.reservations.observer.Observateur;
import model.reservations.observer.Sujet;

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
