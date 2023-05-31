package adresse;

import java.util.ArrayList;
import java.util.List;

import fr.ecommerce.entity.Adresse;
import fr.ecommerce.entity.Costumer;
import fr.ecommerce.model.dao.implement.AdresseDao;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.IAdresseDao;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

public class TAddressCreate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		createMany();
		Utils.trace("*************************** end ************************************\n");
		
	}
	//-------------------------------------------------------------------------------------------------	
		public static void createStandard() {
//			int userId = 1;
//			Costumer costumer = new Costumer() ;
////			IObjectDao costumerDao = new CostumerDao();
//			ICrudDao costumerDao = new CrudDao(costumer);
//			try {
//				costumer = (Costumer) costumerDao.read(userId);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				costumerDao.close();
//			}
//			if (costumer!=null)
//				Utils.trace(costumer.toString());
//			else 
//				Utils.trace("costumer null");
//			
	//
			Adresse adresse = new Adresse() ;
			adresse = DataTest.genAdresse();
			Utils.trace("%s\n",adresse);
			
//			address.setCostumer(costumer);
//			costumer.addAddress(address);
//			Utils.trace(costumer.getAddressList().get(0).toString());
			
			IAdresseDao adresseDao = new AdresseDao();
			
			try {
				adresseDao.addAdresse(adresse);
			} catch (Exception e) {
				Utils.trace("catch create %s\n", e.toString());
			}finally {
				
			}
			
			Utils.trace("%s\n",adresse);
		}
		//-------------------------------------------------------------------------------------------------	
			public static void createMany() {
		Utils.trace("=========================== read many  ===========================\n");
		int maxIndex = 10 ; 
		
		Adresse adresse = new Adresse() ;
		Utils.trace("%s\n",adresse);
		
//		address.setCostumer(costumer);
//		costumer.addAddress(address);
//		Utils.trace(costumer.getAddressList().get(0).toString());
		
		IAdresseDao adresseDao = new AdresseDao();
		
		try {
			for (int index = 0 ; index <maxIndex ; index ++) {
				adresse = DataTest.genAdresse();
				adresseDao.addAdresse(adresse);
			}
		} catch (Exception e) {
			Utils.trace("catch create %s\n", e.toString());
		}finally {
			
		}
	}
	
	
}
