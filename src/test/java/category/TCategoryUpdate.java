package category;

import fr.ecommerce.entity.Categorie;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TCategoryUpdate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		int rowId = 2;
		Categorie category =  new Categorie();
		ICrudDao categoryDao = new CrudDao(category) ;
		try {
			category = (Categorie) categoryDao.read(rowId );
			if (category == null )
				Utils.trace("Category null ");
			else {
				Utils.trace("Before %s\n",category);
				// -------------------------- update ----------------------
				category.setName("modified name");
				categoryDao.update(category);
				
				category = (Categorie) categoryDao.read(rowId);
				if (category != null )
					Utils.trace("After%s\n",category);
				else
					Utils.trace("Category null \n");
			}
		} catch (
				Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			categoryDao.close();
		}
		Utils.trace("*************************** end ************************************\n");
		
	}
}
