package model.Reservations.Observer;
/**
 * Interface Observateur (pattern Observer).
 * 
 * Cette interface représente un observateur qui
 * surveille un sujet.
 * 
 * Un observateur est automatiquement informé
 * lorsque l’état du sujet change.
 * 
 * Dans notre projet, les observateurs servent
 * à mettre à jour les vues (ex : affichage,
 * statistiques) après toute modification
 * des réservations.
 */
public interface Observateur {
    void mettreAJour(Sujet sujet);
}
