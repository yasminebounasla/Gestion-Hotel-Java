package model.clients.strategy;

/**
 * Stratégie de prix pour les clients VIP.
 * Réduction de 15% sur le prix de base.
 */
public class PrixVIP implements StrategyPrix {
    
    private static final double TAUX_REDUCTION = 0.15; 
    
    /**
     * Calcule le prix pour un client VIP.
     * Prix final = Prix de base - 15%
     * 
     * @param prixBase Le prix de base de la réservation en DA
     * @return Le prix final en DA après réduction de 15%
     * @throws IllegalArgumentException si le prix de base est négatif
     */
    @Override
    public double calculerPrix(double prixBase) {
        if (prixBase < 0) {
            throw new IllegalArgumentException("Le prix de base ne peut pas être négatif");
        }
        
        // Applique la réduction de 15%
        return prixBase * (1 - TAUX_REDUCTION);
    }
    
    /**
     * Retourne le taux de réduction (15% pour un client VIP).
     * 
     * @return 0.15 
     */
    @Override
    public double getTauxReduction() {
        return TAUX_REDUCTION;
    }
    
    /**
     * Retourne le nom de la stratégie.
     * 
     * @return "Tarif VIP"
     */
    @Override
    public String getNomStrategie() {
        return "Tarif VIP";
    }
    
    @Override
    public String toString() {
        return getNomStrategie() + " (réduction: " + (TAUX_REDUCTION * 100) + "%)";
    }
}