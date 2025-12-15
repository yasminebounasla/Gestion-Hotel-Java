package controller;

import java.util.ArrayList;

import model.Chambres.*;
import model.Chambres.Composite.Chambre;

public class ControleurChambre {
    private GestionnaireChambres gestionnaireCh;

    public ControleurChambre(GestionnaireChambres gestionnaireCh) {
        this.gestionnaireCh = gestionnaireCh;
    }

    public void ajouterChambre(Chambre chambre) {
        this.gestionnaireCh.ajouterChambre(chambre);
    }
    
    public ArrayList<Chambre> getChambres() {
        return gestionnaireCh.getChambres();
    }

    public int getNombreChambres() {
        return this.gestionnaireCh.getNombreChambres();
    }   

    public ArrayList<Chambre> getChambresDisponibles() {
        return gestionnaireCh.getChambresDisponibles();
    }

    public Chambre getChambreParNumero(int numero) {
        return gestionnaireCh.getChambreParNumero(numero);
    }

    public boolean updateChambre(Chambre oldC, Chambre newC) {
        return gestionnaireCh.updateChambre(oldC, newC);
    }

    public String getStatut(Chambre chambre) {
        return gestionnaireCh.getStatut(chambre);
    }

    public boolean supprimerChambre(Chambre chambre) {
        return gestionnaireCh.supprimerChambre(chambre);
    }
}
