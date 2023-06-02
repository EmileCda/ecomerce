package fr.ecommerce.backingbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.ecommerce.Ctrl.implement.UserCtrl;
import fr.ecommerce.Ctrl.interfaces.IUserCtrl;
import fr.ecommerce.common.IConstant;
import fr.ecommerce.entity.User;
import fr.ecommerce.enums.Gender;
import fr.ecommerce.enums.Profile;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;


@ManagedBean
@SessionScoped
public class AddUserBean extends MasterBean implements IConstant {

	
	private User user ;

	private String promptStatus;
	private String passwordConfirmation;
	private Gender homme ;
	private Gender femme ;
	private Profile client;
	private Profile magasinier;
	private Profile manager;
	
	private boolean displaySetProfile;

	
	public AddUserBean() {
		this.setUser(new User());
		this.getUser().clean();
		this.setHomme(Gender.MALE) ;
		this.setFemme( Gender.FEMALE );
		this.setManager(Profile.MANAGER);
		this.setMagasinier(Profile.STORE_KEEPER);
		this.setClient(Profile.COSTUMER);
		this.setIsDisplaySetProfile(false);
		
	}

	//%%%%%%%%%%%%%%%%%%%%%%%%%% action %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	public String addUser() {
		
		return null; 
	}
	
	
	//%%%%%%%%%%%%%%%%%%%%%%%%%% action %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	
	public String addClient() {
		String landingWebPage = CLIENT_HOME; 
		IUserCtrl userCtrl = new UserCtrl();

		try {
			userCtrl.addUser(this.getUser());
		} catch (Exception e) {
			Utils.trace("catch addClient %s\n", e.toString());
			return null; 
		} 
		
		if (getUser().getProfile() == Profile.MANAGER)
			landingWebPage = ADMIN_HOME;
		
		this.getUser().clean();
		return landingWebPage ; 
	}
	
//%%%%%%%%%%%%%%%%%%%%%%%%%% action %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	public String cheatCode() {
		
		this.setUser(DataTest.genUser());
		
		if (this.getUser() != null)
			Utils.trace("cheatCode user %s\n", this.getUser());
		else 
			Utils.trace("cheatCode user null \n");
		return null; 
	}
	
	
	//%%%%%%%%%%%%%%%%%%%%%%%%%% action %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPromptStatus() {
		return promptStatus;
	}

	public void setPromptStatus(String promptStatus) {
		this.promptStatus = promptStatus;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public Gender getHomme() {
		return homme;
	}

	public void setHomme(Gender homme) {
		this.homme = homme;
	}

	public Gender getFemme() {
		return femme;
	}

	public void setFemme(Gender femme) {
		this.femme = femme;
	}

	public Profile getClient() {
		return client;
	}

	public void setClient(Profile client) {
		this.client = client;
	}

	public Profile getMagasinier() {
		return magasinier;
	}

	public void setMagasinier(Profile magasinier) {
		this.magasinier = magasinier;
	}



	public Profile getManager() {
		return manager;
	}

	public void setManager(Profile manager) {
		this.manager = manager;
	}

	public boolean isDisplaySetProfile() {
		return displaySetProfile;
	}

	public boolean getIsDisplaySetProfile() {
		return isDisplaySetProfile();
	}

	public void setDisplaySetProfile(boolean displaySetProfile) {
		this.displaySetProfile = displaySetProfile;
	}
	
	public void setIsDisplaySetProfile(boolean displaySetProfile) {
		this.setDisplaySetProfile(displaySetProfile);
	}
	
	
	
}
