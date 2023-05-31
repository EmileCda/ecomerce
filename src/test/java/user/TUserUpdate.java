package user;

import fr.ecommerce.entity.User;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.Utils;

public class TUserUpdate {
	public static void main(String[] args) {

		Utils.trace("*************************** Begin ************************************\n");
		int rowId = 12;
		User user = new User();
		ICrudDao userDao = new CrudDao(user);
		try {
			user = (User) userDao.read(rowId);
			if (user == null)
				Utils.trace("User null\n");
			else {
				Utils.trace("Before %s\n", user.toString());

				// -------------------------- update ----------------------
				user.setPassword("a");
				userDao.update(user);

				user = (User) userDao.read(rowId);
				if (user != null)
					Utils.trace("After %s\n", user);
				else
					Utils.trace("User null\n");
			}
		} catch (Exception e) {
			Utils.trace("catch readMany %s\n ", e.toString());
		} finally {
			userDao.close();
		}
		Utils.trace("*************************** end ************************************\n");
	}
}
