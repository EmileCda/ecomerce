package fr.ecommerce.backingbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.ecommerce.common.IConstant;
import fr.ecommerce.entity.Categorie;

@ManagedBean
@SessionScoped
public class AddCategoryBean extends MasterBean implements IConstant {
	
	
	
	Categorie categorie ;

	
	
	
	
	
	public AddCategoryBean() {
		// TODO Auto-generated constructor stub
	}



	public Categorie getCategorie() {
		return categorie;
	}

	
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	

}
