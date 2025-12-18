package controller;

import java.util.ArrayList;

import model.Chambres.*;
import model.Chambres.Composite.Chambre;

/**
 * Classe contrôleur pour les chambres.
 * 
 * Cette classe sert d'intermédiaire entre la vue et le gestionnaire de chambres.
 * Elle permet d'effectuer toutes les opérations sur les chambres (ajout, 
 * modification, suppression, consultation) en utilisant les méthodes de 
 * GestionnaireChambres.
 */

public class ControleurChambre {
    private GestionnaireChambres gestionnaireCh; // Référence au gestionnaire de chambres

    public ControleurChambre(GestionnaireChambres gestionnaireCh) {
        this.gestionnaireCh = gestionnaireCh;
    }

    // ajouter une chambre
    public void ajouterChambre(Chambre chambre) {
        this.gestionnaireCh.ajouterChambre(chambre); // Déléguer l'ajout au gestionnaire
    }
    
    // obtenir la liste des chambres
    public ArrayList<Chambre> getChambres() {
        return gestionnaireCh.getChambres(); // Déléguer la récupération au gestionnaire
    }

    // obtenir le nombre total des chambres
    public int getNombreChambres() {
        return this.gestionnaireCh.getNombreChambres(); // Déléguer la récupération au gestionnaire
    }   

    // obtenir la liste des chambres disponibles
    public ArrayList<Chambre> getChambresDisponibles() {
        return gestionnaireCh.getChambresDisponibles(); // Déléguer la récupération au gestionnaire
    }

    // obtenir une chambre par son numéro
    public Chambre getChambreParNumero(int numero) {
        return gestionnaireCh.getChambreParNumero(numero); // Déléguer la récupération au gestionnaire
    }

    // modifier une chambre
    public boolean modifierChambre(Chambre oldC, Chambre newC) {
        return gestionnaireCh.updateChambre(oldC, newC); // Déléguer la modification au gestionnaire
    }

    // obtenir le statut d'une chambre
    public String getStatut(Chambre chambre) {
        return gestionnaireCh.getStatut(chambre); // Déléguer la récupération au gestionnaire
    }

    // supprimer une chambre
    public boolean supprimerChambre(Chambre chambre) {
        return gestionnaireCh.supprimerChambre(chambre); // Déléguer la suppression au gestionnaire
    }
}
