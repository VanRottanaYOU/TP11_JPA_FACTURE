package fr.codevallee.formation.tp.modele;

import java.util.Collection;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ClientDao {

	  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("facture");
	  private EntityManager entityManager;
	  
	  public ClientDao() {
		  entityManager = emf.createEntityManager();
	  }
	  public Client create(Client client) {
		  entityManager.getTransaction().begin();
		  entityManager.persist(client);
		  entityManager.getTransaction().commit();
	    return client;
	  }
	  
	  public Collection<Client> listerClients() {
		  System.out.println("query 1: ");
		  Query query = entityManager.createQuery("SELECT e FROM Client e");
		  System.out.println("query 2: " + query);
	    return (Collection<Client>) query.getResultList();
	  }
	  
	  public Client read(long idClient) {
		  entityManager.getTransaction().begin();
		  Client person = entityManager.find(Client.class, idClient);
	    entityManager.getTransaction().commit();
	    return person;
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
