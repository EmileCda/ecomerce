package fr.ecommerce.backingbean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.ecommerce.common.IConstant;
import fr.ecommerce.entity.Costumer;
import fr.ecommerce.entity.User;
import fr.ecommerce.enums.Profile;
import fr.ecommerce.model.dao.implement.CrudDao;
import fr.ecommerce.model.dao.interfaces.ICrudDao;
import fr.ecommerce.utils.DataTest;
import fr.ecommerce.utils.Utils;

@ManagedBean(name ="addCostumerBean")
@SessionScoped

//https://stackoverflow.com/questions/30128395/identifying-and-solving-javax-el-propertynotfoundexception-target-unreachable
public class AddCostumerBean implements Serializable,IConstant{
	
	private static final long serialVersionUID = 1L;
	
	private String passwordRepeat ;
	private String birthDateString ;
	private Costumer costumer;
	
	public AddCostumerBean() {
		this.setCostumer(costumer);
		initTestingCostumer(); // for testing to be remove in production 
		
	}
	
	
	public void initTestingCostumer() {
		this.setCostumer(DataTest.genCostumer());
		Utils.trace(this.getCostumer().toString());
	}
		
	
	public String add() throws Exception {
		
		Utils.trace("String add()");
		this.getCostumer().setProfile(Profile.COSTUMER);
		this.getCostumer().setIsActif(true);
		Utils.trace(this.getCostumer().toString());
		
		ICrudDao costumerDao = new CrudDao(costumer);
		Costumer costumerAdded = new Costumer() ;
		
		costumerAdded = (Costumer) costumerDao.create(this.getCostumer());
		
		this.setCostumer(costumerAdded);
		Utils.trace(this.getCostumer().toString());
		
		return null; 
		
	}
	
	
	public String generateUser() throws Exception {
				
		initTestingCostumer();
		return null; 

		
	}
	
	
	
	
	public String getPasswordRepeat() {
		return this.passwordRepeat;
	}
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;

	}
	public String getBirthDateString() {
		return this.birthDateString;
	}

	public void setBirthDateString(String birthDateString) {
		this.birthDateString = birthDateString;
		this.getCostumer().setBirthdate(Utils.string2Date(birthDateString, DATE_FORMAT));
	}


	public Costumer getCostumer() {
		return this.costumer;
	}


	public void setCostumer(Costumer costumer) {
		this.costumer = costumer;
	}

	

}
