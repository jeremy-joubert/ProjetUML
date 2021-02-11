package controller;

import entity.Catalogue;

public class Controller {
    private Catalogue catalogue;
    private EditerProduitController editerProduitController;
    private NewAchatVenteController newAchatVenteController;
    private InfoEtatStocksController infoEtatStocksController;

    public Controller(){
        catalogue=new Catalogue();
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
}
