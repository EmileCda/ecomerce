package fr.ecommerce.Ctrl.implement;

import java.util.ArrayList;
import java.util.List;

import fr.ecommerce.Ctrl.interfaces.IUserCtrl;
import fr.ecommerce.entity.CartePaiement;
import fr.ecommerce.entity.User;
import fr.ecommerce.model.dao.implement.UserDao;
import fr.ecommerce.model.dao.interfaces.IUserDao;
import fr.ecommerce.utils.Code;
import fr.ecommerce.utils.Dates;
import fr.ecommerce.utils.Utils;

public class UserCtrl implements IUserCtrl {

	
	
	
	public UserCtrl() {
	 
	}
	@Override
	public void addUser(User user) throws Exception {
		
		user = preWrite(user) ;
		IUserDao userDao = new UserDao();
		userDao.addUser(user);
		
	}
//-------------------------------------------------------------------------------------------------
	@Override
	public User getUserById(int id) throws Exception {
		IUserDao userDao = new UserDao();
		User user = new User() ;
		user = userDao.getUserById(id);
		return  postRead(user) ;
	}

	//-------------------------------------------------------------------------------------------------
	@Override
	public User getUserByEmail(String email) throws Exception {
		IUserDao userDao = new UserDao();
		User user = new User() ;
		user = userDao.getUserByEmail(email);
		return  postRead(user) ;
	}

	//-------------------------------------------------------------------------------------------------
	@Override
	public List<User> getUsers() throws Exception {
		List<User> userList = new ArrayList<User>();
		List<User> userListReturn = new ArrayList<User>();
		
		IUserDao userDao = new UserDao();
		userList = userDao.getUsers();
		
		for (User user : userList) {
			
			userListReturn.add(postRead(user));
			
		}
		
		return userListReturn;
	}

	//-------------------------------------------------------------------------------------------------
	@Override
	public void updateUser(User user) throws Exception {

		user = preWrite(user) ;
		
		IUserDao userDao = new UserDao();
		userDao.updateUser(user);
		
	}
	
	
	//-------------------------------------------------------------------------------------------------
	private User preWrite(User user) {
		
		user.setPasswordEncrpted(Code.encrypt(user.getPassword()));

		user.setBirthdateSql(Dates.convertDateUtilToSql(user.getBirthdate()));
		
		CartePaiementCtrl cartePaiementCtrl = new CartePaiementCtrl();
		
		
		for (CartePaiement CartePaiement : user.getBankCardList()) {
			
			cartePaiementCtrl.preWrite(CartePaiement);
		}
		
		return user; 
	}

	
	//-------------------------------------------------------------------------------------------------
	private User postRead(User user) {

		user.setPassword(Code.decrypt(user.getPasswordEncrpted()));
		user.setBirthdate(Dates.convertDateSqlToUtil(user.getBirthdateSql()));
		CartePaiementCtrl cartePaiementCtrl = new CartePaiementCtrl();

		for (CartePaiement CartePaiement : user.getBankCardList()) {
			
			cartePaiementCtrl.postRead(CartePaiement);
		}

		return user; 
	}

}
