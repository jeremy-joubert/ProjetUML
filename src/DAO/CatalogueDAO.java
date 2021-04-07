package DAO;

import entity.I_Produit;

import java.util.List;

public interface CatalogueDAO {
    public boolean create(String nomCatalogue);
    public List read(String nomCatalogue);
    public List findAll();
    public boolean updateAddProduit(I_Produit produit);
    public void delete(String nomCatalogue);
}
