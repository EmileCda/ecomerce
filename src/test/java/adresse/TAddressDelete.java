package adresse;

import fr.ecommerce.entity.Adresse;
import fr.ecommerce.entity.User;
import fr.ecommerce.model.dao.implement.AdresseDao;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.IAdresseDao;
import fr.ecommerce.utils.Utils;

public class TAddressDelete {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		int addressId = 1;
		Adresse adresse = new Adresse();
		IAdresseDao adresseDao = new AdresseDao();
		try {
			adresse = adresseDao.getAdresseById(addressId);
			if (adresse == null) 
				Utils.trace("Error : l'adresse n'existe pas\n");
			else {
				adresseDao.deleteAdresse(adresse );

				adresse = adresseDao.getAdresseById(addressId);

				if (adresse != null)
					Utils.trace("Error not remove\n");
				else
					Utils.trace("remove ok\n");
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		Utils.trace("*************************** end ************************************\n");
		
	}
}
