package factory;

import entity.Catalogue;
import entity.I_Catalogue;

public class CatalogueFactory {
    protected CatalogueFactory (){}

    public static I_Catalogue creerCatalogue(String nom){
        try {
            return new Catalogue(nom);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
