package adresse;

import fr.ecommerce.entity.Adresse;
import fr.ecommerce.entity.User;
import fr.ecommerce.model.dao.implement.AdresseDao;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.IAdresseDao;

import fr.ecommerce.utils.Utils;

public class TAddressUpdate {
	public static void main(String[] args) {

		Utils.trace("*************************** Begin ************************************");

		int adresseId = 5;
		Adresse adresse = null ;  
		
		IAdresseDao adresseDao = new AdresseDao();
		try {
			adresse = adresseDao.getAdresseById(adresseId);
			if (adresse == null )
				Utils.trace("Address null\n");
			else {
				Utils.trace("Before  %s\n", adresse);

				// -------------------------- update ----------------------
				adresse.setCity( "*** mod ***" +adresse.getCity() + "*** mod ***");
				adresseDao.updateAdresse(adresse);
	
				adresse = adresseDao.getAdresseById(adresseId);
				if (adresse != null )
					Utils.trace("After %s\n", adresse);
				else
					Utils.trace("Address null\n");
			}

		} catch (

				Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		Utils.trace("*************************** end ************************************");

	}
}
