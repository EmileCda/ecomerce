package comment;

import fr.ecommerce.entity.Commentaire;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TCommentDelete {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		
		int rowId =  1;
		Commentaire comment = new Commentaire();
		ICrudDao commentDao = new CrudDao(comment);
		try {
			comment = (Commentaire) commentDao.read(rowId);
			if (comment == null) 
				Utils.trace("Error : Comment n'existe pas\n");
			else {
				Utils.trace("last time seen: %s\n",comment);
				commentDao.delete(comment );
				comment = (Commentaire) commentDao.read(rowId);
				if (comment != null)	
					Utils.trace("Error : not remove\n");
				else
					Utils.trace("remove ok\n");
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			commentDao.close();
		}
		
		Utils.trace("*************************** end ************************************\n");
		
	}
}
