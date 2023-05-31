package orderline;

import fr.ecommerce.entity.LigneDeCommande;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TOrderLineDelete {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		
		int rowId =  21;
		LigneDeCommande orderLine = new LigneDeCommande();
		ICrudDao orderLineDao = new CrudDao(orderLine);
		try {
			orderLine = (LigneDeCommande) orderLineDao.read(rowId);
			if (orderLine == null) 
				Utils.trace("Error : OrderLine n'existe pas\n");
			else {
				Utils.trace("last time seen: %s\n",orderLine);
				orderLineDao.delete(orderLine );
				orderLine = (LigneDeCommande) orderLineDao.read(rowId);
				if (orderLine != null)	
					Utils.trace("Error : not remove\n");
				else
					Utils.trace("remove ok\n");
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			orderLineDao.close();
		}
		
		Utils.trace("*************************** end ************************************\n");
		
	}
}
