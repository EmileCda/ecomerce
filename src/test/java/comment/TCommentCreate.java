package comment;

import fr.ecommerce.entity.Commentaire;
import fr.ecommerce.entity.Costumer;
import fr.ecommerce.entity.Article;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

public class TCommentCreate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
//		createOne(2,2);
		
		for (int userId = 1; userId < 5 ; userId++) {
			for (int itemId = 1; itemId < 5 ; itemId++) {
				createOne(userId,itemId);
			}
		}
		
		Utils.trace("*************************** end ************************************\n");
	
	}
	//-------------------------------------------------------------------------------------------------	
	public static void createOne(int costumerId, int itemId) {
		Utils.trace("************************** create one **********************************\n");
		Commentaire commentAdded = null  ;		// generate random comment
		Commentaire comment = DataTest.genComment() ;		// generate random comment
		Costumer costumer = retrieveCostumer(costumerId);
		Article	item = retrieveItem(itemId);
		
		comment.setCostumer(costumer);
		comment.setItem(item);

		costumer.addComment(comment);
		item.addComment(comment);
		
		ICrudDao commentDao = new CrudDao(comment);

		try {
			commentAdded = (Commentaire) commentDao.create(comment); // create comment in database
			if (commentAdded != null)
				Utils.trace("%s\n",commentAdded);
			else
				Utils.trace("%s\n","commentAdded is null");
		} catch (Exception e) {
			Utils.trace("catch create : %s\n", e.toString());
		}finally {
			commentDao.close();
		}
	}
	//-------------------------------------------------------------------------------------------------	
	public static void displayOneComment() {
		Utils.trace("************************** Display one comment**********************************\n");

		Commentaire comment = new Commentaire() ;
		comment = DataTest.genComment() ;	
		Utils.trace("%s\n",comment);
	}
	
	//-------------------------------------------------------------------------------------------------	
	public static Costumer retrieveCostumer(int id) {
		
		Utils.trace("=========================== read One Costumer [%d]  ===========================\n",id);
		Costumer costumer = new Costumer() ;
		ICrudDao costumerDao = new CrudDao(costumer);

		try {
			costumer = (Costumer) costumerDao.read(id);
			if (costumer != null )
				Utils.trace("%s\n",costumer);
			else
				Utils.trace("costumer is null" );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			costumerDao.close();
		}
		
		return  costumer;
		
	}
	//-------------------------------------------------------------------------------------------------	
	public static Article retrieveItem(int id) {
		
		Utils.trace("=========================== read One Item [%d]  ===========================\n",id);
		Article item = new Article() ;
		ICrudDao itemDao = new CrudDao(item);
		try {
			item = (Article) itemDao.read(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (item != null )
			Utils.trace("%s\n",item);
		else 
			Utils.trace("item null\n");
		
		return  item;
	}
}
