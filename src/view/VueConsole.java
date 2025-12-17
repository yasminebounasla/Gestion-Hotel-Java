package view;

import java.util.List;
import java.util.Scanner;

import controller.ControleurPrincipal;
import model.Chambres.Composite.Chambre;
import model.Clients.Client;

public class VueConsole {
    
    private Scanner scanner;
    private ControleurPrincipal controleurPrincipal;

    public VueConsole(ControleurPrincipal controleurPrincipal) {
        this.controleurPrincipal = controleurPrincipal;
        this.scanner = new Scanner(System.in);
    }

    public void afficher() {

        int choix = -1;
        while (choix != 0) {
            System.out.println("=== Autres fonctionnalités ===");
            System.out.println("1. Supprimer toutes les réservations");
            System.out.println("2. Avoir le type d'un client par son ID");
            System.out.println("3. Avoir un client par son nom");
            System.out.println("4. Afficher la liste des chambres disponibles");
            System.out.println("5. Avoir le statut d'une chambre par son numéro");
            System.out.println("0. Retour au menu principal");
            System.out.print("Choisissez une option: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1 -> clearReservations();
                case 2 -> afficherTypeClient();
                case 3 -> afficherClientParNom();
                case 4 -> afficherChambresDisponibles();
                case 5 -> afficherStatusChambre();
                case 0 -> System.out.println("Retour au menu principal.");
                default -> System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
    }

    private void clearReservations() {
        controleurPrincipal.getControleurReservation().clearReservations();
        System.out.println("Toutes les réservations ont été supprimées !");
    }

    private void afficherTypeClient() {
        System.out.print("Entrez l'ID du client: ");
        int id = scanner.nextInt();

        Client client = controleurPrincipal.getControleurClient().getClientParId(id);
        if (client != null) {
            String type = controleurPrincipal.getControleurClient().getClientType(client);
            System.out.println("Type du client: " + type);
        } else {
            System.out.println("Client non trouvé.");
        }
    }   
    
    private void afficherClientParNom() {
        System.out.print("Entrez le nom du client: ");
        String nom = scanner.nextLine();

        Client client = controleurPrincipal.getControleurClient().getClientParNom(nom);
        if (client != null) {
            System.out.println("Client trouvé - ID: " + client.getId() + ", Nom: " + client.getNomComplet());
        } else {
            System.out.println("Client non trouvé.");
        }
    }

    private void afficherChambresDisponibles() {
        List<Chambre> chambresDisponibles = controleurPrincipal.getControleurChambre().getChambresDisponibles();
        if (chambresDisponibles.isEmpty()) {
            System.out.println("Aucune chambre disponible.");
        } else {
            System.out.println("Chambres disponibles :");
            for (Chambre c : chambresDisponibles) {
                System.out.println("Chambre n°" + c.getNumero() + " | Étage: " + c.getEtage() + " | Prix: " + c.getPrixBase());
            }
        }
    }

    private void afficherStatusChambre() {
        System.out.print("Entrez le numéro de la chambre: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Chambre Chambre = controleurPrincipal.getControleurChambre().getChambreParNumero(numero);

        String statut = controleurPrincipal.getControleurChambre().getStatut(Chambre);
        if (statut != null) {
            System.out.println("Statut de la chambre n°" + numero + " : " + statut);
        } else {
            System.out.println("Chambre non trouvée.");
        }
    }
}