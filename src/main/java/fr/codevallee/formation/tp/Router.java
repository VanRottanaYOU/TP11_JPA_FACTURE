package fr.codevallee.formation.tp;

import static spark.Spark.get;
import static spark.Spark.post;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import fr.codevallee.formation.tp.modele.Demo;
import fr.codevallee.formation.tp.modele.Utilisateur;
import fr.codevallee.formation.tp.modele.UtilisateurDao;
import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.Spark;
import spark.servlet.SparkApplication;
import spark.template.freemarker.FreeMarkerEngine;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;

public class Router implements SparkApplication {

	private UtilisateurDao monUtilisateur;
	private Utilisateur newUtilisateur;
	public void init() {
		
		Spark.staticFileLocation("/public");
		final Logger logger = LoggerFactory.getLogger(Router.class);

		get("/", (request, response) -> {
			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
			monUtilisateur = new UtilisateurDao();	
			newUtilisateur =new Utilisateur();
			return new ModelAndView(attributes, "menu.ftl");
			
		}, getFreeMarkerEngine());
		
		get("/creationUtilisateur", (request, response) -> {
			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "creationUtilisateur.ftl");
		}, getFreeMarkerEngine());

			post("/affichageUtilisateur", (request, response) -> {
				logger.debug("start");
				String nom = request.queryParams("nomUtilisateur") != null ? request.queryParams("nomUtilisateur") : "anonymous";
			    String prenom = request.queryParams("prenomUtilisateur") != null ? request.queryParams("prenomUtilisateur") : "unknown";
			    String adresse = request.queryParams("adresseUtilisateur") != null ? request.queryParams("adresseUtilisateur") : "anonymous";
			    String telephone = request.queryParams("telephoneUtilisateur") != null ? request.queryParams("telephoneUtilisateur") : "anonymous";
			    String email = request.queryParams("emailUtilisateur") != null ? request.queryParams("emailUtilisateur") : "anonymous";
			    Map<String, Object> attributes = new HashMap<>();
				attributes.put("nomUtilisateur", nom);
				attributes.put("prenomUtilisateur", prenom);
				attributes.put("adresseUtilisateur", adresse);
				attributes.put("telephoneUtilisateur", telephone);
				attributes.put("emailUtilisateur", email);
				monUtilisateur = new UtilisateurDao();	
				newUtilisateur =new Utilisateur();
				newUtilisateur.setAdresse(adresse);
				newUtilisateur.setEmail(email);
				newUtilisateur.setNom(nom);
				newUtilisateur.setPrenom(prenom);
				newUtilisateur.setTelephone(telephone);
				try {
					monUtilisateur.create(newUtilisateur);
					attributes.put("utilisateur", newUtilisateur);
					return new ModelAndView(attributes, "affichageUtilisateur2.ftl");
				} catch (PersistenceException e) {
//					System.out.println(e.printStackTrace());
//					System.out.println(e.toString());
//					attributes.put("erreur", e.getMessage());
//					attributes.put("erreur", e.fillInStackTrace());
//					attributes.put("erreur", e.getCause());
//					attributes.put("erreur", e.getLocalizedMessage());
//					attributes.put("erreur", e.getStackTrace());
					attributes.put("erreur", "utilisateur déjà présent en base");					
					return new ModelAndView(attributes, "home.ftl");
				}
			}, getFreeMarkerEngine());
		

		get("/chercherUtilisateur", (request, response) -> {
			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "chercherUtilisateur.ftl");
		}, getFreeMarkerEngine());

		post("/chercher", (request, response) -> {
			logger.debug("start");
			String email = request.queryParams("emailUtilisateur") != null ? request.queryParams("emailUtilisateur") : "anonymous";
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("emailUtilisateur", email);
			UtilisateurDao monUtilisateur = new UtilisateurDao();		
			Utilisateur newUtilisateur = new Utilisateur();
			try {
				newUtilisateur = monUtilisateur.read(email);
				attributes.put("nomUtilisateur", newUtilisateur.getNom());
				attributes.put("prenomUtilisateur", newUtilisateur.getPrenom());
				attributes.put("adresseUtilisateur", newUtilisateur.getAdresse());
				attributes.put("telephoneUtilisateur", newUtilisateur.getTelephone());
				attributes.put("emailUtilisateur", newUtilisateur.getEmail());
				attributes.put("utilisateur", newUtilisateur);
				return new ModelAndView(attributes, "affichageUtilisateur2.ftl");
			}catch (Exception e) {
				attributes.put("erreur", "utilisateur non présent en base");					
				return new ModelAndView(attributes, "home.ftl");
			}
		}, getFreeMarkerEngine());
		
		get("/modifierUtilisateur", (request, response) -> {
			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "modifierUtilisateur.ftl");
		}, getFreeMarkerEngine());
		
		post("/modification", (request, response) -> {
			logger.debug("start");
			String nom = request.queryParams("nomUtilisateur") != null ? request.queryParams("nomUtilisateur") : "anonymous";
            String prenom = request.queryParams("prenomUtilisateur") != null ? request.queryParams("prenomUtilisateur") : "unknown";
            String adresse = request.queryParams("adresseUtilisateur") != null ? request.queryParams("adresseUtilisateur") : "anonymous";
            String telephone = request.queryParams("telephoneUtilisateur") != null ? request.queryParams("telephoneUtilisateur") : "anonymous";
            String email = request.queryParams("emailUtilisateur") != null ? request.queryParams("emailUtilisateur") : "anonymous";
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("nomUtilisateur", nom);
			attributes.put("prenomUtilisateur", prenom);
			attributes.put("adresseUtilisateur", adresse);
			attributes.put("telephoneUtilisateur", telephone);
			attributes.put("emailUtilisateur", email);
			monUtilisateur = new UtilisateurDao();	
			newUtilisateur =new Utilisateur();
			newUtilisateur.setAdresse(adresse);
			newUtilisateur.setEmail(email);
			newUtilisateur.setNom(nom);
			newUtilisateur.setPrenom(prenom);
			newUtilisateur.setTelephone(telephone);
//			UtilisateurDao monUtilisateur = new UtilisateurDao();
			try {
				monUtilisateur.update(newUtilisateur);
				attributes.put("utilisateur", newUtilisateur);
				return new ModelAndView(attributes, "affichageUtilisateur2.ftl");
			}catch (Exception e) {
				attributes.put("erreur", "utilisateur non présent en base");					
				return new ModelAndView(attributes, "home.ftl");
			}
		}, getFreeMarkerEngine());
		
		get("/supprimerUtilisateur", (request, response) -> {
			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "supprimerUtilisateur.ftl");
		}, getFreeMarkerEngine());
		
		post("/suppression", (request, response) -> {
			logger.debug("start");
			String email = request.queryParams("emailUtilisateur") != null ? request.queryParams("emailUtilisateur") : "anonymous";
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("emailUtilisateur", email);
			UtilisateurDao monUtilisateur = new UtilisateurDao();
			
			Utilisateur newUtilisateur = monUtilisateur.read(email);
			try {
				monUtilisateur.delete(newUtilisateur);
				return new ModelAndView(attributes, "menu.ftl");
			}catch (Exception e) {
				attributes.put("erreur", "utilisateur non présent en base");					
				return new ModelAndView(attributes, "home.ftl");
			}
		}, getFreeMarkerEngine());

	}

	private FreeMarkerEngine getFreeMarkerEngine() {
		FreeMarkerEngine engine = new FreeMarkerEngine();
		Configuration configuration = new Configuration(new Version(2, 3, 23));
		configuration.setTemplateUpdateDelayMilliseconds(Long.MAX_VALUE);
		configuration.setClassForTemplateLoading(FreeMarkerEngine.class, "");
		engine.setConfiguration(configuration);
		return engine;
	}

}










