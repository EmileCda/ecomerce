package articlePanier;

import fr.ecommerce.entity.ArticlePanier;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TCartItemDelete {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		
		int rowId =  1;
		ArticlePanier cartItem = new ArticlePanier();
		ICrudDao cartItemDao = new CrudDao(cartItem);
		try {
			cartItem = (ArticlePanier) cartItemDao.read(rowId);
			if (cartItem == null) 
				Utils.trace("Error : CartItem n'existe pas\n");
			else {
				Utils.trace("last time seen: %s\n",cartItem);
				cartItemDao.delete(cartItem );
				cartItem = (ArticlePanier) cartItemDao.read(rowId);
				if (cartItem != null)	
					Utils.trace("Error : not remove\n");
				else
					Utils.trace("remove ok\n");
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			cartItemDao.close();
		}
		
		Utils.trace("*************************** end ************************************\n");
		
	}
}
