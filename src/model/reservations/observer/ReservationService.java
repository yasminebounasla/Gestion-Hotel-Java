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
        if (!observateurs.contains(obs)) {
            observateurs.add(obs);
        }
    }

    @Override
    public void supprimerObservateur(Observateur obs) {
        observateurs.remove(obs);
    }

    @Override
    public void notifierObservateurs() {
        for (Observateur obs : observateurs) {
            obs.mettreAJour(this);
        }
    } 
    
}
