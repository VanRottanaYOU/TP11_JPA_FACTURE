package fr.codevallee.formation.tp.modele;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@Table(name = "descriptionArticle")

public class DescriptionArticle {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(length=200)
    private String description;

	@OneToMany(mappedBy="description",cascade = { CascadeType.ALL })
	private Set<Article> articles = new HashSet<Article>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	} 
	
	public void addArticle(Article article) {
        articles.add(article);
        article.setDescription(this);
    }

	@Override
	public String toString() {
		return "DescriptionArticle [id=" + id + ", description=" + description + ", articles=" + articles + "]";
	}

	
	
	
}
