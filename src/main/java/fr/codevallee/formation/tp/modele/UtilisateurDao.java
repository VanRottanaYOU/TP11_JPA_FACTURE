package fr.codevallee.formation.tp.modele;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilisateurDao {

	  private EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");
	  private EntityManager entityManager;
	  
	  public UtilisateurDao() {
		  entityManager = emf.createEntityManager();
	  }
	  public Utilisateur create(Utilisateur person) {
		  entityManager.getTransaction().begin();
		  entityManager.persist(person);
		  entityManager.getTransaction().commit();
	    return person;
	  }
	  public Utilisateur read(String email) {
		  entityManager.getTransaction().begin();
		  Utilisateur person = entityManager.find(Utilisateur.class, email);
	    entityManager.getTransaction().commit();
	    return person;
	  }
	  public Utilisateur update(Utilisateur person) {
		entityManager.getTransaction().begin();
		Utilisateur existingPerson = entityManager.find(Utilisateur.class, person.getEmail());
//	    person = entityManager.merge(person);
		existingPerson.setAdresse(person.getAdresse());
		existingPerson.setNom(person.getNom());
		existingPerson.setPrenom(person.getPrenom());
		existingPerson.setTelephone(person.getTelephone());
	    entityManager.getTransaction().commit();
	    return person;
	  }
	  public void delete(Utilisateur person) {
		  entityManager.getTransaction().begin();
		  entityManager.remove(person);
		  entityManager.getTransaction().commit();
	  }
	  public void close() {
	    emf.close();
	  }
}
