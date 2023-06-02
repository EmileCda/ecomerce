package fr.ecommerce.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.ecommerce.Ctrl.implement.UserCtrl;
import fr.ecommerce.Ctrl.interfaces.IUserCtrl;
import fr.ecommerce.common.IConstant;

import fr.ecommerce.entity.Categorie;
import fr.ecommerce.entity.User;
import fr.ecommerce.model.dao.implement.CategorieDao;
import fr.ecommerce.model.dao.interfaces.ICategorieDao;

@ManagedBean
@SessionScoped
public class ItemManagementBean extends MasterBean implements IConstant {

	List<Categorie> categorieList;

	public ItemManagementBean() {
		if (this.getCategorieList() == null) {
			this.setCategorieList(new ArrayList<Categorie>());
		}
		ICategorieDao categorieDao = new CategorieDao();
		try {
			categorieList = categorieDao.getCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//-------------------------------------------------------------------------------------------------	
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    action %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

		public String updateCategorie(Categorie categorie) {

				// redirection vers une nouvelle page de gestion des catégorie
			String pageReturn = null ; 
			
			return pageReturn;
		}
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    action %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

		public String deleteCategory(Categorie categorie) {
			
			String pageReturn = null ; 
		
			return pageReturn;
		}
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    action %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

		public String updateItem(Categorie categorie) {
			
			String pageReturn = null ; 
		
			return pageReturn;
		}
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	//-------------------------------------------------------------------------------------------------	

	//-------------------------------------------------------------------------------------------------
	public List<Categorie> getCategorieList() {
		return categorieList;
	}

	public void setCategorieList(List<Categorie> categorieList) {
		this.categorieList = categorieList;
	}

}
