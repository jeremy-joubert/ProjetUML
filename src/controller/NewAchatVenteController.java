package controller;

import entity.Catalogue;

public class NewAchatVenteController {


    private Catalogue catalogue;

    public NewAchatVenteController(Catalogue catalogue){
        this.catalogue=catalogue;
    }

    public boolean newAchat(String nomProduit, int qte){
        return catalogue.acheterStock(nomProduit, qte);
    }

    public Boolean newVente(String nomProduit, int qte){
        return catalogue.vendreStock(nomProduit, qte);
    }
}
