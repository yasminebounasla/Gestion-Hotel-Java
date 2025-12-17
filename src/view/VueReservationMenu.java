package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

import model.Reservations.Service;
import controller.ControleurReservation;
import model.Chambres.Composite.Chambre;
import model.Clients.Client;
import model.Reservations.Reservation;

public class VueReservationMenu {
    private ControleurReservation controleurResrevation;
    private Scanner scanner;

    public VueReservationMenu(ControleurReservation controleurReservation) {
        this.controleurResrevation = controleurReservation;
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix = -1;
        while (choix != 0) {
            System.out.println("=== Menu Gestion des Reservations ===");
            System.out.println("1. Ajouter une reservation");
            System.out.println("2. Supprimer une reservation");
            System.out.println("3. Modifier une reservation");
            System.out.println("4. Afficher toutes les reservations");
            System.out.println("0. Retour au menu principal");
            System.out.print("Choisissez une option: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1 -> ajouterReservation();
                case 2 -> supprimerReservation();
                case 3 -> modifierReservation();
                case 4 -> afficherReservations();
                case 0 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private void ajouterReservation() {
        System.out.println("Le Id du client : ");
        int idClient = scanner.nextInt();
        Client client = controleurResrevation.getControleurClient().getClientParId(idClient);

        if(client == null) {
            System.out.println("Client non trouvé.");
            return;
        }
        scanner.nextLine();

        System.out.print("Numéro de la chambre: ");
        int numeroChambre = scanner.nextInt();

        Chambre chambre = controleurResrevation.getControleurChambre().getChambreParNumero(numeroChambre);
        if(chambre == null) {
            System.out.println("Chambre non trouvée.");
            return;
        }
        scanner.nextLine();

        System.out.print("Date début (YYYY-MM-DD) : ");
        LocalDate dateDebut = LocalDate.parse(scanner.nextLine());

        System.out.print("Date fin (YYYY-MM-DD) : ");
        LocalDate dateFin = LocalDate.parse(scanner.nextLine());

        // Services (simple pour GL)
        List<Service> services = new ArrayList<>();

        Reservation reservation = new Reservation(
                client,
                chambre,
                dateDebut,
                dateFin,
                services
        );

        reservation.calculerPrixTotal();
        controleurResrevation.ajouterReservation(reservation);

        System.out.println("Réservation ajoutée avec succès !");
    }

    private void supprimerReservation() {
        System.out.print("Entrez l'ID de la réservation à supprimer: ");
        int idReservation = scanner.nextInt();
        scanner.nextLine();

        Reservation reservation = controleurResrevation.getReservationParId(idReservation);
        if (reservation != null) {
            controleurResrevation.supprimerReservation(reservation);
            System.out.println("Réservation supprimée avec succès !");

        } else {
            System.out.println("Réservation non trouvée.");
        }
    }

    private void modifierReservation() {

        System.out.print("ID de la réservation à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Reservation oldR = controleurResrevation.getReservationParId(id);
        if (oldR == null) {
            System.out.println("Réservation introuvable.");
            return;
        }

        System.out.print("Nouvelle date début (YYYY-MM-DD) : ");
        LocalDate newDebut = LocalDate.parse(scanner.nextLine());

        System.out.print("Nouvelle date fin (YYYY-MM-DD) : ");
        LocalDate newFin = LocalDate.parse(scanner.nextLine());

        Reservation newR = new Reservation(
                oldR.getClient(),
                oldR.getChambre(),
                newDebut,
                newFin,
                oldR.getServices()
        );

        newR.calculerPrixTotal();
        controleurResrevation.modifierReservation(oldR, newR);

        System.out.println("Réservation modifiée.");
    }

    private void afficherReservations() {
        System.out.println("=== Liste des Reservations ===");
        for (Reservation reservation : controleurResrevation.getReservations()) {
            System.out.println(reservation); 
            System.out.println("-------------------------");
        }
    }

}
