package controller;

import entity.I_Catalogue;

public class NewAchatVenteController {


    private I_Catalogue catalogue;

    public NewAchatVenteController(I_Catalogue catalogue){
        this.catalogue=catalogue;
    }

    public boolean newAchat(String nomProduit, int qte){
        return catalogue.acheterStock(nomProduit, qte);
    }

    public Boolean newVente(String nomProduit, int qte){
        return catalogue.vendreStock(nomProduit, qte);
    }
}
