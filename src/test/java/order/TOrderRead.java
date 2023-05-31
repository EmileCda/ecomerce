package order;

import java.util.ArrayList;
import java.util.List;

import fr.ecommerce.entity.Commande;
import fr.ecommerce.model.dao.implement.ClassDao;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TOrderRead {
	public static void main(String[] args) {
		Utils.trace("*************************** Begin ************************************\n");
		readMany();
//		readOne();
		Utils.trace("*************************** end ************************************\n");
		
	}
	//-------------------------------------------------------------------------------------------------	
	public static void readMany() {
		Utils.trace("=========================== read many  ===========================\n");

		List<ClassDao> orderList = new ArrayList<ClassDao>() ;
		Commande order = new Commande() ;
		ICrudDao orderDao = new CrudDao(order);
		try {
			orderList = orderDao.read();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			orderDao.close();
		}
		if ((orderList.size() >0  ) && (orderList != null)) {
			for (ClassDao classDao : orderList) {
				order = (Commande)classDao ; 
				Utils.trace("%s\n",order);
			}
		}
		else
			Utils.trace(" orderList vide");
	}
	//-------------------------------------------------------------------------------------------------	
	public static void readOne() {
		Utils.trace("=========================== read One  ===========================\n");
		int orderId = 1;
		Commande order = new Commande() ;
		ICrudDao orderDao = new CrudDao(order);
		try {
			order = (Commande) orderDao.read(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (order != null )
			Utils.trace("%s\n",order);
		else 
			Utils.trace("order null\n");
		
	}
}
