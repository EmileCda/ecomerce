package order;

import fr.ecommerce.entity.Commande;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TOrderDelete {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		
		int rowId =  4;
		Commande order = new Commande();
		ICrudDao orderDao = new CrudDao(order);
		try {
			order = (Commande) orderDao.read(rowId);
			if (order == null) 
				Utils.trace("Error : l'adresse n'existe pas");
			else {
				Utils.trace("last seen: %s\n",order);
				orderDao.delete(order );
				order = (Commande) orderDao.read(rowId);
				if (order != null)	
					Utils.trace("Error : not remove\n");
				else
					Utils.trace("remove ok\n");
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			orderDao.close();
		}
		
		Utils.trace("*************************** end ************************************\n");
		
	}
}
