package fr.ecommerce.backingbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.ecommerce.Ctrl.implement.UserCtrl;
import fr.ecommerce.Ctrl.interfaces.IUserCtrl;
import fr.ecommerce.common.IConstant;
import fr.ecommerce.entity.User;
import fr.ecommerce.enums.Profile;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean  extends MasterBean implements IConstant {

	private User user;
	
	private String welcome = null;
	private boolean isAdmin ;


	public LoginBean() {
		this.setIsAdmin(false);
		user = new User();
		this.clean();
	}
//%%%%%%%%%%%%%%%%%%%%%%%%%% action %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	public String checkUser() throws Exception {

		Utils.trace(HR);
		String pageReturn = null ; 

		if (getUser() == null) {
			return pageReturn;
		}

		String passwordSaisi = getUser().getPassword();
		IUserCtrl userCtrl = new UserCtrl();
		User userRetreive = userCtrl.getUserByEmail(getUser().getEmail());
		if (userRetreive == null )
			return pageReturn;
		this.setUser(userRetreive);
		this.setPromptStatus("");

		if (userRetreive.getPassword().equals(passwordSaisi)) {
			this.setIsAdmin(false);		
			switch (this.getUser().getProfile()) {
			case COSTUMER: pageReturn =CLIENT_HOME; 
								break ;  
			case MANAGER:pageReturn = 
								ADMIN_HOME; 
								this.setIsAdmin(true);
								break ;
			case STORE_KEEPER: pageReturn =STOREKEEPER_HOME; 
								break ;  
			default:
				return pageReturn = HOME;
			}
			this.setWelcome(String.format("Bonjour cher(e) [%s] %s",user.getProfile().getName(),user.getFirstname()));
			user.setPassword("");// cleaning input 
		
		} else this.setPromptStatus("erreur login Ou mot de pass");
		
		return pageReturn;

	}

//-------------------------------------------------------------------------------------------------	
	public User getUser() {
		return user;
	}

//-------------------------------------------------------------------------------------------------	
	public void setUser(User user) {
		this.user = user;
	}
//-------------------------------------------------------------------------------------------------	
	public void initTestUser() {
		String firstname = DataTest.firstname();
		this.getUser().setEmail(DataTest.email(firstname, DataTest.lastname()));
		this.getUser().setPassword(DataTest.pass(firstname));
	}

	//-------------------------------------------------------------------------------------------------	
	public String disconnect() {
		this.setUser(null );
		this.setPromptStatus(null);
		this.setWelcome(null);
		this.setAdmin(false);
		return HOME;
	}
	//-------------------------------------------------------------------------------------------------	
	public void clean() {
		this.getUser().clean();
		this.setPromptStatus(null);
	}
		public String getWelcome() {
			return welcome;
		}
		public void setWelcome(String welcome) {
			this.welcome = welcome;
		}
		public boolean isAdmin() {
			return isAdmin;
		}
		public void setAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
		}

		public boolean getIsAdmin() {
			return this.isAdmin();
		}
		public void setIsAdmin(boolean isAdmin) {
			this.setAdmin(isAdmin); 
		}

		
}
