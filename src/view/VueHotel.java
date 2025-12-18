package view;

import java.util.Scanner;
import model.Hotel.Hotel;

public class VueHotel {
    private Scanner scanner;

    public VueHotel() {
        this.scanner = new Scanner(System.in);
    }

    public Hotel creerHotelSiNonExistant() {
        if (Hotel.getInstance() != null) {
            return Hotel.getInstance();
        }

        System.out.print("Entrez le nom de l'hôtel: ");
        String nomHotel = scanner.nextLine().trim();

        Hotel hotel = Hotel.getInstance(nomHotel);
        System.out.println("Hôtel '" + hotel.getNomHotel() + "' créé avec succès !");
        return hotel;
    }

}
