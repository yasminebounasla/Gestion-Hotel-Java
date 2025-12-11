package model.clients;

import model.clients.strategy.PrixVIP;

/**
 * Classe représentant un client VIP de l'hôtel.
 * 
 * Un client VIP bénéficie d'une réduction de 15% sur toutes les réservations.
 * Il dispose également d'un système de points de fidélité.
 */
public class ClientVIP extends Client {
    
    private int pointsFidelite; // Points de fidélité accumulés
    
    /**
     * Constructeur pour créer un client VIP.
     * Initialise automatiquement la stratégie de prix VIP (15% de réduction).
     * 
     * @param nom 
     * @param prenom 
     * @param telephone 
     * @param email 
     */
    public ClientVIP(String nom, String prenom, String telephone, String email) {
        super(nom, prenom, telephone, email);
        // Initialisation de la stratégie de prix VIP
        this.strategyPrix = new PrixVIP();
        this.pointsFidelite = 0;
    }
    
    /**
     * Retourne le type de ce client.
     * 
     * @return "VIP"
     */
    @Override
    public String getTypeClient() {
        return "VIP";
    }
    
    // --- GESTION DES POINTS DE FIDÉLITÉ ---
    
    /**
     * Retourne le nombre de points de fidélité du client VIP.
     * 
     * @return Le nombre de points
     */
    public int getPointsFidelite() {
        return pointsFidelite;
    }
    
    /**
     * Ajoute des points de fidélité au client VIP.
     * 
     * @param points Le nombre de points à ajouter
     * @throws IllegalArgumentException si le nombre de points est négatif
     */
    public void ajouterPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Le nombre de points ne peut pas être négatif");
        }
        this.pointsFidelite += points;
    }
    
    /**
     * Utilise des points de fidélité (par exemple pour une réduction).
     * 
     * @param points Le nombre de points à utiliser
     * @return true si les points ont été utilisés, false si pas assez de points
     * @throws IllegalArgumentException si le nombre de points est négatif
     */
    public boolean utiliserPoints(int points) {
        if (points < 0) {
            throw new IllegalArgumentException("Le nombre de points ne peut pas être négatif");
        }
        if (this.pointsFidelite >= points) {
            this.pointsFidelite -= points;
            return true;
        }
        return false;
    }
    
    /**
     * Affiche les informations spécifiques d'un client VIP.
     * 
     * @return Les informations du client avec réduction et points de fidélité
     */
    @Override
    public String afficherInfos() {
        return super.afficherInfos() + 
                " | Réduction: 15% | Points fidélité: " + pointsFidelite;
    }
}