package net.sid.uir.controllers;

import java.awt.PageAttributes.MediaType;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.hibernate.id.IdentityGenerator.GetGeneratedKeysDelegate;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import net.sid.uir.entities.Categorie;
import net.sid.uir.entities.Produit;
import net.sid.uir.metier.IAdmin;

@Controller
@RequestMapping(value="/admin")
public class AdminController implements HandlerExceptionResolver{
	@Autowired
   private IAdmin metier;
@RequestMapping(value="/index")
	public String indexC(Model model){
	model.addAttribute("categorie",new Categorie());
	model.addAttribute("categories",metier.listCategories());
	return "categories";
}

@RequestMapping(value="/index/produit")
public String indexP(Model model){
model.addAttribute("produit",new Produit());
model.addAttribute("produits",metier.listproduits());
return "produits";
}

@RequestMapping(value="/saveCat")
	public String saveCat(Categorie c,BindingResult bindingResult, Model model,MultipartFile file ) throws IOException{
		if(bindingResult.hasErrors()) {
			model.addAttribute("categorie",new Categorie());
			model.addAttribute("categories",metier.listCategories());
			return("categories");	
	}
		if(!file.isEmpty()){
			BufferedImage bi =ImageIO.read(file.getInputStream());
			c.setPhoto(file.getBytes());
            c.setNomPhoto(file.getOriginalFilename());
		}
			if(c.getIdCategorie()!=null){
				if(!file.isEmpty()){
				Categorie cat=metier.getCategorie(c.getIdCategorie());
			metier.modifierCategorie(c);
			}
		}
		else
		metier.ajouterCategorie(c);
		model.addAttribute("categorie",new Categorie());
		model.addAttribute("categories",metier.listCategories());
		return "categories";
	}



@RequestMapping(value="/saveProd")
public String saveProd(Produit p,BindingResult bindingResult, Model model,MultipartFile file ) throws IOException{
	if(bindingResult.hasErrors()) {
		model.addAttribute("produits",metier.listCategories());
		model.addAttribute("categories",metier.listCategories());
		return("produits");	
}
	
	if(!file.isEmpty()){
		String path =System.getProperty("java.io.tmpdir");
		p.setPhoto(file.getOriginalFilename());
		Long idP;
		if(p.getIdProduit()==null)
		{
	    idP=metier.ajouterProduit(p,p.getCategorie().getIdCategorie());
		}else{
			metier.modifierProduit(p);
			idP=p.getIdProduit();
		}
	    file.transferTo(new File(path+"/"+"PROD_"+idP+"_"+file.getOriginalFilename()));
	}else{
		if(p.getIdProduit()==null)
		metier.ajouterProduit(p,p.getCategorie().getIdCategorie());
		else metier.modifierProduit(p);

	}
	model.addAttribute("produit",new Produit());
	model.addAttribute("produits",metier.listproduits());
	model.addAttribute("categories",metier.listCategories());

	return "produits";
}





@RequestMapping(value="/photoCat",produces=org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
@ResponseBody
public byte[] getPhotoC(Long idCat) throws IOException{ Categorie c=metier.getCategorie(idCat); if(c.getPhoto()==null) return new byte[0];
else return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
}


@RequestMapping(value="/photoProd",produces=org.springframework.http.MediaType.IMAGE_JPEG_VALUE)
@ResponseBody
public byte[] getPhotoP(Long idProd) throws IOException{ 
	Produit p=metier.getProduit(idProd); 
	File f= new File(System.getProperty("java.io.tmpdir")+"/PROD_"+idProd+"_"+p.getPhoto());
 return IOUtils.toByteArray(new FileInputStream(f));
}





@RequestMapping(value="/supCat")
public String SupCat(Long idCat,Model model){
	metier.supprimerCategorie(idCat);
model.addAttribute("categorie",new Categorie());
model.addAttribute("categories",metier.listCategories());
return "categories";
}


@RequestMapping(value="/supProd")
public String SupProd(Long idProd,Model model){
	metier.supprimerProduit(idProd);
model.addAttribute("produit",new Categorie());
model.addAttribute("produits",metier.listproduits());
model.addAttribute("categories",metier.listCategories());
return "produits";
}





@RequestMapping(value="/editCat")
public String editCat(Long idCat,Model model){
	Categorie c=metier.getCategorie(idCat);

model.addAttribute("categorie",c);
model.addAttribute("categories",metier.listCategories());
return "categories";
//return "Admin";
}


@RequestMapping(value="/editProd")
public String editProd(Long idProd,Model model){
	Produit p=metier.getProduit(idProd);

model.addAttribute("produit",p);
model.addAttribute("produits",metier.listproduits());
return "produits";
//return "Admin";
}


@Override
public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object, Exception exp) {
	// TODO Auto-generated method stub
	ModelAndView mv = new ModelAndView();
	mv.addObject("exception", exp.getMessage());
	mv.setViewName("categorie");
	return mv;
}

	
}
