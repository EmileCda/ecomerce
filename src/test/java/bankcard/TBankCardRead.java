package bankcard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.ecommerce.entity.CartePaiement;
import fr.ecommerce.model.dao.implement.ClassDao;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TBankCardRead {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************");
		readOne();
//		readMany();
		Utils.trace("*************************** end ************************************");
		
	}
	
	//-------------------------------------------------------------------------------------------------	
	public static void readMany() {
		Utils.trace("=========================== read many  ===========================");
		List<ClassDao> bankCardList = new ArrayList<ClassDao>() ;
		CartePaiement bankCard =  new CartePaiement();
		ICrudDao bankCardDao = new CrudDao(bankCard) ;
		Utils.trace(" readMany ");
		try {
			Utils.trace(" readMany ");
			bankCardList = bankCardDao.read();
			Utils.trace(" readMany ");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			bankCardDao.close();
		}
		
		if ((bankCardList.size() >0  ) && (bankCardList != null)) {
			bankCard = new CartePaiement(); 
			for (ClassDao classDao : bankCardList) {
				bankCard = (CartePaiement)classDao ; 
				
				Utils.trace(bankCard.toString()); 
			}
				
		}
			
		else
			Utils.trace(" bankCardList vide");
		
	}
//-------------------------------------------------------------------------------------------------	
	public static void readOne() {
		Utils.trace("=========================== read One  ===========================");
		int bankCardId = 1 ;

		CartePaiement bankCard = new CartePaiement() ;
		ICrudDao bankCardDao = new CrudDao(bankCard) ;
		try {
			bankCard = (CartePaiement) bankCardDao.read(bankCardId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			bankCardDao.close();
		}
		if (bankCard != null )
			Utils.trace(bankCard.toString());
		else
			Utils.trace(" bankCard == null ");
		
	}
}
