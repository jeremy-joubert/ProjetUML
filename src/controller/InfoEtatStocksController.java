package controller;

import entity.Catalogue;

public class InfoEtatStocksController {

    private Catalogue catalogue;

    public InfoEtatStocksController(Catalogue catalogue){
        this.catalogue=catalogue;
    }

    @Override
    public String toString() {
        return catalogue.toString();
    }
}
