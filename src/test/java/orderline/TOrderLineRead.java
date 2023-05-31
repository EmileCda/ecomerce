package orderline;

import java.util.ArrayList;
import java.util.List;

import fr.ecommerce.entity.LigneDeCommande;
import fr.ecommerce.model.dao.implement.ClassDao;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TOrderLineRead {
	public static void main(String[] args) {
		Utils.trace("*************************** Begin ************************************\n");
		readMany();
//		readOne();
		Utils.trace("*************************** end ************************************\n");
		
	}
	//-------------------------------------------------------------------------------------------------	
	public static void readMany() {
		Utils.trace("=========================== read many  ===========================\n");

		List<ClassDao> orderLineList = new ArrayList<ClassDao>() ;
		LigneDeCommande orderLine = new LigneDeCommande() ;
		ICrudDao orderLineDao = new CrudDao(orderLine);
		try {
			orderLineList = orderLineDao.read();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			orderLineDao.close();
		}
		if ((orderLineList.size() >0  ) && (orderLineList != null)) {
			for (ClassDao classDao : orderLineList) {
				orderLine = (LigneDeCommande)classDao ; 
				Utils.trace("%s\n",orderLine);
			}
		}
		else
			Utils.trace(" orderLineList vide");
	}
	//-------------------------------------------------------------------------------------------------	
	public static void readOne() {
		Utils.trace("=========================== read One  ===========================\n");
		int orderLineId =21;
		LigneDeCommande orderLine = new LigneDeCommande() ;
		ICrudDao orderLineDao = new CrudDao(orderLine);
		try {
			orderLine = (LigneDeCommande) orderLineDao.read(orderLineId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (orderLine != null )
			Utils.trace("%s\n",orderLine);
		else 
			Utils.trace("orderLine null\n");
		
	}
}
