package factory;

import DAO.CatalogueDAO;
import DAO.CatalogueDAO_BDD;

public class CatalogueDAOFactory {
    protected CatalogueDAOFactory(){}
    public static CatalogueDAO getInstance(){
        return new CatalogueDAO_BDD();
    }
}
