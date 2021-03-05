package DAO;

import entity.I_Produit;

import java.sql.Connection;
import java.util.List;

public interface DAO {
   Connection connectionBD();
   boolean create(I_Produit produit);
   List read();
   boolean update(I_Produit produit);
   void delete();
   void close();

}
