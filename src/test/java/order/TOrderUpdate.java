package order;

import fr.ecommerce.entity.Commande;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TOrderUpdate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		int rowId = 1;
		Commande order =  new Commande();
		ICrudDao orderDao = new CrudDao(order) ;
		try {
			order = (Commande) orderDao.read(rowId );
			if (order == null )
				Utils.trace("Order null\n");
			else {
				Utils.trace("Before: %s\n",order);

				// -------------------------- update ----------------------
				order.setOrderNumber("Temporary-order-number");
				orderDao.update(order);
	
				order = (Commande) orderDao.read(rowId);
				if (order != null )
					Utils.trace("After %s\n",order);
				else
					Utils.trace("Order null\n");
			}

		} catch (

				Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			orderDao.close();
		}
		
		
		Utils.trace("*************************** end ************************************\n");
		
	}
}
