package fr.ecommerce.model.dao.interfaces;
import java.util.List;

import fr.ecommerce.entity.Commentaire;


public interface ICommentaireDao {
	
	public void addCommentaire (Commentaire Commentaire)  throws Exception;

	public Commentaire getCommentaireById(int id) throws Exception;
	
	public List<Commentaire> getCommentaires() throws Exception;

	public void updateCommentaire(Commentaire Commentaire) throws Exception; 
	public void deleteCommentaire (Commentaire Commentaire) throws Exception;
	
	

}
