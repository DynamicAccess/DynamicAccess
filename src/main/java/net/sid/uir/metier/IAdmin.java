package net.sid.uir.metier;

import java.util.List;

import net.sid.uir.entities.*;

public interface IAdmin extends IClient {
	
	public Long ajouterProduit(Produit	p, Long idCat); 
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produit p);
	public Long ajouterCategorie(Categorie c);
	public void supprimerCategorie(Long idcat); 
	public void modifierCategorie(Categorie c); 
	public void ajouterUser(User u);
	public void attribuerRole(Role r,Long userID);
	public Long ajouterMarque(MarqueProd	m, Long idCat);
	public void supprimerMarque(Long idP); 
	public void modifierMarque(MarqueProd m); 




}
