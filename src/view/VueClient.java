package view;

import java.util.Scanner;
import controller.ControleurClient;
import model.Clients.Client;
import model.Clients.ClientEntreprise;
import model.Clients.ClientRegulier;
import model.Clients.ClientVIP;

/**
 * Classe représentant la vue pour la gestion des clients.
 * 
 * Cette classe permet à l'utilisateur d'interagir avec les clients via la console.
 * Elle offre un menu pour :
 *  - Ajouter, modifier et supprimer des clients
 *  - Afficher tous les clients
 *  - Gérer les points fidélité pour les clients VIP
 *  - Gérer la fidélité et la facturation pour les clients Entreprise
 * 
 * Elle utilise le ControleurClient pour effectuer toutes les opérations nécessaires.
 */

public class VueClient {
    private ControleurClient controleurClient; // Référence au contrôleur des clients
    private Scanner scanner; // Scanner pour la saisie utilisateur

    public VueClient(ControleurClient controleurClient) {
        this.controleurClient = controleurClient;
        this.scanner = new Scanner(System.in);
    }

    // afficher le menu de gestion des clients
    public void afficherMenu() {
        int choix = -1; // Initialisation du choix utilisateur

        while (choix != 0) { // Boucle jusqu'à ce que l'utilisateur choisisse de quitter

            System.out.println("=== Menu Gestion des Clients ===");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Supprimer un client");
            System.out.println("3. Modifier un client");
            System.out.println("4. Afficher tous les clients");
            System.out.println("6. Gestion points fidélité (VIP)");
            System.out.println("7. Gestion fidélité entreprise");
            System.out.println("8. Afficher facture entreprise");
            System.out.println("0. Retour au menu principal");
            System.out.print("Choisissez une option: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            // Exécuter l'action en fonction du choix utilisateur
            switch (choix) {
                case 1:
                    ajouterClient();
                    break;
                case 2:
                    supprimerClient();
                    break;
                case 3:
                    modifierClient();
                    break;
                case 4:
                    afficherClients();
                    break;
                case 6 :
                    gestionPointsVIP();
                    break;
                case 7 :
                    gestionEntreprise();
                    break;
                case 8 :
                    afficherFactureEntreprise();
                    break;
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    // ajouter un client
    private void ajouterClient() {
        System.out.println("Type de client : ");
        System.out.println("1. Régulier");
        System.out.println("2. VIP");
        System.out.println("3. Entreprise");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nom: ");
        String nom = scanner.nextLine();

        System.out.print("Prénom: ");
        String prenom = scanner.nextLine();

        System.out.print("Téléphone: ");
        String tel = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        Client client;

        // Créer le client en fonction du type choisi
        switch (type) {
            case 1 -> client = new ClientRegulier(nom, prenom, tel, email);
            case 2 -> client = new ClientVIP(nom, prenom, tel, email);
            case 3 -> {
                // paramètres supplémentaires pour Entreprise
                System.out.print("Nom de l'entreprise: ");
                String nomEntreprise = scanner.nextLine();

                System.out.print("Numéro SIRET: ");
                String numeroSIRET = scanner.nextLine();

                System.out.print("Adresse de facturation: ");
                String adresseFacturation = scanner.nextLine();

                client = new ClientEntreprise(nom, prenom, tel, email, nomEntreprise, numeroSIRET, adresseFacturation);
            }
            default -> {
                System.out.println("Type invalide");
                return;
            }
        }

        controleurClient.ajouterClient(client); // Ajouter le client via le contrôleur
        System.out.println("Client ajouté avec succès");
    }


    // supprimer un client
    private void supprimerClient() {

        System.out.print("Entrez l'ID du client à supprimer: ");
        int id = scanner.nextInt();
        Client client = controleurClient.getClientParId(id); // Récupérer le client par son ID

        if (client != null) {
            controleurClient.supprimerClient(client);
            System.out.println("Client supprimé avec succès.");
        } else {
            System.out.println("Client non trouvé.");
        }
    }

    // modifier un client
    private void modifierClient() {

        System.out.print("Entrez l'ID du client à modifier: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
 
        Client oldClient = controleurClient.getClientParId(id); // Récupérer le client par son ID

        if (oldClient != null) {

            System.out.print("Entrez le nouveau nom du client: ");
            String newNom = scanner.nextLine();

            System.out.print("Entrez le nouveau prénom du client: ");
            String newPrenom = scanner.nextLine();

            System.out.print("Entrez le nouveau numéro de téléphone du client: ");
            String newTelephone = scanner.nextLine();

            System.out.print("Entrez le nouveau email du client: ");
            String newEmail = scanner.nextLine();

            // Vérifier le type de client pour créer le bon objet
            Client newClient;
            if (oldClient instanceof ClientEntreprise) {

                System.out.print("Nom de l'entreprise: ");
                String nomEntreprise = scanner.nextLine();

                System.out.print("Numéro SIRET: ");
                String numeroSIRET = scanner.nextLine();

                System.out.print("Adresse de facturation: ");
                String adresseFacturation = scanner.nextLine();

                newClient = new ClientEntreprise(newNom, newPrenom, newTelephone, newEmail,
                                            nomEntreprise, numeroSIRET, adresseFacturation);


            } else if (oldClient instanceof ClientVIP) { // ClientVIP
                newClient = new ClientVIP(newNom, newPrenom, newTelephone, newEmail);

            } else { // ClientRegulier
                newClient = new ClientRegulier(newNom, newPrenom, newTelephone, newEmail);
            }

            if (controleurClient.updateClient(oldClient, newClient)) { // Modifier le client via le contrôleur

                System.out.println("Client modifié avec succès.");
            } else {
                System.out.println("Échec de la modification du client.");
            }

        } else {
            System.out.println("Client non trouvé.");
        }
   }


    // afficher tous les clients
    private void afficherClients() {
        System.out.println("=== Liste des Clients ===");
        for (Client client : controleurClient.getClients()) { // Récupérer tous les clients via le contrôleur
            System.out.println(client);
        }
    }    

    // Métier 

    
    // gestion des points fidélité pour les clients VIP
    private void gestionPointsVIP() {
        Client c = demanderClientParId();

        if (!(c instanceof ClientVIP vip)) { // vérifier si le client est VIP
            System.out.println("Ce client n'est pas VIP.");
            return;
        }

        System.out.println("Points actuels: " + vip.getPointsFidelite());
        System.out.print("Points à utiliser: ");
        int p = scanner.nextInt();

        if (controleurClient.utiliserPointsVIP(c, p)) // utiliser les points via le contrôleur
            System.out.println("Points utilisés.");
        else
            System.out.println("Points insuffisants.");
    }

    // gestion fidélité pour les clients Entreprise
    private void gestionEntreprise() {
        Client c = demanderClientParId();

        if (!(c instanceof ClientEntreprise)) { // vérifier si le client est Entreprise
            System.out.println("Ce client n'est pas une entreprise.");
            return;
        }

        System.out.println("1. Calcul prix fidélité");
        System.out.println("2. Annuler réservation");
        int choix = scanner.nextInt();

        // calculer le prix avec fidélité 
        if (choix == 1) {
            System.out.print("Prix de base: ");
            double prix = scanner.nextDouble();
            System.out.println("Prix final: " +
                    controleurClient.calculerPrixEntrepriseFidelite(c, prix));

        } else if (choix == 2) { // annuler une réservation
            controleurClient.decrementerReservationEntreprise(c); 
            System.out.println("Réservation annulée.");
        }
    }

    // afficher la facture pour un client Entreprise
    private void afficherFactureEntreprise() {
        Client c = demanderClientParId();
        System.out.println(controleurClient.obtenirFacturationEntreprise(c));
    }

    // Utils

    // demander un client par son ID
    private Client demanderClientParId() {
        System.out.print("ID client: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Client c = controleurClient.getClientParId(id);
        if (c == null)
            System.out.println("Client introuvable.");
        return c;
    }
}