package fr.codevallee.formation.tp.modele;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.annotations.SQLInsert;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Table(name = "lignefacture")
//@SQLInsert( sql="INSERT INTO lignefacture(total) VALUES(article.prix * QuantiteArticles)")
public class LigneFacture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
    private Article article;
	
	@Column(length=40)
	private int quantiteArticles;
	
	@Column(length=40)
    private double total;
    
	@ManyToOne
	private Facture facture;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantiteArticles() {
		return quantiteArticles;
	}

	public void setQuantiteArticles(int quantiteArticles) {
		this.quantiteArticles = quantiteArticles;
	}

	public double getPrixUnitaire() {
		return article.getPrix();
	}

	public double getTotal() {
		return quantiteArticles * getPrixUnitaire();
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	@Override
	public String toString() {
		return "LigneFacture [id=" + id + ", article=" + article + ", quantiteArticles=" + quantiteArticles + ", total="
				+ total + ", facture=" + facture + "]";
	}

	
	
}
