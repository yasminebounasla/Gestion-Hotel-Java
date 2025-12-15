package controller;

import java.util.ArrayList;

import model.Chambres.*;
import model.Chambres.Composite.Chambre;

public class ControleurChambre {
    private GestionnaireChambres gestionnaire;

    public ControleurChambre(GestionnaireChambres gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    public void ajouterChambre(Chambre chambre) {
        this.gestionnaire.ajouterChambre(chambre);
    }
    
    public ArrayList<Chambre> getChambres() {
        return gestionnaire.getChambres();
    }

    public int getNombreChambres() {
        return this.gestionnaire.getNombreChambres();
    }   

    public ArrayList<Chambre> getChambresDisponibles() {
        return gestionnaire.getChambresDisponibles();
    }

    public Chambre getChambreParNumero(int numero) {
        return gestionnaire.getChambreParNumero(numero);
    }

    public boolean updateChambre(Chambre oldC, Chambre newC) {
        return gestionnaire.updateChambre(oldC, newC);
    }

    public String getStatut(Chambre chambre) {
        return gestionnaire.getStatut(chambre);
    }

    public boolean supprimerChambre(Chambre chambre) {
        return gestionnaire.supprimerChambre(chambre);
    }
}
