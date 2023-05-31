package user;

import fr.ecommerce.Ctrl.implement.UserCtrl;
import fr.ecommerce.Ctrl.interfaces.IUserCtrl;
import fr.ecommerce.entity.User;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

public class TUserCreate {
	public static void main(String[] args) {
		
		Utils.trace("*************************** Begin ************************************\n");
		int maxIndex = 10;
		User user = DataTest.genUser() ;
		User userAdded = new User() ;
		IUserCtrl userCtrl = new UserCtrl();
		
		try {
			for (int index = 0 ; index < maxIndex; index++) {

				user = DataTest.genUser() ;		// generate random user
				userCtrl.addUser(user); // create user in database
				if (user.getId() >0 )
					Utils.trace("%s\n",user);
				else
					Utils.trace("user is null\n");
			}
		} catch (Exception e) {
			Utils.trace("catch create %s\n ", e.toString());
		
		}
		
		
		
		Utils.trace("*************************** end ************************************\n");
		
	}
}
