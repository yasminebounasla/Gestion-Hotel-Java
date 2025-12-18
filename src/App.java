import controller.ControleurPrincipal;
import view.VueMenuPrincipal;
import view.VueHotel;

/**
 * Classe principale de l'application Gestion Hôtel.
 * 
 * Cette classe lance la vue de l'hôtel pour créer l'hôtel au démarrage,
 * puis démarre la vue du menu principal permettant de naviguer dans 
 * les différentes fonctionnalités (gestion des chambres, clients et réservations).
 */


public class App {
    public static void main(String[] args) {
        ControleurPrincipal controleur = new ControleurPrincipal(); // Initialiser le contrôleur principal

        // Créer l'hôtel au démarrage (une seule fois)
        VueHotel vueHotel = new VueHotel();
        vueHotel.creerHotelSiNonExistant();

        // Lancer le menu principal (tout le reste est géré depuis VueMenuPrincipal)
        VueMenuPrincipal menuPrincipal = new VueMenuPrincipal(controleur);
        menuPrincipal.afficherMenu();
    }
}
