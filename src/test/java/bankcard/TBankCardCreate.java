package bankcard;

import fr.ecommerce.entity.CartePaiement;
import fr.ecommerce.entity.Costumer;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

public class TBankCardCreate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************");

		//--- retreive an existing costumer 
		int userId = 2;
		Costumer costumer = new Costumer() ;
		ICrudDao costumerDao = new CrudDao(costumer);
		try {
			costumer = (Costumer) costumerDao.read(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			costumerDao.close();
		}		if (costumer != null)
			Utils.trace(costumer.toString());
		else
			Utils.trace("costumer is null ") ;
			
		
// creating a bankcard and assign it to the user 
		
		CartePaiement bankCard = new CartePaiement() ;
		bankCard = DataTest.genBankCard(costumer);
		Utils.trace(bankCard.toString());
		
		bankCard.setCostumer(costumer);
		
		ICrudDao bankCardDao = new CrudDao(bankCard);
		CartePaiement bankCardAdded = new CartePaiement() ;
		
		try {
			bankCardAdded = (CartePaiement) bankCardDao.create(bankCard);
		} catch (Exception e) {
			Utils.trace("catch create " + e.toString());
		}finally {
			bankCardDao.close();
		}
		
		if (bankCardAdded != null ) 
			Utils.trace(bankCardAdded.toString());
		else 
			Utils.trace("bankCardAdded est null ");

		Utils.trace("*************************** end ************************************");
		
	}
}
