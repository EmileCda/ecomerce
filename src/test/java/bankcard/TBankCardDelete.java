package bankcard;

import fr.ecommerce.entity.CartePaiement;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TBankCardDelete {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************");
		int rowId = 2;
		CartePaiement bankCard = new CartePaiement();
		ICrudDao bankCardDao = new CrudDao(bankCard);
		try {
			bankCard = (CartePaiement) bankCardDao.read(rowId);
			if (bankCard == null) 
				Utils.trace("Error : l'adresse n'existe pas");
			else {
				bankCardDao.delete(bankCard );
				bankCard = (CartePaiement) bankCardDao.read(rowId);
				if (bankCard != null)
					Utils.trace("Error not remove");
				else
					Utils.trace("remove ok");
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			bankCardDao.close();
		}	
		Utils.trace("*************************** end ************************************");
		
	}
}
