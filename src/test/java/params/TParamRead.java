package params;

import java.util.ArrayList;
import java.util.List;

import fr.ecommerce.entity.Params;
import fr.ecommerce.entity.User;
import fr.ecommerce.model.dao.implement.ClassDao;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TParamRead {
	public static void main(String[] args) {
	Utils.trace("*************************** Begin ************************************");
	readMany();
	readOne();
	Utils.trace("*************************** end ************************************");
	
}
//-------------------------------------------------------------------------------------------------	
public static void readMany() {
	Utils.trace("=========================== read many  ===========================");

	List<ClassDao> paramList = new ArrayList<ClassDao>() ;
	Params param = new Params() ;
	ICrudDao paramDao = new CrudDao(param);
	try {
		paramList = paramDao.read();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		paramDao.close();
	}
	if ((paramList.size() >0  ) && (paramList != null)) {
		for (ClassDao classDao : paramList) {
			param = (Params)classDao ; 
			Utils.trace(param.toString()); 
		}
	}
	else
		Utils.trace(" paramList vide");
}
//-------------------------------------------------------------------------------------------------	
public static void readOne() {
	Utils.trace("=========================== read One  ===========================");
	int paramId = 3;
	Params param = new Params() ;
	ICrudDao paramDao = new CrudDao(param);
	try {
		param = (Params) paramDao.read(paramId);
	} catch (Exception e) {
		e.printStackTrace();
	}
	if (param != null )
		Utils.trace(param.toString());
	else 
		Utils.trace("param null");
	
}
}
