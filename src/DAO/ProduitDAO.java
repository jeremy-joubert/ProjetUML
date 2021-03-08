package DAO;

import java.util.List;

public interface ProduitDAO{
    public boolean create(String nomProduit, double prix, int qte);
    public List read();
    public boolean update(String nomProduit, int qte);
    public void delete(String nomProduit);
}
