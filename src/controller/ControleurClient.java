package controller;

import java.util.ArrayList;

import model.Clients.*;

/**
 * Classe contrôleur pour les clients.
 * 
 * Cette classe fait le lien entre la vue et le gestionnaire de clients.
 * Elle permet de réaliser toutes les opérations sur les clients, 
 * telles que l'ajout, la suppression, la modification et la consultation.
 * Elle prend également en charge les fonctionnalités spécifiques aux 
 * clients VIP et aux clients entreprise.
 */

public class ControleurClient {

    private GestionnaireClients gestionnaireCl; // Référence au gestionnaire de clients

    public ControleurClient(GestionnaireClients gestionnaireCl) {
        this.gestionnaireCl = gestionnaireCl; // Initialisation du gestionnaire de clients
    }

    // ajouter un client
    public boolean ajouterClient(Client client) {
        return this.gestionnaireCl.ajouterClient(client); // Déléguer l'ajout au gestionnaire
    }

    // supprimer un client
    public void supprimerClient(Client client) {
        this.gestionnaireCl.supprimerClient(client); // Déléguer la suppression au gestionnaire
    }

    // obtenir la liste des clients
    public ArrayList<Client> getClients() {
        return gestionnaireCl.getClients(); // Déléguer la récupération au gestionnaire
    }

    // obtenir un client par son ID
    public Client getClientParId(int id) {
        return gestionnaireCl.getClientParId(id); // Déléguer la récupération au gestionnaire
    }

    // obtenir un client par son nom
    public Client getClientParNom(String nom) {
        return gestionnaireCl.getClientParNom(nom); // Déléguer la récupération au gestionnaire
    }

    // obtenir le nombre total des clients
    public int getNombreClients() {
        return this.gestionnaireCl.getNombreClients(); // Déléguer la récupération au gestionnaire
    }

    // modifier un client
    public boolean updateClient(Client oldC, Client newC) {
        return gestionnaireCl.updateClient(oldC, newC); // Déléguer la modification au gestionnaire
    }

    // obtenir le type d'un client
    public String getClientType(Client client) {
        return this.gestionnaireCl.getClientType(client);   // Déléguer la récupération au gestionnaire
    }

    // calculer le prix pour un client
    public double calculerPrix(Client client, double prixBase) {
        return gestionnaireCl.calculerPrix(client, prixBase); // Déléguer le calcul au gestionnaire
    }

    // ----- VIP -----

    // ajouter des points VIP
    public boolean ajouterPointsVIP(Client client, int points) {
        return gestionnaireCl.ajouterPointsVIP(client, points);
    }

    // utiliser des points VIP
    public boolean utiliserPointsVIP(Client client, int points) {
        return gestionnaireCl.utiliserPointsVIP(client, points);
    }

    // ----- ENTREPRISE -----

    // incrémenter le nombre de réservations entreprise
    public void incrementerReservationEntreprise(Client client) {
        gestionnaireCl.incrementerReservationEntreprise(client);
    }

    // décrémenter le nombre de réservations entreprise
    public void decrementerReservationEntreprise(Client client) {
        gestionnaireCl.decrementerReservationEntreprise(client);
    }

    //  calculer le prix avec fidélité pour un client entreprise
    public double calculerPrixEntrepriseFidelite(Client client, double prixBase) {
        return gestionnaireCl.calculerPrixEntrepriseFidelite(client, prixBase);
    }
    
    // obtenir la facturation d'un client entreprise
    public String obtenirFacturationEntreprise(Client client) {
        return gestionnaireCl.obtenirFacturationEntreprise(client);
    }
}