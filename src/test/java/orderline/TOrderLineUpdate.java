package orderline;

import fr.ecommerce.entity.LigneDeCommande;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TOrderLineUpdate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		int rowId = 23;
		LigneDeCommande orderLine =  new LigneDeCommande();
		ICrudDao orderLineDao = new CrudDao(orderLine) ;
		try {
			orderLine = (LigneDeCommande) orderLineDao.read(rowId );
			if (orderLine == null )
				Utils.trace("OrderLine null\n");
			else {
				Utils.trace("Before: %s\n",orderLine);

				// -------------------------- update ----------------------
				orderLine.setQuantity(1);
				orderLineDao.update(orderLine);
	
				orderLine = (LigneDeCommande) orderLineDao.read(rowId);
				if (orderLine != null )
					Utils.trace("After %s\n",orderLine);
				else
					Utils.trace("OrderLine null\n");
			}

		} catch (

				Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			orderLineDao.close();
		}
		
		
		Utils.trace("*************************** end ************************************\n");
		
	}
}
