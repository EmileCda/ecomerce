package article;

import fr.ecommerce.entity.Categorie;

import fr.ecommerce.entity.Article;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

public class TItemCreate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");

		int maxIndex = 10;
		Article item = new Article() ;
		Article itemAdded = new Article() ;
		item = DataTest.genItem() ;		// generate random item
		Utils.trace("%s\n",item);
		
		int categoryId = 2;
		Categorie category = new Categorie() ;
		ICrudDao categoryDao = new CrudDao(category);
		ICrudDao itemDao = new CrudDao(item);
		try {
			category = (Categorie) categoryDao.read(categoryId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (category == null ) {
			Utils.trace("category null\n");
			
		}else {
			item.setCategory(category);
			category.addItem(item);
			try {
				itemAdded = (Article) itemDao.create(item);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			if (itemAdded != null )
				Utils.trace("%s\n",itemAdded);
			else
				Utils.trace("itemAdded is null \n");
			
		}
				
		
		
		Utils.trace("*************************** end ************************************\n");
		
	}
}
