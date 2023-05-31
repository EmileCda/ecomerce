package costumer;

import fr.ecommerce.entity.Costumer;
import fr.ecommerce.entity.User;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TCostumerDelete {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************");
		
		int rowId = 1;
		Costumer costumer = new Costumer();
		ICrudDao costumerDao = new CrudDao(costumer);
		try {
			costumer = (Costumer) costumerDao.read(rowId);
			if (costumer == null) 
				Utils.trace("Error : l'adresse n'existe pas");
			else {
				costumerDao.delete(costumer );
				costumer = (Costumer) costumerDao.read(rowId);
				if (costumer != null)
					Utils.trace("Error not remove");
				else
					Utils.trace("remove ok");
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			costumerDao.close();
		}
		
		Utils.trace("*************************** end ************************************");
	}
}
