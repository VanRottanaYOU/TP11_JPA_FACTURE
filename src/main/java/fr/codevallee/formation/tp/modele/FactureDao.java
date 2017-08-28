package fr.codevallee.formation.tp.modele;

import java.util.Collection;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class FactureDao {

	  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("facture");
	  private EntityManager entityManager;
	  
	  public FactureDao() {
		  entityManager = emf.createEntityManager();
	  }
	  public Facture create(Facture facture) {
		  entityManager.getTransaction().begin();
		  entityManager.persist(facture);
		  entityManager.getTransaction().commit();
	    return facture;
	  }
	  
	  public Collection<Facture> listerFactures() {
		  System.out.println("query 1: ");
		  Query query = entityManager.createQuery("SELECT e FROM Facture e");
		  System.out.println("query 2: " + query);
	    return (Collection<Facture>) query.getResultList();
	  }
	  
	  public Facture read(long idFacture) {
		  System.out.println("query 3: ");
		  System.out.println("idArticle 3: "+idFacture);
		  Query query = entityManager.createQuery("SELECT e FROM Facture e where e.IdArticle = :idFacture");
		  query.setParameter("idFacture", idFacture);
		  System.out.println("query 4: " + query);
		  Facture maFacture = new Facture();
		  maFacture = (Facture)query.getSingleResult();
		  System.out.println(maFacture);
	    return (Facture) query.getSingleResult();
	    
//		  entityManager.getTransaction().begin();
//		  Article article = entityManager.find(Article.class, idArticle);
//		  System.out.println("article dao : "+article);
//	    entityManager.getTransaction().commit();
//	    return article;
	  }
	  
	  public Facture update(Facture facture) {
		  System.out.println("query 5: ");
		entityManager.getTransaction().begin();
		Facture existingFacture = entityManager.find(Facture.class, facture.getId());
		System.out.println("query 6: ");
		existingFacture.setStatus("Payée");
	    entityManager.getTransaction().commit();
	    return existingFacture;
	  }
	  
	  public void close() {
	    emf.close();
	  }
}
