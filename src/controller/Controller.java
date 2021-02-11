package controller;

import entity.Catalogue;

public class Controller {
    private Catalogue catalogue;
    private EditerProduitController editerProduitController;

    public Controller(){
        catalogue=new Catalogue();
        editerProduitController=new EditerProduitController(catalogue);
    }

    public EditerProduitController getEditerProduitController(){
        return editerProduitController;
    }

    public String[] getNomProduits(){
        return catalogue.getNomProduits();
    }
}
