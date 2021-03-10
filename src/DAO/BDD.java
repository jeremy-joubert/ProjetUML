package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BDD {
   public Connection connectionBD(){
      String url = "jdbc:oracle:thin:@162.38.222.149:1521:iut";
      String driver = "oracle.jdbc.driver.OracleDriver";
      String login = "joubertj";
      String mdp = "21092020";
      try {
         Class.forName(driver);
         Connection connection= DriverManager.getConnection(url, login, mdp);
         return connection;
      }catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
         return null;
      }
   }

   public void close(){}

}
