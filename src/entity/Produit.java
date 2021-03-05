package entity;

import java.text.DecimalFormat;

public class Produit implements I_Produit {
    private int quantiteStock;
    private String nom;
    private double prixUnitaireHT;
    private double prixUnitaireTTC;
    private double tauxTVA;

    public Produit(String nom, double prixUnitaireHT, int quantiteStock) throws Exception {
        if(prixUnitaireHT>0&&quantiteStock>-1){
            this.quantiteStock = quantiteStock;
            this.nom = nom.trim();
            this.prixUnitaireHT = prixUnitaireHT;
            this.tauxTVA=0.2;
            this.prixUnitaireTTC=prixUnitaireHT*(1+tauxTVA);
        }else {
            throw new Exception("prix ou stock <0");
        }

    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String produitToString="";
        produitToString=produitToString + (getNom()+" - prix HT : "+df.format(prixUnitaireHT)+" € - prix TTC : "+df.format(prixUnitaireTTC)+" € - quantité en stock : "+getQuantite());
        return produitToString;
    }

    @Override
    public boolean ajouter(int qteAchetee) {
        quantiteStock=quantiteStock+qteAchetee;
        return true;
    }

    @Override
    public boolean enlever(int qteVendue) {
        quantiteStock=quantiteStock-qteVendue;
        return true;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public int getQuantite() {
        return quantiteStock;
    }

    @Override
    public double getPrixUnitaireHT() {
        return  prixUnitaireHT;
    }

    @Override
    public double getPrixUnitaireTTC() {
        return prixUnitaireHT*(1+tauxTVA);
    }

    @Override
    public double getPrixStockTTC() {
        return getPrixUnitaireTTC() * quantiteStock;
    }
}
