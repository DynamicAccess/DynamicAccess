package net.sid.uir.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.sid.uir.DAO.DynamicAccessDAO;
import net.sid.uir.entities.Categorie;
import net.sid.uir.entities.MarqueProd;
import net.sid.uir.entities.Produit;
import net.sid.uir.entities.Role;
import net.sid.uir.entities.User;
@Transactional
public class DynamicAccessMetierImpl implements IAdmin {
     private DynamicAccessDAO dao; 
     
	public void setDao(DynamicAccessDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idCat);
	}

	@Override
	public List<Produit> listproduits() {
		// TODO Auto-generated method stub
		return dao.listproduits();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.produitsParCategorie(idCat);
	}

	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return dao.getProduit(idP);
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		// TODO Auto-generated method stub
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public void supprimerProduit(Long idP) {
		// TODO Auto-generated method stub
		dao.supprimerProduit(idP);
	}

	@Override
	public void modifierProduit(Produit p) {
        
		dao.modifierProduit(p);		
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategorie(Long idcat) {
		// TODO Auto-generated method stub
		dao.supprimerCategrorie(idcat);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		// TODO Auto-generated method stub
		dao.modifierCategorie(c);
	}

	@Override
	public void ajouterUser(User u) {
		// TODO Auto-generated method stub
		dao.ajouterUser(u);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		// TODO Auto-generated method stub
		dao.attribuerRole(r, userID);
	}

	@Override
	public Long ajouterMarque(MarqueProd m, Long idCat) {
		// TODO Auto-generated method stub
		return dao.ajouterMarque(m, idCat);
	}

	@Override
	public List<MarqueProd> listmarques() {
		// TODO Auto-generated method stub
		return dao.listmarrques();
	}

	@Override
	public void supprimerMarque(Long idP) {
		// TODO Auto-generated method stub
		dao.supprimerMarque(idP);
	}

	@Override
	public void modifierMarque(MarqueProd m) {
		// TODO Auto-generated method stub
		dao.modifierMarque(m);
	}

	@Override
	public List<MarqueProd> marquesParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.marquesParCategorie(idCat);	}

	@Override
	public List<Produit> produitsSelectionnes() {
		// TODO Auto-generated method stub
		return dao.produitsSelectionnes();
	}

}
