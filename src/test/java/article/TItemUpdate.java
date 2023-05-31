package article;

import fr.ecommerce.entity.Article;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TItemUpdate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		int rowId = 3;
		Article item =  new Article();
		ICrudDao itemDao = new CrudDao(item) ;
		try {
			item = (Article) itemDao.read(rowId );
			if (item == null )
				Utils.trace("Item null\n");
			else {
				Utils.trace("Before: %s\n",item);

				// -------------------------- update ----------------------
				item.setName("Name modified");
				itemDao.update(item);
	
				item = (Article) itemDao.read(rowId);
				if (item != null )
					Utils.trace("After %s\n", item.toString());
				else
					Utils.trace("Item null\n");
			}

		} catch (

				Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			itemDao.close();
		}
		
		
		Utils.trace("*************************** end ************************************");
		
	}
}
