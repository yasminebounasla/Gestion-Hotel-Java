package model.Chambres;

import model.Chambres.Composite.Chambre;
import java.util.ArrayList;

/**
 * Classe représentant le gestionnaire des chambres de l'hôtel.
 * 
 * Cette classe permet de gérer la liste des chambres, avec des méthodes 
 * pour ajouter, supprimer, mettre à jour et rechercher des chambres.
 * Elle fournit également des méthodes pour obtenir le nombre total de chambres
 * et la liste des chambres disponibles.
 */

public class GestionnaireChambres {
    private ArrayList<Chambre> chambres; //liste des chambres de l'hôtel

    public GestionnaireChambres() {
        this.chambres = new ArrayList<>(); // Initialisation de la liste des chambres
    }

    // Ajoute une chambre
    public void ajouterChambre(Chambre chambre) {
        this.chambres.add(chambre);
    }
    
    // Retourne la liste complète des chambres
    public ArrayList<Chambre> getChambres() {
        return chambres;
    }

    // Retourne le nombre total de chambres
    public int getNombreChambres() {
        return this.chambres.size();
    }   

    // Retourne la liste des chambres disponibles
    public ArrayList<Chambre> getChambresDisponibles() {
        ArrayList<Chambre> disponibles = new ArrayList<>();
        for (Chambre chambre : chambres) {
            if (chambre.getStatut().toString().equals("LIBRE")) { // vérifier si la chambre est libre
                disponibles.add(chambre); // ajouter à la liste des chambres disponibles
            }
        }
        return disponibles;
    }

    // Recherche une chambre par son numéro
    public Chambre getChambreParNumero(int numero) {
        for (Chambre chambre : chambres) {
            if (chambre.getNumero() == numero) {  // trouver la chambre par son numéro
                return chambre;
            }
        }
        return null;
    }


    // Met à jour une chambre
    public boolean updateChambre(Chambre oldC, Chambre newC) {
        for (int i = 0; i < chambres.size(); i++) {  // parcourer la liste des chambres
            if (chambres.get(i).getNumero() == oldC.getNumero()) { // trouver la chambre à mettre à jour par son numéro
                chambres.set(i, newC); // mettre à jour la chambre
                return true;
            }
        }
        return false;
    }

    // Obtient le statut d'une chambre
    public String getStatut(Chambre chambre) {
        return chambre.getStatut().toString();
    }

    // Supprime une chambre
    public boolean supprimerChambre(Chambre chambre) {
        return chambres.remove(chambre);
    }
}
