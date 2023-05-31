package params;

import fr.ecommerce.entity.Params;
import fr.ecommerce.entity.User;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TParamDelete {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************");
		
		int rowId = 1;
		Params param = new Params();
		ICrudDao paramDao = new CrudDao(param);
		try {
			param = (Params) paramDao.read(rowId);
			if (param == null) 
				Utils.trace("Error : l'adresse n'existe pas");
			else {
				paramDao.delete(param );
				param = (Params) paramDao.read(rowId);
				if (param != null)
					Utils.trace("Error not remove");
				else
					Utils.trace("remove ok");
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			paramDao.close();
		}
		
		Utils.trace("*************************** end ************************************");
		
	}
}
