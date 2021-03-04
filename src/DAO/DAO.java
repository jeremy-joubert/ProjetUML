package DAO;

import entity.I_Produit;

import java.sql.Connection;
import java.util.List;

public interface DAO {
   Connection connectionBD();
   void create(I_Produit produit);
   List read();
   void update();
   void delete();
   void close();

}
