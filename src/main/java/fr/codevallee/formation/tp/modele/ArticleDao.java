package fr.codevallee.formation.tp.modele;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ArticleDao {

	  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("facture");
	  private EntityManager entityManager;
	  
	  public ArticleDao() {
		  entityManager = emf.createEntityManager();
	  }
	  public Article create(Article article) {
		  entityManager.getTransaction().begin();
		  entityManager.persist(article);
		  entityManager.getTransaction().commit();
	    return article;
	  }
	  
	  public Collection<Article> listerArticles() {
		  System.out.println("query 1: ");
		  Query query = entityManager.createQuery("SELECT e FROM Article e");
		  System.out.println("query 2: " + query);
	    return (Collection<Article>) query.getResultList();
	  }
	  
	  public Article read(long idArticle) {
		  System.out.println("query 3: ");
		  System.out.println("idArticle 3: "+idArticle);
		  Query query = entityManager.createQuery("SELECT e FROM Article e where e.IdArticle = :idArt");
		  query.setParameter("idArt", idArticle);
		  System.out.println("query 4: " + query);
		  Article monarticle = new Article();
		  monarticle = (Article)query.getSingleResult();
		  System.out.println(monarticle);
	    return (Article) query.getSingleResult();
	    
//		  entityManager.getTransaction().begin();
//		  Article article = entityManager.find(Article.class, idArticle);
//		  System.out.println("article dao : "+article);
//	    entityManager.getTransaction().commit();
//	    return article;
	  }
	  
	
//	  public Utilisateur update(Utilisateur person) {
//		entityManager.getTransaction().begin();
//		Utilisateur existingPerson = entityManager.find(Utilisateur.class, person.getEmail());
////	    person = entityManager.merge(person);
//		
//		
//		
//		existingPerson.setAdresse(person.getAdresse());
//		existingPerson.setNom(person.getNom());
//		existingPerson.setPrenom(person.getPrenom());
//		existingPerson.setTelephone(person.getTelephone());
//	    entityManager.getTransaction().commit();
//	    return person;
//	  }
//	  public void delete(Utilisateur person) {
//		  entityManager.getTransaction().begin();
//		  entityManager.remove(person);
//		  entityManager.getTransaction().commit();
//	  }
	  public void close() {
	    emf.close();
	  }
}
