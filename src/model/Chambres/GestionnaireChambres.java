package model.Chambres;

import model.Chambres.Composite.Chambre;
import java.util.ArrayList;

public class GestionnaireChambres {
    private ArrayList<Chambre> chambres;

    public GestionnaireChambres() {
        this.chambres = new ArrayList<>();
    }

    public void ajouterChambre(Chambre chambre) {
        this.chambres.add(chambre);
    }
    
    public ArrayList<Chambre> getChambres() {
        return chambres;
    }

    public int getNombreChambres() {
        return this.chambres.size();
    }   

    public ArrayList<Chambre> getChambresDisponibles() {
        ArrayList<Chambre> disponibles = new ArrayList<>();
        for (Chambre chambre : chambres) {
            if (chambre.isDisponible()) {
                disponibles.add(chambre);
            }
        }
        return disponibles;
    }

    public Chambre getChambreParNumero(int numero) {
        for (Chambre chambre : chambres) {
            if (chambre.getNumero() == numero) {
                return chambre;
            }
        }
        return null;
    }

    public boolean updateChambre(Chambre oldC, Chambre newC) {
        int index = chambres.indexOf(oldC); 
        if (index != -1) {
            chambres.set(index, newC); 
            return true;
        }
        return false;
    }

    public String getStatut(Chambre chambre) {
        return chambre.isDisponible() ? "Libre" : "Réservée";
    }

    public boolean supprimerChambre(Chambre chambre) {
        return chambres.remove(chambre);
    }
}
