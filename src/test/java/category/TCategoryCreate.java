package category;

import fr.ecommerce.entity.Categorie;
import fr.ecommerce.entity.Article;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

public class TCategoryCreate {
	public static void main(String[] args) {

		Utils.trace("*************************** Begin ************************************\n");
		int maxIndex = 3;

		Categorie category = null;
		new Categorie();
		Article item;
		ICrudDao categoryDao = new CrudDao(category);
		try {
			for (int index = 0; index < maxIndex; index++) {
				category = DataTest.genCategory(); // generate random category
				int maxItem = Utils.randInt(1, 10);

				for (int nbItem = 0; nbItem < maxItem; nbItem++) {

					item = DataTest.genItem();
					item.setCategory(category);
					category.addItem(item);
				}
				category = (Categorie) categoryDao.create(category); // create category in database
				if (category != null)
					Utils.trace("%s\n", category);
				else
					Utils.trace("categoryAdded is nul\n");
			}
		} catch (Exception e) {
			Utils.trace("catch create %s\n", e.toString());
		} finally {
			categoryDao.close();
		}
		Utils.trace("*************************** end ************************************\n");
	}
}
