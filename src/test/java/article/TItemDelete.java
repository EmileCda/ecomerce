package article;

import fr.ecommerce.entity.Article;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TItemDelete {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		
		int rowId =  4;
		Article item = new Article();
		ICrudDao itemDao = new CrudDao(item);
		try {
			item = (Article) itemDao.read(rowId);
			if (item == null) 
				Utils.trace("Error :item rowid[%d] n'existe pas\n",rowId);
			else {
				Utils.trace("%s\n",item);
				itemDao.delete(item );
				item = (Article) itemDao.read(rowId);
				if (item != null)
					Utils.trace("Error :item rowid[%d] existe toujours\n",rowId);
				else
					Utils.trace("remove rowId [%d] ok\n",rowId);
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			itemDao.close();
		}
		
		Utils.trace("*************************** end ************************************\n");
		
	}
}
