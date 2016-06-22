package net.sid.uir.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class MarqueProd implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMarque;
	@NotEmpty
	private String nomMarque;
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie;
	public MarqueProd(String nomMarque) {
		super();
		this.nomMarque = nomMarque;
	}
	public MarqueProd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdMarque() {
		return idMarque;
	}
	public void setIdMarque(Long idMarque) {
		this.idMarque = idMarque;
	}
	public String getNomMarque() {
		return nomMarque;
	}
	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	

}
