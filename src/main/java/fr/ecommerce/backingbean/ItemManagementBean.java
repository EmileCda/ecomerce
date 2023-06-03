package fr.ecommerce.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import fr.ecommerce.Ctrl.implement.UserCtrl;
import fr.ecommerce.Ctrl.interfaces.IUserCtrl;
import fr.ecommerce.common.IConstant;
import fr.ecommerce.entity.Article;
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
		
		if (this.getCategorieList().size()>=0 ) {				// prendre l'id (par défaut) du premier de la liste 
			this.setCategorieId(this.getCategorieList()
								.get(0)
								.getId());
			
		}else
			this.setCategorieId(DEFAULT_ID);								// in case of empty list
		
		setCurrentCategorie(this.getCategorieId());
		this.cleanPromptStatus();
		this.setPromptStatus(String.format("catégorie en cours : %s",this.getCurrentCategorie().getName() ));
		

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
		public String updateItem(Article article) {
			
			String pageReturn = null ; 
		
			return pageReturn;
		}
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    action %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		public String deleteItem(Article article) {
			
			String pageReturn = null ; 
		
			return pageReturn;
		}
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    action %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		public String addItempToCart(Article article) {
			
			String pageReturn = null ;
			
			
		
			return pageReturn;
		}
		//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    action %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

		public String categorieChange(ValueChangeEvent eventCategoryList) {
			String pageReturn = null ;
			int categoryId = (int)eventCategoryList.getNewValue();
//			Categorie categorySelected = this.getCategorieList().get(categoryId );

			this.setCurrentCategorie( categoryId);
			
			this.setPromptStatus(String.format("catégorie en cours : %s",this.getCurrentCategorie().getName() ));
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

	public void setCurrentCategorie(int categoryId) {
// this method is needed to change categoryId into indexof 
// categorieList in order to retreive the rightcategory
		
		for (Categorie categorie : this.getCategorieList()) {
			if (categorie.getId()== categoryId) {
				this.setCurrentCategorie(categorie);
				break;		// once found, no need to loop 
			}		
		}
		
	}

	public void setCurrentCategorie(Categorie currentCategorie) {
		this.currentCategorie = currentCategorie;
	}

}
