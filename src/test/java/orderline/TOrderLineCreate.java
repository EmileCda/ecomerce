package orderline;

import fr.ecommerce.entity.Costumer;
import fr.ecommerce.entity.Article;
import fr.ecommerce.entity.Commande;
import fr.ecommerce.entity.LigneDeCommande;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

public class TOrderLineCreate {
	public static void main(String[] args) {

		Utils.trace("*************************** Begin ************************************\n");

//		displayOneOrderLine() ;

		for (int orderId = 1; orderId < 5; orderId++) {
			for (int itemId = 1; itemId < 5; itemId++) {
				createOne(orderId, itemId);
			}
		}

		Utils.trace("*************************** end ************************************\n");

	}


	// -------------------------------------------------------------------------------------------------
	public static void createOne(int orderId, int itemId) {
		Utils.trace("************************** create one **********************************\n");
		LigneDeCommande orderLine = new LigneDeCommande();
		LigneDeCommande orderLineAdded = new LigneDeCommande();
		orderLine.setQuantity(Utils.randInt(1, 10));
		Article item = retrieveItem(itemId);
		Commande order = retrieveOrder(orderId);

		orderLine.setItem(item);
		orderLine.setOrder(order);

		order.addOrderLine(orderLine);
		item.addOrderLine(orderLine);

		ICrudDao orderLineDao = new CrudDao(orderLine);

		try {
			orderLineAdded = (LigneDeCommande) orderLineDao.create(orderLine); // create orderLine in database
			if (orderLineAdded != null)
				Utils.trace("%s\n", orderLineAdded);
			else
				Utils.trace("%s\n", "orderLineAdded is null");
		} catch (Exception e) {
			Utils.trace("catch create : %s\n", e.toString());
		} finally {
			orderLineDao.close();
		}
	}

	// -------------------------------------------------------------------------------------------------
	public static void displayOneOrderLine() {
		Utils.trace("************************** Display one orderLine**********************************\n");

		LigneDeCommande orderLine = new LigneDeCommande();
		orderLine.setQuantity(2);
		orderLine.setItem(DataTest.genItem());
		orderLine.setOrder(DataTest.genOrder());

		Utils.trace("%s\n", orderLine);
	}

	// -------------------------------------------------------------------------------------------------
	public static Commande retrieveOrder(int id) {

		Utils.trace("=========================== read One Order [%d]  ===========================\n", id);
		Commande order = new Commande();
		ICrudDao orderDao = new CrudDao(order);

		try {
			order = (Commande) orderDao.read(id);
			if (order == null)
				Utils.trace("costumer is null");
		} catch (Exception e) {
			Utils.trace("catch %s", e.toString());
			e.printStackTrace();
		} finally {
			orderDao.close();
		}
		return order;
	}

	// -------------------------------------------------------------------------------------------------
	public static Costumer retrieveCostumer(int id) {

		Utils.trace("=========================== read One Costumer [%d]  ===========================\n", id);
		Costumer costumer = new Costumer();
		ICrudDao costumerDao = new CrudDao(costumer);

		try {
			costumer = (Costumer) costumerDao.read(id);
			if (costumer == null)
				Utils.trace("costumer is null");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			costumerDao.close();
		}
		return costumer;
	}

	// -------------------------------------------------------------------------------------------------
	public static Article retrieveItem(int id) {

		Utils.trace("=========================== read One Item [%d]  ===========================\n", id);
		Article item = new Article();
		ICrudDao itemDao = new CrudDao(item);
		try {
			item = (Article) itemDao.read(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (item != null)
			Utils.trace("%s\n", item);
		else
			Utils.trace("item null\n");

		return item;
	}
}
