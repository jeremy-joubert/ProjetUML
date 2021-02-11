package controller;

import entity.Catalogue;

public class EditerProduitController{
    private Catalogue catalogue;

    public EditerProduitController(Catalogue catalogue){
        this.catalogue=catalogue;
    }

    public void nouveauProduit(String nomProduit, double prix, int qte){
        catalogue.addProduit(nomProduit, prix, qte);
    }

    public void suppressionProduit(String nomProduit){
        catalogue.removeProduit(nomProduit);
    }
}
