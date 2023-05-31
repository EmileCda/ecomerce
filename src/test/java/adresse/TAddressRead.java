package adresse;

import java.util.ArrayList;
import java.util.List;

import fr.ecommerce.entity.Adresse;
import fr.ecommerce.model.dao.implement.AdresseDao;
import fr.ecommerce.model.dao.interfaces.IAdresseDao;

import fr.ecommerce.utils.Utils;

public class TAddressRead {
	public static void main(String[] args) {
		Utils.trace("*************************** Begin ************************************\n");
		readMany();
//		readOne();
		Utils.trace("*************************** end ************************************\n");
		
	}
//-------------------------------------------------------------------------------------------------	
	public static void readMany() {
		Utils.trace("=========================== read many  ===========================\n");

		List<Adresse> adresseList = new ArrayList<Adresse>() ;
		IAdresseDao adresseDao = new AdresseDao();
		try {
			adresseList = adresseDao.getAdresses();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if ((adresseList.size() >0  ) && (adresseList != null)) {
			for (Adresse adresse : adresseList) {
				Utils.trace("%s\n",adresse); 
			}
		}
		else
			Utils.trace("address null");
	}
//-------------------------------------------------------------------------------------------------	
	public static void readOne() {
		Utils.trace("=========================== read One  ===========================\n");
		int addressId = 1;
		Adresse adresse = new Adresse() ;
		IAdresseDao adresseDao = new AdresseDao();
		try {
			adresse = adresseDao.getAdresseById(addressId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (adresse != null )
			Utils.trace("%s\n",adresse); 
		else 
			Utils.trace("address null\n");
		
	}
//-------------------------------------------------------------------------------------------------	
}
