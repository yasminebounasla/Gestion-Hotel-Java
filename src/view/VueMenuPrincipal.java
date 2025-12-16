package view;

import java.util.Scanner;
import controller.ControleurPrincipal;

public class VueMenuPrincipal {
    private ControleurPrincipal controleurPrincipal;
    private Scanner scanner;

    public VueMenuPrincipal(ControleurPrincipal controleurPrincipal) {
        this.controleurPrincipal = controleurPrincipal;
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix = -1;
        while (choix != 0) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Gérer les chambres");
            System.out.println("2. Gérer les clients");
            System.out.println("3. Gérer les réservations");
            System.out.println("4. Statistiques");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    // Appeler la vue de gestion des chambres
                    new VueChambre(controleurPrincipal.getControleurChambre()).afficherMenu();
                    break;
                case 2:
                    // Appeler la vue de gestion des clients
                    new VueClient(controleurPrincipal.getControleurClient()).afficherMenu();
                    break;
                case 3:
                    // Appeler la vue de gestion des réservations
                    new VueReservation(controleurPrincipal.getControleurReservation()).afficherMenu();
                    break;
                case 4:
                    // Appeler la vue de gestion des réservations
                    new VueStatistiques(controleurPrincipal).afficher();
                    break;
                case 5:
                    // Appeler la vue de gestion des réservations
                    new VueConsole(controleurPrincipal).afficher();
                    break;
                case 0:
                    System.out.println("Au revoir");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }
}
