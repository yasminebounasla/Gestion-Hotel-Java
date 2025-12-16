package view;

import model.Clients.Client;

public class VueConsole {

    System.out.println("Nombre de clients: " + controleurClient.getNombreClients());

    private void afficherTypeClient() {
        System.out.print("Entrez l'ID du client: ");
        int id = scanner.nextInt();
        Client client = controleurClient.getClientParId(id);
        if (client != null) {
            String type = controleurClient.getClientType(client);
            System.out.println("Type du client: " + type);
        } else {
            System.out.println("Client non trouvé.");
        }
    }   

    private void afficherClientParId() {
        System.out.print("Entrez l'ID du client: ");
        int id = scanner.nextInt();
        Client client = controleurClient.getClientParId(id);
        if (client != null) {
            System.out.println("Client trouvé - ID: " + client.getId() + ", Nom: " + client.getNom());
        } else {
            System.out.println("Client non trouvé.");
        }
    }
    
    private void afficherClientParNom() {
        System.out.print("Entrez le nom du client: ");
        scanner.nextLine(); // Consommer la nouvelle ligne
        String nom = scanner.nextLine();
        Client client = controleurClient.getClientParNom(nom);
        if (client != null) {
            System.out.println("Client trouvé - ID: " + client.getId() + ", Nom: " + client.getNom());
        } else {
            System.out.println("Client non trouvé.");
        }
    }
}
