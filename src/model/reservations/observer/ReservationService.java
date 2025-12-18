package model.Reservations.Observer;

import java.util.ArrayList;
import java.util.List;
/**
 * Classe représentant le sujet observable pour les réservations.
 * Permet de notifier tous les observateurs lors d'un changement.
 */
public class ReservationService implements Sujet {

    private List<Observateur> observateurs;

    public ReservationService() {
        this.observateurs = new ArrayList<>();
    }
    
    @Override
    public void ajouterObservateur(Observateur obs) {
        // Ajoute un observateur à la liste
        // On vérifie d'abord qu'il n'existe pas déjà
        // pour éviter les doublons
        if (!observateurs.contains(obs)) {
            observateurs.add(obs);
        }
    }
    
    @Override
    public void supprimerObservateur(Observateur obs) {
        // Supprime un observateur de la liste
       // Cet observateur ne recevra plus de notifications
        observateurs.remove(obs);
    }

    @Override
    public void notifierObservateurs() {
        for (Observateur obs : observateurs) {
                 // Notifie tous les observateurs enregistrés
                // Chaque observateur est informé qu'un changement
            obs.mettreAJour(this);
        }
    } 
    
}
