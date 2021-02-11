package controller;

import entity.Produit;

public class NewAchatVenteController {


    private Produit produit;
    private int qtt;

    public NewAchatVenteController(Produit produit, int qtt){
        this.produit=produit;
        this.qtt=qtt;
    }

    public String newAchat(){
        if(produit.ajouter(qtt))
            return "Achat effectué";
        else
            return "Echec d'achat";
    }

    public String newVente(){
        if(produit.enlever(qtt))
            return "Vente effectuée";
        else
            return "Echec de vente";
    }
}
