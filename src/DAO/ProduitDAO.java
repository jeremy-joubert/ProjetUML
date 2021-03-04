package DAO;

import entity.I_Produit;
import entity.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO implements DAO {
    private Connection connection;
    private Statement statement;

    public ProduitDAO(){
        connection=connectionBD();
        try {
            statement=connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Connection connectionBD() {
        String url = "jdbc:oracle:thin:@162.38.222.149:1521:iut";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String login = "joubertj";
        String mdp = "21092020";
        try {
            Class.forName(driver);
            Connection connection= DriverManager.getConnection(url, login, mdp);
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
        return connection;
    }


    @Override
    public void create(Produit produit) {

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
                nom=resultSet.getString("nom");
                prixUnitaireHT=resultSet.getDouble("prixUnitaireHT");
                produits.add(new Produit(nom, prixUnitaireHT, quantiteStock));
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
    public void update() {

    }

    @Override
    public void delete() {

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
