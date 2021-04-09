package controller;

import DAO.ProduitDAO;
import entity.I_Catalogue;
import factory.ProduitDAOFactory;

public class EditerProduitController{
    private I_Catalogue catalogue;

    public EditerProduitController(I_Catalogue catalogue){
        this.catalogue=catalogue;
    }

    public void nouveauProduit(String nomProduit, double prix, int qte){
        catalogue.addProduit(nomProduit, prix, qte);
        ProduitDAO dao=ProduitDAOFactory.getInstance();
        dao.create(nomProduit, prix, qte, catalogue.getNom());
    }

    public void suppressionProduit(String nomProduit){
        catalogue.removeProduit(nomProduit);
        ProduitDAO dao=ProduitDAOFactory.getInstance();
        dao.delete(nomProduit, catalogue.getNom());
    }
}
