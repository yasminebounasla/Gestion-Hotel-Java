package view;

import model.reservations.GestionnaireReservations;
import model.reservations.Reservation;
import model.reservations.observer.Observateur;
import model.reservations.observer.Sujet;

public class VueReservation implements Observateur{
    private GestionnaireReservations gestionnaire;

    public VueReservation(GestionnaireReservations gestionnaire) {
        this.gestionnaire = gestionnaire;
    }
    @Override
    public void mettreAJour(Sujet sujet) {
        System.out.println("\n=== Mise à jour des réservations ===");

        for (Reservation r : gestionnaire.getReservations()) {
            String clientNomComplet = r.getClient().getNomComplet();
            int numeroChambre = r.getChambre().getNumero();
            double prixTotal = r.getPrixTotal();

            System.out.println("Client : " + clientNomComplet
                    + " | Chambre : " + numeroChambre
                    + " | Prix Total : " + prixTotal + " DA");
        }
    }
}
