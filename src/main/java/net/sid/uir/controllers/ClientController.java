package net.sid.uir.controllers;

import java.awt.PageAttributes.MediaType;
import java.io.FileInputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.sid.uir.entities.Panier;
import net.sid.uir.entities.Produit;
import net.sid.uir.metier.IClient;

@Controller
@SessionAttributes("panier")
public class ClientController {

	@Autowired
	private IClient metier;
	@RequestMapping("/index")
	public String index(Model model){ if(model.asMap().get("panier")==null){ model.addAttribute("panier", new Panier());
	}
	model.addAttribute("categories", metier.listCategories()); 
	model.addAttribute("produits", metier.produitsSelectionnes()); 
	return "index";
	}
	
	
	@RequestMapping("/produitsParCat")
	public String produitsParCat(@RequestParam Long idCat,Model model){
	model.addAttribute("categories", metier.listCategories());
	model.addAttribute("produits", metier.produitsParCategorie(idCat));
	return "index";
	}
	
	@RequestMapping("/chercherProduits")
	public String chercherProduits(@RequestParam String mc,Model model){
	model.addAttribute("mc",mc); model.addAttribute("categories", metier.listCategories());
	model.addAttribute("produits", metier.produitsParMotCle(mc));
	return "index";
	}

	@RequestMapping(value="/photoProduit",produces=org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoProd(@RequestParam("idP")Long idP) throws Exception{
	Produit p=metier.getProduit(idP);
	String
	path=System.getProperty("java.io.tmpdir")+"/"+p.getIdProduit(); return IOUtils.toByteArray(new FileInputStream(path));
	}

	
	@RequestMapping("/ajouterAuPanier")
	public String chercherProduits(@RequestParam Long idProduit,@RequestParam int quantite,Model model){
	Panier panier=null; if(model.asMap().get("panier")==null){ panier=new Panier(); model.addAttribute("panier", panier);
	}
	else
	panier=(Panier) model.asMap().get("panier"); 
	panier.addArticle(metier.getProduit(idProduit), quantite); 
	model.addAttribute("categories", metier.listCategories()); 
	model.addAttribute("produits", metier.produitsSelectionnes()); 
	return "index";
	}
	}

	

