package controller;

import DAO.CatalogueDAO;
import entity.I_Catalogue;
import entity.I_Produit;
import factory.CatalogueDAOFactory;
import factory.CatalogueFactory;

import java.util.List;

public class CatalogueController {

    private CatalogueDAO catalogueDAO;
    public CatalogueController(){
        catalogueDAO=CatalogueDAOFactory.getInstance();
    }

    public void creerCatalogue(String nomCatalogue){
        catalogueDAO.create(nomCatalogue);

    }

    public void supprimerCatalogue(String nomCatalogue){
        catalogueDAO.delete(nomCatalogue);
    }

    public I_Catalogue choisirCatalogue(String nomCatalogue){
        List<I_Produit> produits = catalogueDAO.read(nomCatalogue);
        I_Catalogue catalogue = CatalogueFactory.creerCatalogue(nomCatalogue);
        remplirCatalogueLocal(produits, catalogue);
        return catalogue;
    }

    public String[] afficherCatalogue(){
        List<I_Catalogue> catalogues=catalogueDAO.findAll();
        String [] noms=new String[catalogues.size()];
        int i=0;
        for (I_Catalogue catalogue : catalogues){
            noms[i]=catalogue.getNom();
            i++;
        }
        return noms;
    }

    public String[] afficherDetailCatalogue(){
        List<I_Catalogue> catalogues=catalogueDAO.findAll();
        String [] details=new String[catalogues.size()];
        List<I_Produit> produits;
        int i=0;
        for (I_Catalogue catalogue : catalogues){
            String nom= catalogue.getNom();
            produits = catalogueDAO.read(nom);
            remplirCatalogueLocal(produits, catalogue);
            details[i]=nom+" : "+catalogue.getNomProduits().length+" produit(s)";
            i++;
        }
        return details;
    }

    private void remplirCatalogueLocal(List<I_Produit> produits, I_Catalogue catalogue){
        for (I_Produit produit : produits){
            catalogue.addProduit(produit);
        }
    }
}
