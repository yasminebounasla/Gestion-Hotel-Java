package view;

import java.util.Scanner;
import controller.ControleurClient;
import model.Clients.Client;
import model.Clients.ClientEntreprise;
import model.Clients.ClientRegulier;
import model.Clients.ClientVIP;

public class VueClient {
    private ControleurClient controleurClient;
    private Scanner scanner;

    public VueClient(ControleurClient controleurClient) {
        this.controleurClient = controleurClient;
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix = -1;
        while (choix != 0) {
            System.out.println("=== Menu Gestion des Clients ===");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Supprimer un client");
            System.out.println("3. Modifier un client");
            System.out.println("4. Afficher tous les clients");
            System.out.println("5. avoir le nombre de clients");
            System.out.println("6. afficher le type d'un client");
            System.out.println("7. afficher un client par ID");
            System.out.println("8. afficher par nom");
            System.out.println("0. Retour au menu principal");
            System.out.print("Choisissez une option: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

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
                case 0:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

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

        controleurClient.ajouterClient(client);
        System.out.println("Client ajouté avec succès");
    }


    private void supprimerClient() {

        System.out.print("Entrez l'ID du client à supprimer: ");
        int id = scanner.nextInt();
        Client client = controleurClient.getClientParId(id);

        if (client != null) {
            controleurClient.supprimerClient(client);
            System.out.println("Client supprimé avec succès.");
        } else {
            System.out.println("Client non trouvé.");
        }
    }

    private void modifierClient() {

        System.out.print("Entrez l'ID du client à modifier: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Client oldClient = controleurClient.getClientParId(id);

        if (oldClient != null) {

            System.out.print("Entrez le nouveau nom du client: ");
            String newNom = scanner.nextLine();

            // Vérifier le type de client pour créer le bon objet
            Client newClient;
            if (oldClient instanceof ClientEntreprise ce) {

                System.out.print("Entrez le nouveau prénom: ");
                String newPrenom = scanner.nextLine();

                System.out.print("Nom de l'entreprise: ");
                String nomEntreprise = scanner.nextLine();

                System.out.print("Numéro SIRET: ");
                String numeroSIRET = scanner.nextLine();

                System.out.print("Adresse de facturation: ");
                String adresseFacturation = scanner.nextLine();

                newClient = new ClientEntreprise(newNom, newPrenom, ce.getTelephone(), ce.getEmail(),
                                            nomEntreprise, numeroSIRET, adresseFacturation);

            } else if (oldClient instanceof ClientVIP) {
                newClient = new ClientVIP(newNom, oldClient.getPrenom(), oldClient.getTelephone(), oldClient.getEmail());

            } else { // ClientRegulier
                newClient = new ClientRegulier(newNom, oldClient.getPrenom(), oldClient.getTelephone(), oldClient.getEmail());
            }

            if (controleurClient.updateClient(oldClient, newClient)) {
                System.out.println("Client modifié avec succès.");
            } else {
                System.out.println("Échec de la modification du client.");
            }

        } else {
            System.out.println("Client non trouvé.");
        }
   }



    private void afficherClients() {
        System.out.println("=== Liste des Clients ===");
        for (Client client : controleurClient.getClients()) {
            System.out.println(client);
        }
    }    
}
