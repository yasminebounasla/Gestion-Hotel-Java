package model.Hotel;

/**
 * Classe représentant un hôtel.
 * 
 * Cette classe applique le pattern Singleton pour s'assurer qu'une seule 
 * instance d'hôtel existe dans l'application. 
 * Elle permet de créer l'instance unique avec un nom et de récupérer ou 
 * modifier ce nom via les getters et setters.
 */


public class Hotel {

    private static Hotel instance;
    private String nomHotel;

    private Hotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    // création de l'instance unique
    public static synchronized Hotel getInstance(String nomHotel) { // synchronized pour la sécurité en cas de multi-thread
        if (instance == null) {
            instance = new Hotel(nomHotel);
        }
        return instance;
    }

    // consultation uniquement de l'instance
    public static Hotel getInstance() {
        return instance;
    }

    // getters et setters pour le nom de l'hôtel
    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }
}
