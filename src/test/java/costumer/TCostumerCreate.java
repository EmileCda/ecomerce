package costumer;

import fr.ecommerce.entity.Adresse;
import fr.ecommerce.entity.CartePaiement;
import fr.ecommerce.entity.Costumer;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

public class TCostumerCreate {
	public static void main(String[] args) {
		int maxIndex = 10 ;
		Utils.trace("*************************** Begin ************************************\n");
		
		Costumer costumer = DataTest.genCostumer() ;
		Costumer costumerAdded = new Costumer() ;
		ICrudDao costumerDao = new CrudDao(costumer);
		
		try {
			for (int index = 0 ; index < maxIndex; index++) {

				costumer = DataTest.genCostumer() ;		// generate random costumer

				int maxAddress = Utils.randInt(1, 4);
				Adresse address = new Adresse() ;
				for (int nbAddress = 0 ; nbAddress < maxAddress; nbAddress++) {
				
					address = DataTest.genAddress(); 	// generate random address
					address.setCostumer(costumer);		// assign costumer tu address
					costumer.addAddress(address);		// add address to costumer addressList
				}

				int maxBankCard = Utils.randInt(1, 4);
				CartePaiement bankCard= new CartePaiement() ;

				for (int nbBankCard = 0 ; nbBankCard < maxBankCard; nbBankCard++) {
				
					bankCard = DataTest.genBankCard(costumer); // generate random bankcard
					bankCard.setCostumer(costumer);				// assign costumer to bankcard
					costumer.addBankCard(bankCard);				// add bankcard to costumer bankcardlist
				}

				
				costumerAdded = (Costumer) costumerDao.create(costumer); // create costumer in database
			}
		} catch (Exception e) {
			Utils.trace("catch create : %s\n", e.toString());
		}finally {
			costumerDao.close();
		}
		
		Utils.trace("%s\n",costumerAdded);
		Utils.trace("*************************** end ************************************\n");
		
	}
}
