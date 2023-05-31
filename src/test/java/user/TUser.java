package user;

import java.util.ArrayList;
import java.util.List;

import fr.ecommerce.Ctrl.implement.UserCtrl;
import fr.ecommerce.Ctrl.interfaces.IUserCtrl;
import fr.ecommerce.entity.User;
import fr.ecommerce.model.dao.implement.UserDao;
import fr.ecommerce.model.dao.interfaces.IUserDao;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

public class TUser {

	public static void main(String[] args) {
		Utils.trace("*************************** Begin ************************************\n");
		createOne();
		createMany();
		readOne(1);
//		readMany();
//		update();
//		delete();

		Utils.trace("*************************** end ************************************\n");

	}

//-------------------------------------------------------------------------------------------------
	public static void create() {
		Utils.trace("=========================== Create ===========================\n");
		createOne();
		createMany();

	}

//-------------------------------------------------------------------------------------------------
	public static void read() {
		Utils.trace("=========================== Read ===========================\n");
		readMany();
		readOne(1);

	}

//-------------------------------------------------------------------------------------------------
	public static void update() {
		Utils.trace("=========================== Update ===========================\n");
		int userId = 5;
		User user = null;

		IUserCtrl userCtrl = new UserCtrl();
		try {
			user = userCtrl.getUserById(userId);
			if (user == null)
				Utils.trace("Address null\n");
			else {
				Utils.trace("Before  %s\n", user);

				// -------------------------- update ----------------------
				user.setFirstname( "*** mod ***" + user.getFirstname() + "*** mod ***");
				userCtrl.updateUser(user);

				user = userCtrl.getUserById(userId);
				if (user != null)
					Utils.trace("After %s\n", user);
				else
					Utils.trace("Address null\n");
			}

		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//-------------------------------------------------------------------------------------------------
	public static void delete() {
		Utils.trace("=========================== Delete ===========================\n");
		int userId = 1;
		User user = new User();
		IUserCtrl userCtrl = new UserCtrl();
		IUserDao userDao = new UserDao();
		try {
			user = userCtrl.getUserById(userId);
			if (user == null)
				Utils.trace("Error : l'user n'existe pas\n");
			else {
				userDao.deleteUser(user);

				user = userCtrl.getUserById(userId);

				if (user != null)
					Utils.trace("Error not remove\n");
				else
					Utils.trace("remove ok\n");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// -------------------------------------------------------------------------------------------------

	public static void createOne() {

		User user = new User();
		user = DataTest.genUser();
		Utils.trace("%s\n", user);

		IUserCtrl userCtrl = new UserCtrl();

		try {
			userCtrl.addUser(user);
		} catch (Exception e) {
			Utils.trace("catch create %s\n", e.toString());
		} finally {

		}

		Utils.trace("%s\n", user);
	}
	// -------------------------------------------------------------------------------------------------

	public static void createMany() {
		Utils.trace("=========================== read many  ===========================\n");
		int maxIndex = 10;

		User user = new User();
		Utils.trace("%s\n", user);

		IUserCtrl userCtrl = new UserCtrl();

		try {
			for (int index = 0; index < maxIndex; index++) {
				user = DataTest.genUser();
				userCtrl.addUser(user);
			}
		} catch (Exception e) {
			Utils.trace("catch create %s\n", e.toString());
		} finally {

		}
	}

	// -------------------------------------------------------------------------------------------------
	public static void readMany() {
		Utils.trace("=========================== read many  ===========================\n");

		List<User> userList = new ArrayList<User>();
		IUserCtrl userCtrl = new UserCtrl();
		try {
			userList = userCtrl.getUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if ((userList.size() > 0) && (userList != null)) {
			for (User user : userList) {
				Utils.trace("%s\n", user);
			}
		} else
			Utils.trace("user null");
	}

//-------------------------------------------------------------------------------------------------	
	public static void readOne(int userId) {
		Utils.trace("=========================== read One  ===========================\n");
		
		User user = new User();
		IUserCtrl userCtrl = new UserCtrl();
		try {
			user = userCtrl.getUserById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (user != null)
			Utils.trace("%s\n", user);
		else
			Utils.trace("user null\n");

	}
}
