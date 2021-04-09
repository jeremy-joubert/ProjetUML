package DAO;

import entity.I_Catalogue;
import entity.I_Produit;
import factory.CatalogueFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogueDAO_BDD extends BDD implements CatalogueDAO {
    private Connection connection;
    private Statement statement;

    public CatalogueDAO_BDD(){
        connection=connectionBD();
        try {
            statement=connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean create(String nomCatalogue) {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("CALL procedure_create_catalogue(?)");
            preparedStatement.setString(1, nomCatalogue);
            return preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<I_Catalogue> read() {
        ResultSet resultSet;
        String nom;
        List<I_Catalogue> catalogues=new ArrayList();
        try {
            resultSet=statement.executeQuery("SELECT nomCatalogue FROM  Catalogue");
            while (resultSet.next()){
                nom=resultSet.getString("nomCatalogue");
                catalogues.add(CatalogueFactory.creerCatalogue(nom));
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return catalogues;
    }



    @Override
    public boolean updateAddProduit(I_Produit produit) {
        return false;
    }

    @Override
    public void delete(String nomCatalogue) {
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM Catalogue WHERE nomCatalogue=?");
            preparedStatement.setString(1, nomCatalogue);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
