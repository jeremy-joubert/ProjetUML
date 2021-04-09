package controller;

import DAO.CatalogueDAO;
import DAO.ProduitDAO;
import entity.I_Catalogue;
import entity.I_Produit;
import factory.CatalogueDAOFactory;
import factory.CatalogueFactory;
import factory.ProduitDAOFactory;

import java.util.List;

public class CatalogueController {

    private CatalogueDAO catalogueDAO;
    private ProduitDAO produitDAO;
    public CatalogueController(){
        catalogueDAO=CatalogueDAOFactory.getInstance();
        produitDAO= ProduitDAOFactory.getInstance();
    }

    public void creerCatalogue(String nomCatalogue){
        catalogueDAO.create(nomCatalogue);

    }

    public void supprimerCatalogue(String nomCatalogue){
        catalogueDAO.delete(nomCatalogue);
    }

    public I_Catalogue choisirCatalogue(String nomCatalogue){
        I_Catalogue catalogue = CatalogueFactory.creerCatalogue(nomCatalogue);
        return catalogue;
    }

    public String[] afficherCatalogue(){
        List<I_Catalogue> catalogues=catalogueDAO.read();
        String [] noms=new String[catalogues.size()];
        int i=0;
        for (I_Catalogue catalogue : catalogues){
            noms[i]=catalogue.getNom();
            i++;
        }
        return noms;
    }

    public String[] afficherDetailCatalogue(){
        List<I_Catalogue> catalogues=catalogueDAO.read();
        String [] details=new String[catalogues.size()];
        int i=0;
        for (I_Catalogue catalogue : catalogues){
            String nom= catalogue.getNom();
            details[i]=nom+" : "+getNbProduit(catalogue)+" produit(s)";
            i++;
        }
        return details;
    }

    private int getNbProduit(I_Catalogue catalogue){
         List<I_Produit> list = produitDAO.read(catalogue.getNom());
         return list.size();
    }
}
