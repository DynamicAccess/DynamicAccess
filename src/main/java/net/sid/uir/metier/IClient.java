package net.sid.uir.metier;

import java.util.List;

import net.sid.uir.entities.*;

public interface IClient {
	public List<Categorie> listCategories(); 
	public Categorie getCategorie(Long idCat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc); 
	public List<Produit> produitsParCategorie(Long idCat); 
 	public Produit getProduit(Long idP);
	public List<MarqueProd> listmarques(); 
	public List<MarqueProd> marquesParCategorie(Long idCat);
	public List<Produit> produitsSelectionnes(); 



}
