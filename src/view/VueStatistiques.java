package view;


import controller.ControleurPrincipal;
import model.Reservations.Observer.Observateur;
import model.Reservations.Observer.Sujet;

/**
 * cette class affiche les statistiques globales de l'hôtel.
 * 
 * Cette classe observe les changements liés aux réservations et met à jour
 * automatiquement les statistiques comme le nombre total de réservations,
 * de clients, de chambres et de chambres disponibles.
 */


public class VueStatistiques implements Observateur{

    private ControleurPrincipal controleurPrincipal; // Référence au contrôleur principal


    // constructeur
    public VueStatistiques(ControleurPrincipal controleurPrincipal) {
        this.controleurPrincipal = controleurPrincipal;
    }

    
    @Override
    public void mettreAJour(Sujet sujet) { // Méthode appelée lors d'une mise à jour du sujet observé
        afficher();
    }

    // afficher les statistiques
    public void afficher() {
        int nbReservations = controleurPrincipal.getControleurReservation().getNombreReservations();

        System.out.println("\n=== Statistiques ===");
        System.out.println("Nombre total de réservations : " + nbReservations);
        System.out.println("Nombre total des clients : " + controleurPrincipal.getControleurClient().getNombreClients());
        System.out.println("Nombre total des chambres : " + controleurPrincipal.getControleurChambre().getNombreChambres());
        System.out.println("Nombre total des chambres disponibles : " + controleurPrincipal.getControleurChambre().getChambresDisponibles().size());

    }
}