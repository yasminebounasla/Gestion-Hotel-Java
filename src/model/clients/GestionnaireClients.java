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
            if (client.getNom().equals(nom)) {
                return client;
            }
        }
        return null;
    }

    public int getNombreClients() {
        return this.clients.size();
    }

    public boolean updateClient(Client oldC, Client newC) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == oldC.getId()) {
                clients.set(i, newC);
                return true;
            }
        }
        return false;
    }


    public String getClientType(Client client) {
        return client.getTypeClient();
    }
}