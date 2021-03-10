package factory;

import DAO.Adaptateur_ProduitDAO_XML;
import DAO.ProduitDAO;

public class ProduitDAOFactory {
    protected ProduitDAOFactory(){}
    public static ProduitDAO getInstance(){
        return new Adaptateur_ProduitDAO_XML();
    }
}
