package model.clients;

import model.clients.strategy.StrategyPrix;

/**
 * Classe abstraite représentant un client de l'hôtel.
 * Utilise le patron Strategy pour le calcul des prix.
 * 
 * Cette classe définit les attributs et comportements communs
 * à tous les types de clients (Régulier, VIP, Entreprise).
 */
public abstract class Client {
    
    // Compteur statique pour générer des ID uniques
    private static int compteurID = 1;
    
    // Attributs
    private int id;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    protected StrategyPrix strategyPrix; // Stratégie de tarification
    
    /**
     * Constructeur de la classe Client.
     * 
     * @param nom 
     * @param prenom 
     * @param telephone 
     * @param email 
     */
    public Client(String nom, String prenom, String telephone, String email) {
        this.id = compteurID++;
        setNom(nom);
        setPrenom(prenom);
        setTelephone(telephone);
        setEmail(email);
    }
    
    // --- GETTERS ---
    
    public int getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public StrategyPrix getStrategyPrix() {
        return strategyPrix;
    }
    
    public String getNomComplet() {
        return prenom + " " + nom;
    }
    
    // --- SETTERS avec validation ---
    
    public void setNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide");
        }
        this.nom = nom.trim();
    }
    
    public void setPrenom(String prenom) {
        if (prenom == null || prenom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le prénom ne peut pas être vide");
        }
        this.prenom = prenom.trim();
    }
    
    public void setTelephone(String telephone) {
        if (telephone == null || telephone.trim().isEmpty()) {
            throw new IllegalArgumentException("Le téléphone ne peut pas être vide");
        }
        this.telephone = telephone.trim();
    }
    
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("L'email ne peut pas être vide");
        }
        // Validation simple de l'email (contient @)
        if (!email.contains("@")) {
            throw new IllegalArgumentException("L'email doit contenir le caractère @");
        }
        this.email = email.trim().toLowerCase();
    }
    
    public void setStrategyPrix(StrategyPrix strategyPrix) {
        if (strategyPrix == null) {
            throw new IllegalArgumentException("La stratégie de prix ne peut pas être null");
        }
        this.strategyPrix = strategyPrix;
    }
    
    // --- MÉTHODES ---
    
    /**
     * Calcule le prix final d'une réservation selon la stratégie du client.
     * 
     * @param prixBase Le prix de base de la réservation en DA
     * @return Le prix final en DA après application de la réduction
     */
    public double calculerPrixFinal(double prixBase) {
        if (strategyPrix == null) {
            throw new IllegalStateException("Aucune stratégie de prix définie pour ce client");
        }
        return strategyPrix.calculerPrix(prixBase);
    }
    
    /**
     * Méthode abstraite pour obtenir le type de client.
     * Chaque sous-classe doit implémenter cette méthode.
     * @return Le type de client (ex: "Régulier", "VIP", "Entreprise")
     */
    public abstract String getTypeClient();
    
    /**
     * Affiche les informations du client.
     * @return Une chaine contenant toutes les informations du client
     */
    public String afficherInfos() {
        return String.format(
            "ID: %d | Type: %s | Nom: %s | Tél: %s | Email: %s | Tarif: %s",
            id,
            getTypeClient(),
            getNomComplet(),
            telephone,
            email,
            strategyPrix != null ? strategyPrix.getNomStrategie() : "Non défini"
        );
    }
    
    @Override
    public String toString() {
        return afficherInfos();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return id == client.id;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}