package model.Clients.Strategy;

/**
 * Stratégie de prix pour les clients réguliers.
 * Aucune réduction n'est appliquée .
 */
public class PrixRegulier implements StrategyPrix {
    
    private static final double TAUX_REDUCTION = 0.0; 
    
    /**
     * Calcule le prix pour un client régulier.
     * Prix final = Prix de base (sans réduction)
     * 
     * @param prixBase Le prix de base de la réservation en DA
     * @return Le prix final en DA (identique au prix de base)
     * @throws IllegalArgumentException si le prix de base est négatif
     */
    @Override
    public double calculerPrix(double prixBase) {
        if (prixBase < 0) {
            throw new IllegalArgumentException("Le prix de base ne peut pas être négatif");
        }
        return prixBase;
    }
    
    /**
     * Retourne le taux de réduction
     * 
     * @return 0.0 
     */
    @Override
    public double getTauxReduction() {
        return TAUX_REDUCTION;
    }
    
    /**
     * Retourne le nom de la stratégie.
     * 
     * @return "Tarif Régulier"
     */
    @Override
    public String getNomStrategie() {
        return "Tarif Régulier";
    }
    
    @Override
    public String toString() {
        return getNomStrategie() + " (réduction: " + (TAUX_REDUCTION * 100) + "%)";
    }
}