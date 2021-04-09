package controller;

import entity.I_Catalogue;

public class InfoEtatStocksController {

    private I_Catalogue catalogue;

    public InfoEtatStocksController(I_Catalogue catalogue){
        this.catalogue=catalogue;
    }

    @Override
    public String toString() {
        return catalogue.toString();
    }
}
