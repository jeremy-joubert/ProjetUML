package controller;

import DAO.ProduitDAO;
import entity.Catalogue;
import factory.ProduitDAOFactory;

public class NewAchatVenteController {


    private Catalogue catalogue;
    private ProduitDAO produitDAO;

    public NewAchatVenteController(Catalogue catalogue){
        this.catalogue=catalogue;
        produitDAO= ProduitDAOFactory.getInstance();
    }

    public boolean newAchat(String nomProduit, int qte){
        produitDAO.update(nomProduit, qte);
        return catalogue.acheterStock(nomProduit, qte);
    }

    public Boolean newVente(String nomProduit, int qte){
        produitDAO.update(nomProduit, -qte);
        return catalogue.vendreStock(nomProduit, qte);
    }
}
