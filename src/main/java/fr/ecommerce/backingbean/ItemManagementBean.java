package fr.ecommerce.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import fr.ecommerce.Ctrl.implement.UserCtrl;
import fr.ecommerce.Ctrl.interfaces.IUserCtrl;
import fr.ecommerce.common.IConstant;

import fr.ecommerce.entity.Categorie;
import fr.ecommerce.entity.User;
import fr.ecommerce.model.dao.implement.CategorieDao;
import fr.ecommerce.model.dao.interfaces.ICategorieDao;
import fr.ecommerce.utils.Utils;

@ManagedBean
@SessionScoped
public class ItemManagementBean extends MasterBean implements IConstant {

	List<Categorie> categorieList;
	int  categorieId ;
	Categorie currentCategorie;

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
		
		if (this.getCategorieList().size()>0 ) {				// prendre l'id (par défaut) du premier de la liste 
			this.setCategorieId(this.getCategorieList()
								.get(1)
								.getId());
			
		}else
			this.setCategorieId(0);								// liste vide
			
		this.setCategorieId(5);								// liste vide
		this.setCurrentCategorie( this.getCategorieList()
									.get(this.getCategorieId()));
		

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
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    action %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

		public String categorieChange(ValueChangeEvent e) {
			String pageReturn = null ;
			Utils.trace("categorieChange  : %s\n", this.getCategorieId());
			Utils.trace("categorieChange  : %s\n", e.getNewValue().toString());
			Utils.trace("categorieChange d : %d\n", e.getNewValue());
			Utils.trace("categorieChange 2  : %s\n", this.getCategorieId());
		
			this.setPromptStatus(String.format("Id cat : %d", e.getNewValue()));
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


	public int getCategorieId() {
		return categorieId;
	}

	public void setCategorieId(int categorieId) {
		this.categorieId = categorieId;
	}

	public Categorie getCurrentCategorie() {
		return currentCategorie;
	}

	public void setCurrentCategorie(Categorie currentCategorie) {
		this.currentCategorie = currentCategorie;
	}

}
