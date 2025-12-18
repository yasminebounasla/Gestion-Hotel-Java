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

/**
 * Classe représentant le menu pour la gestion des réservations.
 * 
 * Permet à l'utilisateur de :
 * - Ajouter, supprimer et modifier des réservations
 * - Afficher toutes les réservations
 * - Ajouter des services à une réservation
 * 
 * Cette vue utilise le ControleurReservation pour effectuer les opérations
 * sur le modèle.
 */

public class VueReservationMenu {
    private ControleurReservation controleurResrevation; // Référence au contrôleur des réservations
    private Scanner scanner;

    public VueReservationMenu(ControleurReservation controleurReservation) {
        this.controleurResrevation = controleurReservation;
        this.scanner = new Scanner(System.in);
    }

    // afficher le menu de gestion des réservations
    public void afficherMenu() {
        int choix = -1; // Initialisation du choix utilisateur

        // Boucle jusqu'à ce que l'utilisateur choisisse de quitter
        while (choix != 0) {
            System.out.println("=== Menu Gestion des Reservations ===");
            System.out.println("1. Ajouter une reservation");
            System.out.println("2. Supprimer une reservation");
            System.out.println("3. Modifier une reservation");
            System.out.println("4. Afficher toutes les reservations");
            System.out.println("5. Ajouter un service à une réservation");
            System.out.println("0. Retour au menu principal");
            System.out.print("Choisissez une option: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            // Exécuter l'action en fonction du choix utilisateur
            switch (choix) {
                case 1 -> ajouterReservation();
                case 2 -> supprimerReservation();
                case 3 -> modifierReservation();
                case 4 -> afficherReservations();
                case 5 -> ajouterService();
                case 0 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    //  ajouter une réservation
    private void ajouterReservation() {
        System.out.println("Le Id du client : ");
        int idClient = scanner.nextInt();
        Client client = controleurResrevation.getControleurClient().getClientParId(idClient); // obtenir le client

        if(client == null) { // vérifier si le client existe
            System.out.println("Client non trouvé.");
            return;
        }
        scanner.nextLine();

        System.out.print("Numéro de la chambre: ");
        int numeroChambre = scanner.nextInt();

        Chambre chambre = controleurResrevation.getControleurChambre().getChambreParNumero(numeroChambre); // obtenir la chambre

        if(chambre == null) { // vérifier si la chambre existe
            System.out.println("Chambre non trouvée.");
            return;
        }
        scanner.nextLine();

        System.out.print("Date début (YYYY-MM-DD) : ");
        LocalDate dateDebut = LocalDate.parse(scanner.nextLine());

        System.out.print("Date fin (YYYY-MM-DD) : ");
        LocalDate dateFin = LocalDate.parse(scanner.nextLine());

        // dans la création initiale la liste des services est vide , on peut ajouter des services plus tard
        List<Service> services = new ArrayList<>(); 

        Reservation reservation = new Reservation( // créer la réservation
                client,
                chambre,
                dateDebut,
                dateFin,
                services
        );

        reservation.calculerPrixTotal(); // calculer le prix total de la réservation
        controleurResrevation.ajouterReservation(reservation); // ajouter la réservation via le contrôleur

        System.out.println("Réservation ajoutée avec succès !");
    }


    // supprimer une réservation
    private void supprimerReservation() {
        System.out.print("Entrez l'ID de la réservation à supprimer: ");
        int idReservation = scanner.nextInt();
        scanner.nextLine();

        Reservation reservation = controleurResrevation.getReservationParId(idReservation); // obtenir la réservation par son ID
        if (reservation != null) { // vérifier si la réservation existe
            controleurResrevation.supprimerReservation(reservation);
            System.out.println("Réservation supprimée avec succès !");

        } else {
            System.out.println("Réservation non trouvée.");
        }
    }

    // modifier une réservation
    private void modifierReservation() {

        System.out.print("ID de la réservation à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Reservation oldR = controleurResrevation.getReservationParId(id); // obtenir la réservation par son ID
        if (oldR == null) {
            System.out.println("Réservation introuvable.");
            return;
        }

        System.out.print("Nouvelle date début (YYYY-MM-DD) : ");
        LocalDate newDebut = LocalDate.parse(scanner.nextLine());

        System.out.print("Nouvelle date fin (YYYY-MM-DD) : ");
        LocalDate newFin = LocalDate.parse(scanner.nextLine());

        Reservation newR = new Reservation( // créer une nouvelle réservation avec les nouvelles dates
                oldR.getClient(),
                oldR.getChambre(),
                newDebut,
                newFin,
                oldR.getServices()
        );

        newR.calculerPrixTotal(); // calculer le prix total de la nouvelle réservation
        controleurResrevation.modifierReservation(oldR, newR); // modifier la réservation via le contrôleur

        System.out.println("Réservation modifiée.");
    }


    // afficher toutes les réservations
    private void afficherReservations() {
        System.out.println("=== Liste des Reservations ===");
        for (Reservation reservation : controleurResrevation.getReservations()) { // obtenir la liste des réservations
            System.out.println(reservation); 
            System.out.println("-------------------------");
        }
    }

    //ajouter un service à une réservation
    private void ajouterService() {
        System.out.print("ID de la réservation : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Reservation reservation = controleurResrevation.getReservationParId(id); // obtenir la réservation par son ID
        if (reservation == null) {
            System.out.println("Réservation introuvable.");
            return;
        }

        System.out.print("Nom du service : ");
        String nom = scanner.nextLine();

        System.out.print("Prix du service : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();

        Service service = new Service(nom, prix); // créer le service
        controleurResrevation.ajouterServiceAReservation(reservation, service); // ajouter le service 

        System.out.println("Service ajouté avec succès !");
    }


}