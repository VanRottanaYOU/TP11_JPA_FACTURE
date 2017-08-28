package fr.codevallee.formation.tp.modele;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@Table(name = "article")

public class Article {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long IdArticle;
	
	@Column(length=40)
	private String nom;
	
	@Column(length=40)
    private double prix;
	
	@ManyToOne
//	@JoinColumn(name = "description_id", nullable = false)
    private DescriptionArticle description;

	public long getIdArticle() {
		return IdArticle;
	}

	public void setIdArticle(long IdArticle) {
		this.IdArticle = IdArticle;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public DescriptionArticle getDescription() {
		return description;
	}

	public void setDescription(DescriptionArticle description) {
		this.description = description;
	}

	
	@Override
	public String toString() {
		return "Article [IdArticle=" + IdArticle + ", nom=" + nom + ", prix=" + prix +"]";
	}
	
	
}
