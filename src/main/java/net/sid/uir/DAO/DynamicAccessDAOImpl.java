package net.sid.uir.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.sid.uir.entities.Categorie;
import net.sid.uir.entities.Client;
import net.sid.uir.entities.Commande;
import net.sid.uir.entities.MarqueProd;
import net.sid.uir.entities.Panier;
import net.sid.uir.entities.Produit;
import net.sid.uir.entities.Role;
import net.sid.uir.entities.User;

public class DynamicAccessDAOImpl implements DynamicAccessDAO {
     @PersistenceContext
	 private EntityManager em ;
	 
	@Override
	public Long ajouterCategorie(Categorie c) {
       em.persist(c);
		return c.getIdCategorie();
	}

	@Override
	public List<Categorie> listCategories() {
		Query req =em.createQuery("Select c from Categorie c ");
		return req.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
       
		return em.find(Categorie.class, idCat);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		Categorie c = em.find(Categorie.class, idcat)	;	
		 em.remove(c);
	}

	@Override
	public void modifierCategorie(Categorie c) {
             em.merge(c) ;
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
	    Categorie c =getCategorie(idCat);
	    p.setCategorie(c);
		em.persist(p);
		return p.getIdProduit();
	}

	@Override
	public List<Produit> listproduits() {
	      Query req = em.createQuery("Select p from Produit p ");
	      return req.getResultList();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		Query req = em.createQuery("select p from produit p where p.designation like :x or p.description like :x");
		req.setParameter("x","%"+mc+"%");
	      return req.getResultList();
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		Query req = em.createQuery("select p from produit p where p.Categorie.idCategorie=:x  ");
		req.setParameter("x",idCat);
	      return req.getResultList();
	}

	@Override
	public List<Produit> produitsSelectionnes() {
	Query req=em.createQuery("select p from Produit p where p.selectionne=true");
	return req.getResultList();
	}


	@Override
	public Produit getProduit(Long idP) {
		em.find(Produit.class, idP);
		return null;
	}

	@Override
	public void supprimerProduit(Long idP) {
		Produit p =getProduit(idP);
		em.remove(p);
		
	}

	@Override
	public void modifierProduit(Produit p) {
		em.merge(p) ;		
	}

	@Override
	public void ajouterUser(User u) {
             em.persist(u);		
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
        User u=em.find(User.class,userID);	
        u.getRoles().add(r);
        em.persist(r);
	}

	@Override
	public Long ajouterMarque(MarqueProd m, Long idCat) {
		// TODO Auto-generated method stub
		Categorie c =getCategorie(idCat);
	    m.setCategorie(c);
		em.persist(m);
		return m.getIdMarque();
	}

	@Override
	public List<MarqueProd> listmarrques() {
		// TODO Auto-generated method stub
		Query req = em.createQuery("Select m from MarqueProd m ");
	      return req.getResultList();
	}

	@Override
	public void supprimerMarque(Long idM) {
		// TODO Auto-generated method stub
		MarqueProd m = em.find(MarqueProd.class, idM)	;	
		 em.remove(m);
	}

	@Override
	public void modifierMarque(MarqueProd m) {
		// TODO Auto-generated method stub
		em.merge(m) ;
	}

	@Override
	public List<MarqueProd> marquesParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		Query req = em.createQuery("select m from MarqueProd m where m.Categorie.idCategorie=:x  ");
		req.setParameter("x",idCat);
	      return req.getResultList();	}

	


}
