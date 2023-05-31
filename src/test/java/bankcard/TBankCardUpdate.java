package bankcard;

import fr.ecommerce.entity.CartePaiement;
import fr.ecommerce.entity.User;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TBankCardUpdate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************");
		

		int rowId = 5;
		CartePaiement bankCard =  new CartePaiement();
		ICrudDao bankCardDao = new CrudDao(bankCard) ;
		try {
			bankCard = (CartePaiement) bankCardDao.read(rowId );
			if (bankCard == null )
				Utils.trace("BankCard null ");
			else {
				Utils.trace("Before" + bankCard.toString());

				// -------------------------- update ----------------------
				bankCard.setOwnerFirstname("Dieu le père");
				bankCardDao.update(bankCard);
	
				bankCard = (CartePaiement) bankCardDao.read(rowId);
				if (bankCard != null )
					Utils.trace("After" + bankCard.toString());
				else
					Utils.trace("BankCard null ");
			}

		} catch (

				Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			bankCardDao.close();
		}
		Utils.trace("*************************** end ************************************");
		
	}
}
