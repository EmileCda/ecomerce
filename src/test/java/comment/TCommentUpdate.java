package comment;

import fr.ecommerce.entity.Commentaire;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TCommentUpdate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		int rowId = 1;
		Commentaire comment =  new Commentaire();
		ICrudDao commentDao = new CrudDao(comment) ;
		try {
			comment = (Commentaire) commentDao.read(rowId );
			if (comment == null )
				Utils.trace("Comment null\n");
			else {
				Utils.trace("Before: %s\n",comment);

				// -------------------------- update ----------------------
				comment.setGrade(5);
				commentDao.update(comment);
	
				comment = (Commentaire) commentDao.read(rowId);
				if (comment != null )
					Utils.trace("After %s\n",comment);
				else
					Utils.trace("Comment null\n");
			}

		} catch (

				Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			commentDao.close();
		}
		
		
		Utils.trace("*************************** end ************************************\n");
		
	}
}
