package controller;

import DAO.ProduitDAO;
import entity.I_Catalogue;
import factory.ProduitDAOFactory;

public class NewAchatVenteController {


    private I_Catalogue catalogue;
    private ProduitDAO produitDAO;

    public NewAchatVenteController(I_Catalogue catalogue){
        this.catalogue=catalogue;
        produitDAO= ProduitDAOFactory.getInstance();
    }

    public boolean newAchat(String nomProduit, int qte){
        produitDAO.update(nomProduit, qte, catalogue.getNom());
        return catalogue.acheterStock(nomProduit, qte);
    }

    public Boolean newVente(String nomProduit, int qte){
        produitDAO.update(nomProduit, -qte, catalogue.getNom());
        return catalogue.vendreStock(nomProduit, qte);
    }
}
