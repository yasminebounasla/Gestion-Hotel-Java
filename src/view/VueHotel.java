package view;

import java.util.Scanner;
import model.Hotel.Hotel;

/**
 * Classe représentant la vue pour gérer l'hôtel.
 * 
 * Elle permet de créer l'instance unique de l'hôtel si elle n'existe pas encore,
 * en demandant à l'utilisateur de saisir le nom de l'hôtel.
 * 
 */

public class VueHotel {
    private Scanner scanner; // Scanner pour la saisie utilisateur

    public VueHotel() {
        this.scanner = new Scanner(System.in);
    }

    // créer l'hôtel si non existant
    public Hotel creerHotelSiNonExistant() {
        if (Hotel.getInstance() != null) { // vérifier si l'instance existe déjà
            return Hotel.getInstance();
        }

        System.out.print("Entrez le nom de l'hôtel: ");
        String nomHotel = scanner.nextLine().trim();

        Hotel hotel = Hotel.getInstance(nomHotel); // créer l'instance unique de l'hôtel
        System.out.println("Hôtel '" + hotel.getNomHotel() + "' créé avec succès !");
        return hotel;
    }

}
