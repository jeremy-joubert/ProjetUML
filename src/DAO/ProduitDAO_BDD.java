package DAO;

import entity.I_Produit;
import factory.ProduitFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO_BDD extends BDD implements ProduitDAO{
    private Connection connection;
    private Statement statement;

    public ProduitDAO_BDD(){
        connection=connectionBD();
        try {
            statement=connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean create(String nomProduit, double prix, int qte) {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("CALL procedure_add_produit(?, ?, ?)");
            preparedStatement.setString(1, nomProduit);
            preparedStatement.setInt(2, qte);
            preparedStatement.setDouble(3, prix);
            return preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    @Override
    public List<I_Produit> read() {
        ResultSet resultSet;
        int quantiteStock;
        String nom;
        double prixUnitaireHT;
        List<I_Produit> produits=new ArrayList();
        try {
            resultSet=statement.executeQuery("SELECT * FROM  Produits");
            while (resultSet.next()){
                quantiteStock=resultSet.getInt("quantiteStock");
                nom=resultSet.getString("nomProduit");
                prixUnitaireHT=resultSet.getDouble("prixProduit");
                produits.add(ProduitFactory.creerProduit(nom, prixUnitaireHT, quantiteStock));
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public boolean update(String nomProduit, int qte) {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("" +
                    "UPDATE Produits " +
                    "SET quantiteStock=quantiteStock+?" +
                    "WHERE nomProduit=?");
            preparedStatement.setInt(1, qte);
            preparedStatement.setString(2, nomProduit);
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(String nomProduit) {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("" +
                    "DELETE FROM Produits " +
                    "WHERE nomProduit=?");
            preparedStatement.setString(1, nomProduit);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
