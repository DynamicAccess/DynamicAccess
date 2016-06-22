package net.sid.uir;

import static org.junit.Assert.*;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sid.uir.entities.Categorie;
import net.sid.uir.entities.MarqueProd;
import net.sid.uir.entities.Produit;
import net.sid.uir.metier.IAdmin;

public class TestJPA {
	@org.junit.Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		try {
			ClassPathXmlApplicationContext context=
			new ClassPathXmlApplicationContext(new String[]{"META-INF/applicationContext.xml"});
           IAdmin Metier =
        		   (IAdmin) context.getBean("metier");
           List<Categorie> ctgs1 = Metier.listCategories();
           Metier.ajouterCategorie(new Categorie("Ordinateur","ordi",null,"image1.jpg"));
           Metier.ajouterCategorie(new Categorie("Imprimante","impr",null,"image2.jpg"));
           List<Categorie> ctgs2 = Metier.listCategories();
           assertTrue(ctgs1.size()+2==ctgs2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(),false);
			}

	}
	@Test
	public void test2() {
		try {
			ClassPathXmlApplicationContext context=
			new ClassPathXmlApplicationContext(new String[]{"META-INF/applicationContext.xml"});
           IAdmin Metier =
        		   (IAdmin) context.getBean("metier");
           List<Produit> prod1 = Metier.listproduits();
           Metier.ajouterProduit(new Produit(1234, "DELL", "hfhfhfh", 43, true, "image", 30), 1L);
           Metier.ajouterProduit(new Produit(1234,"Prod2","impr",34,true,"image",6) ,1L);
           List<Produit> prod2 = Metier.listproduits();
           assertTrue(prod1.size()+2==prod2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(),false);
			}

	}
	@Test
	public void test3() {
		try {
			ClassPathXmlApplicationContext context=
			new ClassPathXmlApplicationContext(new String[]{"META-INF/applicationContext.xml"});
           IAdmin Metier =
        		   (IAdmin) context.getBean("metier");
           List<MarqueProd> marq1 = Metier.listmarques();
           Metier.ajouterMarque(new MarqueProd("Michlen"), 1L);
           Metier.ajouterMarque(new MarqueProd("Michlen"), 2L);
           List<MarqueProd> marq2 = Metier.listmarques();
           assertTrue(marq1.size()+2==marq2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(),false);
			}

	}

}
