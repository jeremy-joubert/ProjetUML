package controller;

import DAO.ProduitDAO;
import entity.Catalogue;
import entity.I_Produit;
import factory.ProduitDAOFactory;

import java.util.List;

public class Controller {
    private Catalogue catalogue;
    private EditerProduitController editerProduitController;
    private NewAchatVenteController newAchatVenteController;
    private InfoEtatStocksController infoEtatStocksController;

    public Controller(){
        catalogue=new Catalogue("");
        remplirLeCatalogueAvecLesProduitsDeLaBDD(catalogue);
        editerProduitController=new EditerProduitController(catalogue);
        newAchatVenteController=new NewAchatVenteController(catalogue);
        infoEtatStocksController=new InfoEtatStocksController(catalogue);
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

    private void remplirLeCatalogueAvecLesProduitsDeLaBDD(Catalogue catalogue){
        ProduitDAO produitDAO= ProduitDAOFactory.getInstance();
        List<I_Produit> produits=produitDAO.read();
        for (I_Produit produit : produits){
            catalogue.addProduit(produit);
        }
    }
}
