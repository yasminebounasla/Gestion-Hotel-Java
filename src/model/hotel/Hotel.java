package model.Hotel;

import java.util.ArrayList;
import model.Chambres.Composite.Chambre;

public class Hotel {
    private static Hotel instance ;
    private String nomHotel ;
    private ArrayList<Chambre> chambres ;

    private Hotel(String nomHotel) {
        this.nomHotel = nomHotel;
        this.chambres = new ArrayList<>();
    }

    public static synchronized Hotel getInstance(String nomHotel) {
        if (instance == null) {
            instance = new Hotel(nomHotel);
        }
        return instance;
    }

    // Getters
    public String getNomHotel() {
        return nomHotel;
    }

    public ArrayList<Chambre> getChambres() {
        return chambres;
    }


    // Setters
    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;   
    }

}