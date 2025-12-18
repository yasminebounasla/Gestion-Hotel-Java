package model.Hotel;

public class Hotel {
    private static Hotel instance;
    private String nomHotel;

    private Hotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    // création
    public static synchronized Hotel getInstance(String nomHotel) {
        if (instance == null) {
            instance = new Hotel(nomHotel);
        }
        return instance;
    }

    // consultation uniquement
    public static Hotel getInstance() {
        return instance;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }
}
