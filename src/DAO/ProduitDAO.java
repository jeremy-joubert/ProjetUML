package DAO;

import java.util.List;

public interface ProduitDAO{
    public boolean create(String nomProduit, double prix, int qte, String nomCatalogue);
    public List read(String nomCatalogue);
    public boolean update(String nomProduit, int qte, String nomCatalogue);
    public void delete(String nomProduit, String nomCatalogue);
}
