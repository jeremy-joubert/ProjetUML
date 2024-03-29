package DAO;

import entity.I_Produit;
import factory.ProduitFactory;

import java.util.List;

public class Adaptateur_ProduitDAO_XML implements ProduitDAO {
    private ProduitDAO_XML adapteur;

    public Adaptateur_ProduitDAO_XML() {
        this.adapteur = new ProduitDAO_XML();
    }

    @Override
    public boolean create(String nomProduit, double prix, int qte, String nomCatalogue) {
        try {
            return adapteur.creer(ProduitFactory.creerProduit(nomProduit, prix, qte), nomCatalogue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List read(String nomCatalogue) {
        return adapteur.lireTous(nomCatalogue);
    }

    @Override
    public boolean update(String nomProduit, int qte, String nomCatalogue) {
        I_Produit produit=adapteur.lire(nomProduit, nomCatalogue);
        return adapteur.maj(produit, nomCatalogue);
    }

    @Override
    public void delete(String nomProduit, String nomCatalogue) {
        I_Produit produit=adapteur.lire(nomProduit, nomCatalogue);
        adapteur.supprimer(produit, nomCatalogue);
    }
}
