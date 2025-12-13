package model.Clients;

import model.Clients.Strategy.PrixRegulier;

/**
 * Classe représentant un client régulier de l'hôtel.
 * Un client régulier paie le tarif standard (100% du prix de base).
 */
public class ClientRegulier extends Client {
    
    /**
     * Constructeur pour créer un client régulier.
     * Initialise automatiquement la stratégie de prix régulier (0% de réduction).
     * 
     * @param nom 
     * @param prenom 
     * @param telephone 
     * @param email 
     */
    public ClientRegulier(String nom, String prenom, String telephone, String email) {
        super(nom, prenom, telephone, email);
        // Initialisation de la stratégie de prix régulier
        this.strategyPrix = new PrixRegulier();
    }
    
    /**
     * Retourne le type de ce client.
     * 
     * @return "Régulier"
     */
    @Override
    public String getTypeClient() {
        return "Régulier";
    }
    
    /**
     * Affiche les informations spécifiques d'un client régulier.
     * 
     * @return Les informations du client avec mention "Tarif standard"
     */
    @Override
    public String afficherInfos() {
        return super.afficherInfos() + " | Tarif: Standard (0% réduction)";
    }
}