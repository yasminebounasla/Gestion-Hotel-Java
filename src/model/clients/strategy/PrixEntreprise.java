package model.Clients.Strategy;

/**
 * Stratégie de prix pour les clients Entreprise.
 * Réduction de 20% sur le prix de base + avantages supplémentaires.
 */
public class PrixEntreprise implements StrategyPrix {
    
    private static final double TAUX_REDUCTION = 0.20; 
    
    /**
     * Calcule le prix pour un client Entreprise.
     * Prix final = Prix de base - 20%
     * 
     * @param prixBase Le prix de base de la réservation en DA
     * @return Le prix final en DA après réduction de 20%
     * @throws IllegalArgumentException si le prix de base est négatif
     */
    @Override
    public double calculerPrix(double prixBase) {
        if (prixBase < 0) {
            throw new IllegalArgumentException("Le prix de base ne peut pas être négatif");
        }
        
        // Applique la réduction de 20%
        return prixBase * (1 - TAUX_REDUCTION);
    }
    
    /**
     * Retourne le taux de réduction .
     * 
     * @return 0.20 .
     */
    @Override
    public double getTauxReduction() {
        return TAUX_REDUCTION;
    }
    
    /**
     * Retourne le nom de la stratégie.
     * 
     * @return "Tarif Entreprise"
     */
    @Override
    public String getNomStrategie() {
        return "Tarif Entreprise";
    }
    
    @Override
    public String toString() {
        return getNomStrategie() + " (réduction: " + (TAUX_REDUCTION * 100) + "%)";
    }
}