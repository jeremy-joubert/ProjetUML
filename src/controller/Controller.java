package controller;

import DAO.ProduitDAO;
import entity.I_Catalogue;
import entity.I_Produit;
import factory.ProduitDAOFactory;

import java.util.List;

public class Controller {
    private I_Catalogue catalogue;
    private EditerProduitController editerProduitController;
    private NewAchatVenteController newAchatVenteController;
    private InfoEtatStocksController infoEtatStocksController;

    public Controller(I_Catalogue catalogue){
        this.catalogue=catalogue;
        remplirLeCatalogueAvecLesProduitsDeLaBDD(this.catalogue);
        editerProduitController=new EditerProduitController(this.catalogue);
        newAchatVenteController=new NewAchatVenteController(this.catalogue);
        infoEtatStocksController=new InfoEtatStocksController(this.catalogue);
    }

    public EditerProduitController getEditerProduitController(){
        return editerProduitController;
    }

    public NewAchatVenteController getNewAchatVenteController() {
        return newAchatVenteController;
    }

    public InfoEtatStocksController getInfoEtatStocksController() {
        return infoEtatStocksController;
    }

    public String[] getNomProduits(){
        return catalogue.getNomProduits();
    }

    private void remplirLeCatalogueAvecLesProduitsDeLaBDD(I_Catalogue catalogue){
        ProduitDAO produitDAO= ProduitDAOFactory.getInstance();
        List<I_Produit> produits=produitDAO.read(catalogue.getNom());
        for (I_Produit produit : produits){
            catalogue.addProduit(produit);
        }
    }
}
