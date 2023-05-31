package params;

import java.util.ArrayList;
import java.util.List;

import fr.ecommerce.entity.Adresse;
import fr.ecommerce.entity.Params;
import fr.ecommerce.model.dao.implement.ClassDao;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

public class TParamCreate {
	public static void main(String[] args) {
		int paramId = 1;
		Params param = new Params() ;
		ICrudDao paramDao = new CrudDao(param);
		try {
			param = (Params) paramDao.read(paramId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			paramDao.close();
		}
		if (param!=null)
			Utils.trace(param.toString());
		else 
			Utils.trace("param null");
		
	}
}
