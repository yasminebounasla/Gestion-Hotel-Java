package model.Hotel;

import java.util.ArrayList;
import model.Chambres.Composite.Chambre;
import model.Clients.Client;
import model.Reservations.Reservation;

public class Hotel {
    private static Hotel instance ;
    private String nomHotel ;
    private ArrayList<Chambre> chambres ;
    private ArrayList<Client> clients;
    private ArrayList<Reservation> reservations;

    private Hotel(String nomHotel) {
        this.nomHotel = nomHotel;
        this.chambres = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.reservations = new ArrayList<>();
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

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    // Setters
    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;   
    }

}


