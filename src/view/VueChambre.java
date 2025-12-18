package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.ControleurChambre;
import model.Chambres.Composite.Chambre;
import model.Chambres.Composite.ChambreDouble;
import model.Chambres.Composite.ChambreSimple;
import model.Chambres.Composite.StatutChambre;
import model.Chambres.Composite.Suite;

/**
 * Classe représentant la vue pour la gestion des chambres.
 * 
 * Cette classe permet à l'utilisateur d'interagir avec les chambres 
 * via la console. Elle propose un menu pour :
 *  - Ajouter, modifier et supprimer des chambres
 *  - Afficher toutes les chambres existantes
 *  - Gérer les sous-chambres des suites
 * 
 * Elle communique avec le ControleurChambre pour effectuer toutes les opérations.
 */

public class VueChambre {

    private ControleurChambre controleurChambre; // Référence au contrôleur des chambres
    private Scanner scanner; // Scanner pour la saisie utilisateur

    public VueChambre(ControleurChambre controleurChambre) {
        this.controleurChambre = controleurChambre;
        this.scanner = new Scanner(System.in);
    }

    // afficher le menu de gestion des chambres
    public void afficherMenu() { 
        int choix = -1; // Initialisation du choix utilisateur

        while (choix != 0) { // Boucle jusqu'à ce que l'utilisateur choisisse de quitter

            System.out.println("=== Menu Gestion des Chambres ===");
            System.out.println("1. Ajouter une chambre");
            System.out.println("2. Supprimer une chambre");
            System.out.println("3. Modifier une chambre");
            System.out.println("4. Afficher toutes les chambres");
            System.out.println("0. Retour au menu principal");
            System.out.print("Choisissez une option: ");
            choix = scanner.nextInt();
            scanner.nextLine(); 

            // Exécuter l'action en fonction du choix utilisateur
            switch (choix) {
                case 1 -> ajouterChambre();
                case 2 -> supprimerChambre();
                case 3 -> modifierChambre();
                case 4 -> afficherChambres();
                case 0 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    // ajouter une chambre
    private void ajouterChambre() {
        System.out.println("Type de chambre : ");
        System.out.println("1. Simple");
        System.out.println("2. Double");
        System.out.println("3. Suite");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Numéro de la chambre: ");
        int numeroChambre = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Étage de la chambre: ");
        int etage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Prix de base: ");
        double prixBase = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Statut de la chambre: ");
        System.out.println("1. Libre\n2. Occupée\n3. Maintenance");
        int statutChoice = scanner.nextInt();
        scanner.nextLine();

        // Déterminer le statut de la chambre
        StatutChambre statut;
        switch (statutChoice) {
            case 1 -> statut = StatutChambre.LIBRE;
            case 2 -> statut = StatutChambre.OCCUPEE;
            case 3 -> statut = StatutChambre.MAINTENANCE;
            default -> {
                System.out.println("Statut invalide.");
                return;
            }
        }

        System.out.println("Entrez les équipements (un par ligne, laissez vide pour finir) :");
        List<String> equipements = new ArrayList<>(); // Liste pour stocker les équipements
        while (true) {
            String eq = scanner.nextLine().trim(); // Lire l'équipement
            if (eq.isEmpty()) break; // Fin de la saisie si ligne vide
            equipements.add(eq); // Ajouter l'équipement à la liste
        }

        //  Créer la chambre en fonction du type choisi
        Chambre chambre;
        switch (type) {
            case 1 -> chambre = new ChambreSimple(numeroChambre, etage, prixBase, statut, equipements);
            case 2 -> chambre = new ChambreDouble(numeroChambre, etage, prixBase, statut, equipements);
            case 3 -> chambre = new Suite(numeroChambre, etage, prixBase, statut, equipements);
            default -> {
                System.out.println("Type invalide");
                return;
            }
        }

        controleurChambre.ajouterChambre(chambre); // Ajouter la chambre via le contrôleur
        System.out.println("Chambre ajoutée avec succès !");

        // Gérer les sous-chambres si c'est une suite (Composite)
        if (chambre instanceof Suite) {

            System.out.println("Voulez-vous ajouter des sous-chambres ? (1 = Oui, 0 = Non) : ");
            int choixSous = scanner.nextInt();
            scanner.nextLine();

            // Boucle pour ajouter plusieurs sous-chambres
            while (choixSous == 1) {

                ajouterSousChambreSuite((Suite) chambre); // Ajouter une sous-chambre à la suite
                System.out.println("Ajouter une autre sous-chambre ? (1 = Oui, 0 = Non) : ");
                choixSous = scanner.nextInt();
                scanner.nextLine();
            }
        }
    }


    // ajouter une sous-chambre à une suite
    private void ajouterSousChambreSuite(Suite suite) {
        System.out.println("Numéro de la chambre à ajouter comme sous-chambre : ");
        int num = scanner.nextInt();
        scanner.nextLine();
        
        Chambre c = controleurChambre.getChambreParNumero(num); // Récupérer la chambre par son numéro
        if (c != null) {
            suite.ajouterChambre(c);
            System.out.println("Sous-chambre ajoutée !");
        } else {
            System.out.println("Chambre non trouvée.");
        }
    }
        

    // supprimer une chambre
    private void supprimerChambre() {
        System.out.print("Entrez le numéro de la chambre à supprimer: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Chambre chambre = controleurChambre.getChambreParNumero(numero); // Récupérer la chambre par son numéro
        if (chambre != null) {
            controleurChambre.supprimerChambre(chambre);
            System.out.println("Chambre supprimée avec succès.");
        } else {
            System.out.println("Chambre non trouvée.");
        }
    }

    // modifier une chambre
    private void modifierChambre() {
        System.out.print("Entrez le numéro de la chambre à modifier: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Chambre chambre = controleurChambre.getChambreParNumero(numero); // Récupérer la chambre par son numéro
        if (chambre == null) {
            System.out.println("Chambre non trouvée.");
            return;
        }

        System.out.print("Nouveau numéro (actuel: " + chambre.getNumero() + "): ");
        int newNumero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nouvel étage (actuel: " + chambre.getEtage() + "): ");
        int newEtage = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nouveau prix de base (actuel: " + chambre.getPrixBase() + "): ");
        double newPrix = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Nouveau statut (actuel: " + chambre.getStatut() + "): ");
        System.out.println("1. Libre\n2. Occupée\n3. Maintenance");
        int statutChoice = scanner.nextInt();
        scanner.nextLine();

        // Déterminer le nouveau statut
        StatutChambre newStatut;
        switch (statutChoice) {
            case 1 -> newStatut = StatutChambre.LIBRE;
            case 2 -> newStatut = StatutChambre.OCCUPEE;
            case 3 -> newStatut = StatutChambre.MAINTENANCE;
            default -> {
                System.out.println("Statut invalide.");
                return;
            }
        }

        // Pour simplifier, on garde les équipements existants
        List<String> equipements = chambre.getEquipements();

        // Créer une nouvelle instance de la chambre modifiée
        Chambre nouvelleChambre;
        if (chambre instanceof ChambreSimple) {
            nouvelleChambre = new ChambreSimple(newNumero, newEtage, newPrix, newStatut, equipements);
        } else if (chambre instanceof ChambreDouble) {
            nouvelleChambre = new ChambreDouble(newNumero, newEtage, newPrix, newStatut, equipements);
        } else { // Suite
            nouvelleChambre = new Suite(newNumero, newEtage, newPrix, newStatut, equipements);
        }

        controleurChambre.modifierChambre(chambre, nouvelleChambre); // Modifier la chambre via le contrôleur
        System.out.println("Chambre modifiée avec succès !");
    }

    // afficher toutes les chambres
    private void afficherChambres() {
        System.out.println("=== Liste des Chambres ===");
        for (Chambre chambre : controleurChambre.getChambres()) {
            chambre.afficherDetails();
            System.out.println("-------------------------");
        }
    }
}