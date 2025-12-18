import controller.ControleurPrincipal;
import view.VueMenuPrincipal;
import view.VueHotel;

public class App {
    public static void main(String[] args) {
        ControleurPrincipal controleur = new ControleurPrincipal();

        // Créer l'hôtel au démarrage (une seule fois)
        VueHotel vueHotel = new VueHotel();
        vueHotel.creerHotelSiNonExistant();

        // Lancer le menu principal (tout le reste est géré depuis VueMenuPrincipal)
        VueMenuPrincipal menuPrincipal = new VueMenuPrincipal(controleur);
        menuPrincipal.afficherMenu();
    }
}
