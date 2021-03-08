package factory;

import DAO.ProduitDAO;
import DAO.ProduitDAO_BDD;

public class ProduitDAOFactory {
    public static ProduitDAO getInstance(){
        return new ProduitDAO_BDD();
    }
}
