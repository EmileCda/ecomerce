package article;

import java.util.ArrayList;
import java.util.List;

import fr.ecommerce.entity.Article;
import fr.ecommerce.model.dao.implement.ClassDao;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TItemRead {
	public static void main(String[] args) {
		Utils.trace("*************************** Begin ************************************\n");
		readMany();
		readOne();
		Utils.trace("*************************** end ************************************\n");
		
	}
	//-------------------------------------------------------------------------------------------------	
	public static void readMany() {
		Utils.trace("=========================== read many  ===========================\n");

		List<ClassDao> itemList = new ArrayList<ClassDao>() ;
		Article item = new Article() ;
		ICrudDao itemDao = new CrudDao(item);
		try {
			itemList = itemDao.read();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			itemDao.close();
		}
		if ((itemList.size() >0  ) && (itemList != null)) {
			for (ClassDao classDao : itemList) {
				item = (Article)classDao ; 
				Utils.trace("%s\n",item); 
			}
		}
		else
			Utils.trace(" itemList vide");
	}
	//-------------------------------------------------------------------------------------------------	
	public static void readOne() {
		Utils.trace("=========================== read One  ===========================\n");
		int itemId = 3;
		Article item = new Article() ;
		ICrudDao itemDao = new CrudDao(item);
		try {
			item = (Article) itemDao.read(itemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (item != null )
			Utils.trace("%s\n",item);
		else 
			Utils.trace("item null\n");
		
	}
}
