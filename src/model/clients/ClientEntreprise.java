package model.clients;

import model.clients.strategy.PrixEntreprise;

/**
 * Classe représentant un client Entreprise de l'hôtel.
 * 
 * Un client Entreprise bénéficie de :
 * - 20% de réduction sur toutes les réservations
 * - Possibilité de facturation groupée
 * - Gestion de plusieurs réservations simultanées
 */
public class ClientEntreprise extends Client {
    
    private String nomEntreprise;      
    private String numeroSIRET;        
    private String adresseFacturation; 
    private int nombreReservations;   
    
    /**
     * Constructeur pour créer un client Entreprise.
     * Initialise automatiquement la stratégie de prix Entreprise (20% de réduction).
     * 
     * @param nom 
     * @param prenom 
     * @param telephone 
     * @param email 
     * @param nomEntreprise 
     * @param numeroSIRET 
     * @param adresseFacturation 
     */
    public ClientEntreprise(String nom, String prenom, String telephone, String email,
                            String nomEntreprise, String numeroSIRET, String adresseFacturation) {
        super(nom, prenom, telephone, email);
        // Initialisation de la stratégie de prix Entreprise
        this.strategyPrix = new PrixEntreprise();
        
        setNomEntreprise(nomEntreprise);
        setNumeroSIRET(numeroSIRET);
        setAdresseFacturation(adresseFacturation);
        this.nombreReservations = 0;
    }
    
    /**
     * Retourne le type de ce client.
     * 
     * @return "Entreprise"
     */
    @Override
    public String getTypeClient() {
        return "Entreprise";
    }
    
    // --- GETTERS ---
    
    public String getNomEntreprise() {
        return nomEntreprise;
    }
    
    public String getNumeroSIRET() {
        return numeroSIRET;
    }
    
    public String getAdresseFacturation() {
        return adresseFacturation;
    }
    
    public int getNombreReservations() {
        return nombreReservations;
    }
    
    // --- SETTERS avec validation ---
    
    public void setNomEntreprise(String nomEntreprise) {
        if (nomEntreprise == null || nomEntreprise.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'entreprise ne peut pas être vide");
        }
        this.nomEntreprise = nomEntreprise.trim();
    }
    
    public void setNumeroSIRET(String numeroSIRET) {
        if (numeroSIRET == null || numeroSIRET.trim().isEmpty()) {
            throw new IllegalArgumentException("Le numéro SIRET ne peut pas être vide");
        }
        this.numeroSIRET = numeroSIRET.trim();
    }
    
    public void setAdresseFacturation(String adresseFacturation) {
        if (adresseFacturation == null || adresseFacturation.trim().isEmpty()) {
            throw new IllegalArgumentException("L'adresse de facturation ne peut pas être vide");
        }
        this.adresseFacturation = adresseFacturation.trim();
    }
    
    // --- MÉTHODES SPÉCIFIQUES ---
    
    /**
     * Incrémente le nombre de réservations effectuées par l'entreprise.
     */
    public void incrementerReservations() {
        this.nombreReservations++;
    }
    
    /**
     * Décrémente le nombre de réservations (en cas d'annulation).
     */
    public void decrementerReservations() {
        if (this.nombreReservations > 0) {
            this.nombreReservations--;
        }
    }
    
    /**
     * Calcule une réduction supplémentaire si l'entreprise a fait
     * plus de 10 réservations (5% de réduction additionnelle).
     * 
     * @param prixBase Le prix de base en DA
     * @return Le prix en DA avec réduction supplémentaire si applicable
     */
    public double calculerPrixAvecFidelite(double prixBase) {
        double prixFinal = calculerPrixFinal(prixBase);
        
        // Réduction supplémentaire de 5% après 10 réservations
        if (nombreReservations >= 10) {
            prixFinal *= 0.95; // 5% de réduction additionnelle
        }
        
        return prixFinal;
    }
    
    /**
     * Affiche les informations spécifiques d'un client Entreprise.
     * 
     * @return Les informations du client avec détails de l'entreprise
     */
    @Override
    public String afficherInfos() {
        return super.afficherInfos() + 
                String.format(" | Entreprise: %s | SIRET: %s | Réservations: %d | Réduction: 20%%",
                            nomEntreprise, numeroSIRET, nombreReservations);
    }
    
    /**
     * Retourne un résumé de la facturation pour l'entreprise.
     * 
     * @return Les informations de facturation formatées
     */
    public String obtenirInfosFacturation() {
        return String.format("""
            FACTURATION
            Entreprise: %s
            SIRET: %s
            Contact: %s
            Email: %s
            Tél: %s
            Adresse: %s
            Nombre de réservations: %d
            Réduction appliquée: 20%%""",
            nomEntreprise, numeroSIRET, getNomComplet(), 
            getEmail(), getTelephone(), adresseFacturation, nombreReservations
        );
    }
}