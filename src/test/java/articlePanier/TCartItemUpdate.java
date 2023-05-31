package articlePanier;

import fr.ecommerce.entity.ArticlePanier;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TCartItemUpdate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		int rowId = 3;
		ArticlePanier cartItem =  new ArticlePanier();
		ICrudDao cartItemDao = new CrudDao(cartItem) ;
		try {
			cartItem = (ArticlePanier) cartItemDao.read(rowId );
			if (cartItem == null )
				Utils.trace("CartItem null\n");
			else {
				Utils.trace("Before: %s\n",cartItem);

				// -------------------------- update ----------------------
				cartItem.setQuantity(1);
				cartItemDao.update(cartItem);
	
				cartItem = (ArticlePanier) cartItemDao.read(rowId);
				if (cartItem != null )
					Utils.trace("After %s\n",cartItem);
				else
					Utils.trace("CartItem null\n");
			}

		} catch (

				Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			cartItemDao.close();
		}
		
		
		Utils.trace("*************************** end ************************************\n");
		
	}
}
