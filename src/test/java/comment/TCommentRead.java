package comment;

import java.util.ArrayList;
import java.util.List;

import fr.ecommerce.entity.Commentaire;
import fr.ecommerce.model.dao.implement.ClassDao;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TCommentRead {
	public static void main(String[] args) {
		Utils.trace("*************************** Begin ************************************\n");
		readMany();
//		readOne();
		Utils.trace("*************************** end ************************************\n");
		
	}
	//-------------------------------------------------------------------------------------------------	
	public static void readMany() {
		Utils.trace("=========================== read many  ===========================\n");

		List<ClassDao> commentList = new ArrayList<ClassDao>() ;
		Commentaire comment = new Commentaire() ;
		ICrudDao commentDao = new CrudDao(comment);
		try {
			commentList = commentDao.read();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			commentDao.close();
		}
		if ((commentList.size() >0  ) && (commentList != null)) {
			for (ClassDao classDao : commentList) {
				comment = (Commentaire)classDao ; 
				Utils.trace("%s\n",comment);
			}
		}
		else
			Utils.trace(" commentList vide");
	}
	//-------------------------------------------------------------------------------------------------	
	public static void readOne() {
		Utils.trace("=========================== read One  ===========================\n");
		int commentId = 1;
		Commentaire comment = new Commentaire() ;
		ICrudDao commentDao = new CrudDao(comment);
		try {
			comment = (Commentaire) commentDao.read(commentId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (comment != null )
			Utils.trace("%s\n",comment);
		else 
			Utils.trace("comment null\n");
		
	}
}
