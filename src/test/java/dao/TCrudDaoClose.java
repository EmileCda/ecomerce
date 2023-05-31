package dao;

import fr.ecommerce.entity.CartePaiement;
import fr.ecommerce.entity.Costumer;
import fr.ecommerce.entity.User;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

public class TCrudDaoClose {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************");
		
		int userId = 2;
		Costumer costumer = new Costumer() ;
		ICrudDao costumerDao = new CrudDao(costumer);
		try {
			costumer = (Costumer) costumerDao.read(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			costumerDao.close();	
		}
		Utils.trace(costumer.toString());
		
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
		
		 
		Utils.trace("*************************** end ************************************");
		
	}
}
