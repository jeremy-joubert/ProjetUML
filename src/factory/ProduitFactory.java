package factory;

import entity.I_Produit;
import entity.Produit;

public class ProduitFactory {
    protected ProduitFactory (){}

    public static I_Produit creerProduit(String nom, double prixUnitaireHT, int quantiteStock){
        try {
            return new Produit(nom, prixUnitaireHT, quantiteStock);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
