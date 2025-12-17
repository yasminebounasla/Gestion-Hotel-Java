package model.Clients;

import java.util.ArrayList;

public class GestionnaireClients {
    private ArrayList<Client> clients;

    public GestionnaireClients() {
        this.clients = new ArrayList<>();
    }

    public boolean ajouterClient(Client client) {
        if (!clients.contains(client)) {
            this.clients.add(client);
            return true;
        }
        return false; // Client déjà existant
    }

    public void supprimerClient(Client client) {
        this.clients.remove(client);
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public Client getClientParId(int id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    public Client getClientParNom(String nom) {
        for (Client client : clients) {
            if (client.getNom().equalsIgnoreCase(nom)) {
                return client;
            }
        }
        return null;
    }

    public int getNombreClients() {
        return this.clients.size();
    }

    public boolean updateClient(Client oldClient,  Client newClient) {
        if (oldClient != null) {
            oldClient.setNom(newClient.getNom());
            oldClient.setPrenom(newClient.getPrenom());
            oldClient.setTelephone(newClient.getTelephone());
            oldClient.setEmail(newClient.getEmail());
            return true;
        }
        return false;
    }



    public String getClientType(Client client) {
        return client.getTypeClient();
    }

    public double calculerPrix(Client client, double prixBase) {
        return client.calculerPrixFinal(prixBase);
    }

    //VIP Points management

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

    // Entreprise reservations 

    public void incrementerReservationEntreprise(Client client) {
        if (client instanceof ClientEntreprise ce) {
            ce.incrementerReservations();
        }
    }

    public void decrementerReservationEntreprise(Client client) {
        if (client instanceof ClientEntreprise ce) {
            ce.decrementerReservations();
        }
    }

    public double calculerPrixEntrepriseFidelite(Client client, double prixBase) {
        if (client instanceof ClientEntreprise ce) {
            return ce.calculerPrixAvecFidelite(prixBase);
        }
        throw new IllegalArgumentException("Client non entreprise");
    }

    public String obtenirFacturationEntreprise(Client client) {
        if (client instanceof ClientEntreprise ce) {
            return ce.obtenirInfosFacturation();
        }
        return "Ce client n'est pas une entreprise.";
    }

}