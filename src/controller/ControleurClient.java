package controller;

import java.util.ArrayList;

import model.Clients.*;
public class ControleurClient {

    private GestionnaireClients gestionnaireCl;

    public ControleurClient(GestionnaireClients gestionnaireCl) {
        this.gestionnaireCl = gestionnaireCl;
    }

    public boolean ajouterClient(Client client) {
        return this.gestionnaireCl.ajouterClient(client);
    }

    public void supprimerClient(Client client) {
        this.gestionnaireCl.supprimerClient(client);
    }

    public ArrayList<Client> getClients() {
        return gestionnaireCl.getClients();
    }

    public Client getClientParId(int id) {
        return gestionnaireCl.getClientParId(id);
    }

    public Client getClientParNom(String nom) {
        return gestionnaireCl.getClientParNom(nom);
    }

    public int getNombreClients() {
        return this.gestionnaireCl.getNombreClients();
    }

    public boolean updateClient(Client oldC, Client newC) {
        return gestionnaireCl.updateClient(oldC, newC);
    }

    public String getClientType(Client client) {
        return this.gestionnaireCl.getClientType(client);   
    }

    public double calculerPrix(Client client, double prixBase) {
        return gestionnaireCl.calculerPrix(client, prixBase);
    }

    // ----- VIP -----

    public boolean ajouterPointsVIP(Client client, int points) {
        return gestionnaireCl.ajouterPointsVIP(client, points);
    }

    public boolean utiliserPointsVIP(Client client, int points) {
        return gestionnaireCl.utiliserPointsVIP(client, points);
    }

    // ----- ENTREPRISE -----

    public void incrementerReservationEntreprise(Client client) {
        gestionnaireCl.incrementerReservationEntreprise(client);
    }

    public void decrementerReservationEntreprise(Client client) {
        gestionnaireCl.decrementerReservationEntreprise(client);
    }

    public double calculerPrixEntrepriseFidelite(Client client, double prixBase) {
        return gestionnaireCl.calculerPrixEntrepriseFidelite(client, prixBase);
    }

    public String obtenirFacturationEntreprise(Client client) {
        return gestionnaireCl.obtenirFacturationEntreprise(client);
    }
}