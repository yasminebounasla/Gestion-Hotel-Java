package model.Clients;

import java.util.ArrayList;

/**
 * Classe représentant le gestionnaire des clients.
 * 
 * Cette classe gère la liste des clients de l'hôtel et fournit des méthodes 
 * pour ajouter, supprimer, rechercher et mettre à jour des clients.
 * Elle permet également de gérer des fonctionnalités spécifiques aux 
 * clients VIP et aux clients entreprises, comme les points fidélité ou
 * le calcul de prix avec avantages.
 */


public class GestionnaireClients {
    private ArrayList<Client> clients; //liste des clients de l'hôtel

    public GestionnaireClients() {
        this.clients = new ArrayList<>(); // Initialisation de la liste des clients
    }

    // Ajoute un client si il n'existe pas déjà
    public boolean ajouterClient(Client client) {
        if (!clients.contains(client)) {
            this.clients.add(client);
            return true;
        }
        return false; // Client déjà existant
    }

    // Supprime un client
    public void supprimerClient(Client client) {
        this.clients.remove(client);
    }

    // Retourne la liste complète des clients
    public ArrayList<Client> getClients() {
        return clients;
    }

    // Recherche un client par son ID
    public Client getClientParId(int id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    // Recherche un client par son nom
    public Client getClientParNom(String nom) {
        for (Client client : clients) {
            if (client.getNom().equalsIgnoreCase(nom)) {
                return client;
            }
        }
        return null;
    }

    // Retourne le nombre total de clients
    public int getNombreClients() {
        return this.clients.size();
    }

    // Met à jour les informations d'un client
    public boolean updateClient(Client oldClient,  Client newClient) {
        if (oldClient != null) {
            oldClient.setNom(newClient.getNom());
            oldClient.setPrenom(newClient.getPrenom());
            oldClient.setTelephone(newClient.getTelephone());
            oldClient.setEmail(newClient.getEmail());
            return true;
        }
        return false; // le cas ou le client n'existe pas
    }



    // avoir le type de client 
    public String getClientType(Client client) {
        return client.getTypeClient();
    }

    // Prix calculation
    public double calculerPrix(Client client, double prixBase) {
        return client.calculerPrixFinal(prixBase);
    }

    //Gestion des points pour les clients VIP

    public boolean ajouterPointsVIP(Client client, int points) {
        if (client instanceof ClientVIP vip) {
            vip.ajouterPoints(points);
            return true;
        }
        return false;
    }

    public boolean utiliserPointsVIP(Client client, int points) {
        if (client instanceof ClientVIP vip) {
            return vip.utiliserPoints(points);
        }
        return false;
    }

    // gestion des réservations pour les clients entreprises

    // Incrémente le nombre de réservations pour un client entreprise
    public void incrementerReservationEntreprise(Client client) {
        if (client instanceof ClientEntreprise ce) {
            ce.incrementerReservations();
        }
    }

    // Décrémente le nombre de réservations pour un client entreprise
    public void decrementerReservationEntreprise(Client client) {
        if (client instanceof ClientEntreprise ce) {
            ce.decrementerReservations();
        }
    }

    // Calcule le prix avec les avantages fidélité pour un client entreprise
    public double calculerPrixEntrepriseFidelite(Client client, double prixBase) {
        if (client instanceof ClientEntreprise ce) {
            return ce.calculerPrixAvecFidelite(prixBase);
        }
        throw new IllegalArgumentException("Client non entreprise");
    }

    // Obtient les informations de facturation pour un client entreprise
    public String obtenirFacturationEntreprise(Client client) {
        if (client instanceof ClientEntreprise ce) {
            return ce.obtenirInfosFacturation();
        }
        return "Ce client n'est pas une entreprise.";
    }

}