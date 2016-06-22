package net.sid.uir.DAO;

import java.util.List;

import net.sid.uir.entities.*;

public interface DynamicAccessDAO {
	
	public Long ajouterCategorie(Categorie c); 
	public List<Categorie> listCategories(); 
	public Categorie getCategorie(Long idCat); 
	public void supprimerCategrorie(Long idcat); 
	public void modifierCategorie(Categorie c);

	public Long ajouterProduit(Produit	p, Long idCat); 
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc); 
	public List<Produit> produitsParCategorie(Long idCat); 
	public Produit getProduit(Long idP); 
	public void supprimerProduit(Long idP); 
	public void modifierProduit(Produit p);
	public List<Produit> produitsSelectionnes();

	
	public void ajouterUser(User u);
	public void attribuerRole(Role r,Long userID);
	
	public Long ajouterMarque(MarqueProd	m, Long idCat);
	public List<MarqueProd> listmarrques(); 
	public void supprimerMarque(Long idM); 
	public void modifierMarque(MarqueProd m);
	public List<MarqueProd> marquesParCategorie(Long idCat);



}
