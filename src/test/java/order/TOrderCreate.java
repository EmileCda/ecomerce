package order;

import fr.ecommerce.entity.Costumer;
import fr.ecommerce.entity.Commande;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

public class TOrderCreate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		int costumerId= 1;

		
		int maxIndex = 10;
		Commande order = new Commande() ;
		Commande orderAdded = null ; 
		ICrudDao orderDao = new CrudDao(order);
		
		Costumer costumer = new Costumer() ;
		ICrudDao costumerDao = new CrudDao(costumer);

		try {
			costumer = (Costumer) costumerDao.read(costumerId);
			if (costumer != null ) {
				Utils.trace(costumer.toString());
			}else {
				Utils.trace("costumer is null" );
				System.exit(costumerId);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			costumerDao.close();
		}
		
		
		
		try {
			for (int index = 0 ; index < maxIndex; index++) {

				order = DataTest.genOrder() ;		// generate random order
				order.setCostumer(costumer);
				costumer.addOrder(order);
				
				orderAdded = (Commande) orderDao.create(order); // create order in database
				if (orderAdded != null)
					Utils.trace("%s\n",orderAdded);
				else
					Utils.trace("%s\n","orderAdded is null");
			}
		} catch (Exception e) {
			Utils.trace("catch create : %s\n", e.toString());
		}finally {
//			orderDao.close();
		}
		
		
		
		Utils.trace("*************************** end ************************************\n");
		
	}
}
