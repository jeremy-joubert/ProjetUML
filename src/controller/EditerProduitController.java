package controller;

import DAO.ProduitDAO;
import entity.Catalogue;
import factory.ProduitDAOFactory;

public class EditerProduitController{
    private Catalogue catalogue;

    public EditerProduitController(Catalogue catalogue){
        this.catalogue=catalogue;
    }

    public void nouveauProduit(String nomProduit, double prix, int qte){
        catalogue.addProduit(nomProduit, prix, qte);
        ProduitDAO dao=ProduitDAOFactory.getInstance();
        dao.create(nomProduit, prix, qte);
    }

    public void suppressionProduit(String nomProduit){
        catalogue.removeProduit(nomProduit);
        ProduitDAO dao=ProduitDAOFactory.getInstance();
        dao.delete(nomProduit);
    }
}
