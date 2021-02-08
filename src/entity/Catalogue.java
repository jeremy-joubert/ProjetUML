package entity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Catalogue implements I_Catalogue {
    private ArrayList<I_Produit> lesProduits;

    public Catalogue() {
        lesProduits=new ArrayList<>();
    }

    @Override
    public String toString() {
        String r="";
        for(I_Produit produit : lesProduits){
            r=r+produit.getNom()+" - prix HT : "+produit.getPrixUnitaireHT()+" € - prix TTC : "+produit.getPrixUnitaireTTC()+" € - quantité en stock : "+produit.getQuantite() + "\n";
        }
        r=r+"Montant total TTC du stock : "+getMontantTotalTTC()+" €";
        return r;
    }

    @Override
    public boolean addProduit(I_Produit produit) {
        if(produit!=null&&!verifiProduitExistant(produit.getNom())){
            lesProduits.add(produit);
            return true;
        }
        return false;
    }

    @Override
    public boolean addProduit(String nom, double prix, int qte) {
        if(qte>-1&&prix>0&&!verifiProduitExistant(nom)){
            try {
                Produit produit=new Produit(nom, prix, qte);
                lesProduits.add(produit);
                return true;
            }catch (Exception e){
                return false;
            }

        }
        return false;
    }

    @Override
    public int addProduits(List<I_Produit> l) {
        int nb=0;
        if(l==null){
            return 0;
        }
        for(I_Produit produit : l ){
            if(produit!=null&&!verifiProduitExistant(produit.getNom())){
                lesProduits.add(produit);
                nb++;
            }
        }
        return nb;
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
        if(qteAchetee>0){
            for(I_Produit produit : lesProduits){
                if(produit.getNom()==nomProduit){
                    produit.ajouter(qteAchetee);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean vendreStock(String nomProduit, int qteVendue) {
        if(qteVendue>0){
            for(I_Produit produit : lesProduits){
                if(produit.getNom()==nomProduit&&produit.getQuantite()>=qteVendue){
                    produit.enlever(qteVendue);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String[] getNomProduits() {
        String[] nomProduits=new String[lesProduits.size()];
        int a=0;
        for(I_Produit produit : lesProduits){
            nomProduits[a]=produit.getNom();
            a++;
        }
        String tmp;
        for (int i=0; i < lesProduits.size(); i++)
        {
            for (int j=i+1; j < lesProduits.size(); j++)
            {
                if (nomProduits[i].compareTo(nomProduits[j]) > 0)
                {
                    tmp = nomProduits[i];
                    nomProduits[i] = nomProduits[j];
                    nomProduits[j] = tmp;
                }
            }
        }
        return nomProduits;
    }

    @Override
    public double getMontantTotalTTC() {
        DecimalFormat df = new DecimalFormat () ;
        df.setMaximumFractionDigits ( 2 );
        double somme=0;
        for(I_Produit produit : lesProduits){
            somme=somme+produit.getPrixStockTTC();
        }
        return  Double.parseDouble(df.format (somme));
    }

    @Override
    public void clear() {
        lesProduits.clear();
    }

    public boolean verifiProduitExistant(String nom){
        String[] listNomProduits=getNomProduits();
        for (String nomProduit : listNomProduits){
            if(nomProduit.replaceAll("\\s", "").equals(nom.replaceAll("\\s", ""))){
                return true;
            }
        }
        return false;
    }
}
