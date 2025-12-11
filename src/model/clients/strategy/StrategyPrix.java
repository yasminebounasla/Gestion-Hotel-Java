package model.clients.strategy;

/**
 * Interface Strategy pour le calcul du prix selon le type de client.
 * Patron de conception : Strategy
 * 
 * Permet de définir différentes stratégies de tarification
 */
public interface StrategyPrix {
    
    /**
     * Calcule le prix final après application de la réduction.
     * 
     * @param prixBase Le prix de base de la réservation en DA
     * @return Le prix final après réduction en DA
     */
    double calculerPrix(double prixBase);
    
    /**
     * Retourne le pourcentage de réduction appliqué.
     * 
     * @return Le taux de réduction (ex: 0.15 pour 15%)
     */
    double getTauxReduction();
    
    /**
     * Retourne le nom de la stratégie de prix.
     * 
     * @return Le nom de la stratégie (ex: "Tarif Régulier")
     */
    String getNomStrategie();
}