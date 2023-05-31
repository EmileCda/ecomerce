package category;

import fr.ecommerce.entity.Categorie;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TCategoryDelete {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		
		int rowId =  1;
		Categorie category = new Categorie();
		ICrudDao categoryDao = new CrudDao(category);
		try {
			category = (Categorie) categoryDao.read(rowId);
			if (category == null) 
				Utils.trace("Error : category n'existe pas\n");
			else {
				Utils.trace("%s\n",category);
				categoryDao.delete(category );
				category = (Categorie) categoryDao.read(rowId);
				if (category != null)
					Utils.trace("Error not remove\n");
				else
					Utils.trace("remove ok\n");
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			categoryDao.close();
		}
		
		Utils.trace("*************************** end ************************************\n");
		
	}
}
