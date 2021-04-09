package DAO;

import entity.I_Produit;

import java.util.List;

public interface CatalogueDAO {
    public boolean create(String nomCatalogue);
    public List read();
    public boolean updateAddProduit(I_Produit produit);
    public void delete(String nomCatalogue);
}
