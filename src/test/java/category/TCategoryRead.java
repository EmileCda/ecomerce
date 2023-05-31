package category;

import java.util.ArrayList;
import java.util.List;

import fr.ecommerce.entity.Categorie;
import fr.ecommerce.model.dao.implement.ClassDao;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TCategoryRead {
	public static void main(String[] args) {
		Utils.trace("*************************** Begin ************************************\n");
		readMany();
//		readOne();
		Utils.trace("*************************** end ************************************\n");
		
	}
	//-------------------------------------------------------------------------------------------------	
	public static void readMany() {
		Utils.trace("=========================== read many  ===========================\n");

		List<ClassDao> categoryList = new ArrayList<ClassDao>() ;
		Categorie category = new Categorie() ;
		ICrudDao categoryDao = new CrudDao(category);
		try {
			categoryList = categoryDao.read();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			categoryDao.close();
		}
		if ((categoryList.size() >0  ) && (categoryList != null)) {
			for (ClassDao classDao : categoryList) {
				category = (Categorie)classDao ; 
				Utils.trace("%s\n",category); 
			}
		}
		else
			Utils.trace(" categoryList vide");
	}
	//-------------------------------------------------------------------------------------------------	
	public static void readOne() {
		Utils.trace("=========================== read One  ===========================\n");
		int categoryId = 1;
		Categorie category = new Categorie() ;
		ICrudDao categoryDao = new CrudDao(category);
		try {
			category = (Categorie) categoryDao.read(categoryId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (category != null )
			Utils.trace(category.toString());
		else 
			Utils.trace("category null");
		
	}
}
