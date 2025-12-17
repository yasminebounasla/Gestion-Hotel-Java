import controller.ControleurPrincipal;
import view.VueChambre;
import view.VueReservationMenu;
import view.VueConsole;
import view.VueStatistiques;

public class App {
    public static void main(String[] args) {
        ControleurPrincipal controleur = new ControleurPrincipal();

        VueChambre vueChambre = new VueChambre(controleur.getControleurChambre());
        VueReservationMenu vueReservation = new VueReservationMenu(controleur.getControleurReservation());
        VueConsole vueConsole = new VueConsole(controleur);
        VueStatistiques vueStats = new VueStatistiques(controleur);

        // Exemple : on peut juste lancer le menu principal de la console
        int choix = -1;
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (choix != 0) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Gérer les chambres");
            System.out.println("2. Gérer les réservations");
            System.out.println("3. Autres fonctionnalités");
            System.out.println("4. Statistiques");
            System.out.println("0. Quitter");
            System.out.print("Choisissez une option: ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> vueChambre.afficherMenu();
                case 2 -> vueReservation.afficherMenu();
                case 3 -> vueConsole.afficher();
                case 4 -> vueStats.afficher();
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Option invalide !");
            }
        }

        scanner.close();
    }
}
