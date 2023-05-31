package articlePanier;

import java.util.ArrayList;
import java.util.List;

import fr.ecommerce.entity.ArticlePanier;
import fr.ecommerce.model.dao.implement.ClassDao;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TCartItemRead {
	public static void main(String[] args) {
		Utils.trace("*************************** Begin ************************************\n");
		readMany();
//		readOne();
		Utils.trace("*************************** end ************************************\n");
		
	}
	//-------------------------------------------------------------------------------------------------	
	public static void readMany() {
		Utils.trace("=========================== read many  ===========================\n");

		List<ClassDao> cartItemList = new ArrayList<ClassDao>() ;
		ArticlePanier cartItem = new ArticlePanier() ;
		ICrudDao cartItemDao = new CrudDao(cartItem);
		try {
			cartItemList = cartItemDao.read();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			cartItemDao.close();
		}
		if ((cartItemList.size() >0  ) && (cartItemList != null)) {
			for (ClassDao classDao : cartItemList) {
				cartItem = (ArticlePanier)classDao ; 
				Utils.trace("%s\n",cartItem);
			}
		}
		else
			Utils.trace(" cartItemList vide");
	}
	//-------------------------------------------------------------------------------------------------	
	public static void readOne() {
		Utils.trace("=========================== read One  ===========================\n");
		int cartItemId = 6;
		ArticlePanier cartItem = new ArticlePanier() ;
		ICrudDao cartItemDao = new CrudDao(cartItem);
		try {
			cartItem = (ArticlePanier) cartItemDao.read(cartItemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (cartItem != null )
			Utils.trace("%s\n",cartItem);
		else 
			Utils.trace("cartItem null\n");
		
	}
}
