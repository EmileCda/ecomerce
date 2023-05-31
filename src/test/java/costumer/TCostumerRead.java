package costumer;

import java.util.ArrayList;
import java.util.List;

import fr.ecommerce.entity.CartePaiement;
import fr.ecommerce.entity.Costumer;
import fr.ecommerce.model.dao.implement.ClassDao;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TCostumerRead {
	public static void main(String[] args) {
		Utils.trace("*************************** Begin ************************************");
		
//		readMany();
		readOne();
		Utils.trace("*************************** end ************************************");
		
	}
	//-------------------------------------------------------------------------------------------------	
		public static void readMany() {
			Utils.trace("=========================== read many  ===========================");
			List<ClassDao> costumerList = new ArrayList<ClassDao>() ;
			Costumer costumer = new Costumer() ;

			ICrudDao costumerDao = new CrudDao(costumer);
			Utils.trace(" readMany ");
			try {
				Utils.trace(" readMany ");
				costumerList = costumerDao.read();
				Utils.trace(" readMany ");
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				costumerDao.close();
			}
			
			if ((costumerList.size() >0  ) && (costumerList != null)) {
				for (ClassDao classDao : costumerList) {
					costumer = (Costumer)classDao ; 
					
					Utils.trace(costumer.toString()); 
				}
					
			}
				
			else
				Utils.trace(" costumerList vide");
			
		}
	//-------------------------------------------------------------------------------------------------	
		public static void readOne() {
			Utils.trace("=========================== read One  ===========================");
			int userId = 1;
			Costumer costumer = new Costumer() ;
			ICrudDao costumerDao = new CrudDao(costumer);

			try {
				costumer = (Costumer) costumerDao.read(userId);
				if (costumer != null )
					Utils.trace(costumer.toString());
				else
					Utils.trace("costumer is null" );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				costumerDao.close();
			}
			
		}
}
