package model.Reservations.Observer;

public interface Sujet {
    void ajouterObservateur(Observateur obs);
    void supprimerObservateur(Observateur obs);
    void notifierObservateurs();
}
