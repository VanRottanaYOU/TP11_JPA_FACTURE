package fr.codevallee.formation.tp.modele;

import java.util.Collection;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class LigneFactureDao {

	  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("facture");
	  private EntityManager entityManager;
	  
	  public LigneFactureDao() {
		  entityManager = emf.createEntityManager();
	  }
	  public LigneFacture create(LigneFacture ligneFacture) {
		  entityManager.getTransaction().begin();
		  entityManager.persist(ligneFacture);
		  entityManager.getTransaction().commit();
	    return ligneFacture;
	  }
	  
	  public Collection<LigneFacture> listerLigneFactures() {
		  System.out.println("query 1: ");
		  Query query = entityManager.createQuery("SELECT e FROM LigneFacture e");
		  System.out.println("query 2: " + query);
	    return (Collection<LigneFacture>) query.getResultList();
	  }
	  
	  public void close() {
	    emf.close();
	  }
}
