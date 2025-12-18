package view;

import controller.ControleurReservation;
import model.Reservations.Reservation;
import model.Reservations.Observer.Observateur;
import model.Reservations.Observer.Sujet;

/**
 * cette class observe les modifications des réservations.
 * 
 * elle implémente l'interface Observateur et affiche automatiquement
 * une mise à jour des réservations chaque fois qu'une réservation est ajoutée,
 * modifiée ou supprimée, en indiquant le client, le numéro de chambre et le prix total.
 */


public class VueReservationObserver implements Observateur{
    private ControleurReservation controleurReservation;

    public VueReservationObserver(ControleurReservation controleurReservation) {
        this.controleurReservation = controleurReservation;
    }
    @Override
    public void mettreAJour(Sujet sujet) {
        System.out.println("\n=== Mise à jour des reservations ===");

        for (Reservation r : controleurReservation.getReservations()) {
            String clientNomComplet = r.getClient().getNomComplet();
            int numeroChambre = r.getChambre().getNumero();
            double prixTotal = r.getPrixTotal();

            System.out.println("Client : " + clientNomComplet
                    + " | Chambre : " + numeroChambre
                    + " | Prix Total : " + prixTotal + " DA");
        }
    }
}
