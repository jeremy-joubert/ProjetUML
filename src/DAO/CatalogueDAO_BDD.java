package DAO;

import entity.I_Produit;

import java.util.List;

public class CatalogueDAO_BDD extends BDD implements CatalogueDAO {
    @Override
    public boolean create(String nomCatalogue) {
        return false;
    }

    @Override
    public List read() {
        return null;
    }

    @Override
    public boolean updateAddProduit(I_Produit produit) {
        return false;
    }

    @Override
    public void delete(String nomCatalogue) {

    }
}
