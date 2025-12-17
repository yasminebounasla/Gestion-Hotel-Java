package view;


import controller.ControleurPrincipal;
import model.Reservations.Observer.Observateur;
import model.Reservations.Observer.Sujet;

public class VueStatistiques implements Observateur{

    private ControleurPrincipal controleurPrincipal;


    public VueStatistiques(ControleurPrincipal controleurPrincipal) {
        this.controleurPrincipal = controleurPrincipal;
    }

    @Override
    public void mettreAJour(Sujet sujet) {
        afficher();
    }

    public void afficher() {
        int nbReservations = controleurPrincipal.getControleurReservation().getNombreReservations();

        System.out.println("\n=== Statistiques ===");
        System.out.println("Nombre total de réservations : " + nbReservations);
        System.out.println("Nombre total des clients : " + controleurPrincipal.getControleurClient().getNombreClients());
        System.out.println("Nombre total des chambres : " + controleurPrincipal.getControleurChambre().getNombreChambres());
        System.out.println("Nombre total des chambres disponibles : " + controleurPrincipal.getControleurChambre().getChambresDisponibles().size());

    }
}
