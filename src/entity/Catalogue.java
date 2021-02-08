package entity;

import java.util.ArrayList;
import java.util.List;

public class Catalogue implements I_Catalogue {
    private ArrayList<I_Produit> lesProduits;

    public Catalogue() {
    }

    @Override
    public boolean addProduit(I_Produit produit) {
        lesProduits.add(produit);
        return true;
    }

    @Override
    public boolean addProduit(String nom, double prix, int qte) {
        Produit produit=new Produit(qte, nom, prix);
        lesProduits.add(produit);
        return true;
    }

    @Override
    public int addProduits(List<I_Produit> l) {
        lesProduits.addAll(l);
        return 0;
    }

    @Override
    public boolean removeProduit(String nom) {
        for(I_Produit produit : lesProduits){
            if(produit.getNom()==nom){
                lesProduits.remove(produit);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean acheterStock(String nomProduit, int qteAchetee) {
        for(I_Produit produit : lesProduits){
            if(produit.getNom()==nomProduit){
                produit.ajouter(qteAchetee);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean vendreStock(String nomProduit, int qteVendue) {
        for(I_Produit produit : lesProduits){
            if(produit.getNom()==nomProduit&&produit.getQuantite()>=qteVendue){
                produit.enlever(qteVendue);
                return true;
            }
        }
        return false;
    }

    @Override
    public String[] getNomProduits() {
        String[] nomProduits=new String[lesProduits.size()];
        int i=0;
        for(I_Produit produit : lesProduits){
            nomProduits[i]=produit.getNom();
            i++;
        }
        return nomProduits;
    }

    @Override
    public double getMontantTotalTTC() {
        double somme=0;
        for(I_Produit produit : lesProduits){
            somme=somme+produit.getPrixStockTTC();
        }
        return somme;
    }

    @Override
    public void clear() {
        lesProduits.clear();
    }
}
