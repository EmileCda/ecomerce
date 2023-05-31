package params;

import fr.ecommerce.entity.Params;
import fr.ecommerce.entity.User;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TParamUpdate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************");

		int rowId = 2;
		Params param =  new Params();
		ICrudDao paramDao = new CrudDao(param) ;
		try {
			param = (Params) paramDao.read(rowId );
			if (param == null )
				Utils.trace("Param null ");
			else {
				Utils.trace("Before" + param.toString());

				// -------------------------- update ----------------------
				param.setIntValue(0);
				paramDao.update(param);
	
				param = (Params) paramDao.read(rowId);
				if (param != null )
					Utils.trace("After" + param.toString());
				else
					Utils.trace("Param null ");
			}

		} catch (

				Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			paramDao.close();
		}
		
		
		
		
		
		
		Utils.trace("*************************** end ************************************");
		
	}
}
