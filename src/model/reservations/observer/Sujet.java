package model.Reservations.Observer;
/**
 * Interface Sujet (pattern Observer).
 * 
 * Cette interface représente le "Sujet" observé.
 * Un sujet est un objet qui contient un état et qui
 * doit notifier automatiquement les observateurs
 * lorsqu’un changement se produit.
 * 
 * Dans notre projet, le sujet est lié à la gestion
 * des réservations (ajout, modification, suppression, ajout de service).
 */
public interface Sujet {
    void ajouterObservateur(Observateur obs);
    void supprimerObservateur(Observateur obs);
    void notifierObservateurs();
}
