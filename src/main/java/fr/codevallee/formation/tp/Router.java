package fr.codevallee.formation.tp;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.PersistenceException;

import fr.codevallee.formation.tp.modele.*;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Router implements SparkApplication {

//	private UtilisateurDao monUtilisateur;
//	private Utilisateur newUtilisateur;
	private ArticleDao monArticleDao;
	private Article monArticle;
	private DescriptionDao maDescriptionDao;
	private DescriptionArticle maDescriptionArticle;
	private Client monClient;
	private ClientDao monClientDao;
	private AdresseDao monAdresseDao;
	private Adresse monAdresse;
	private FactureDao maFactureDao;
	private Facture maFacture;
	private LigneFactureDao maLigneFactureDao;
	private LigneFacture maLigneFacture;
	
//	private ClientDao monClient;
//	private Client newClient;
//	private AdresseDao monAdresse;
//	private Adresse monAdresseLivraison;
//	private Adresse monAdresseFacturation;
	
	public void init() {
		
		Spark.staticFileLocation("/public");
		final Logger logger = LoggerFactory.getLogger(Router.class);
			
		
		get("/", (request, response) -> {
//			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
			monArticleDao = new ArticleDao();
			monArticle = new Article();	
			
			maDescriptionDao = new DescriptionDao();
			maDescriptionArticle = new DescriptionArticle();
			
			monClientDao = new ClientDao();
			monClient = new Client();
			
			monAdresseDao = new AdresseDao();
			monAdresse = new Adresse();
			
			maFactureDao = new FactureDao();
			maFacture = new Facture();	
			
			maLigneFactureDao = new LigneFactureDao();
			maLigneFacture = new LigneFacture();					
			return new ModelAndView(attributes, "menu.ftl");
			
		}, new FreeMarkerEngine());
		
		get("/creationArticle", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "creationArticle.ftl");
		}, new FreeMarkerEngine());

		post("/affichageArticle", (request, response) -> {
				String nom = request.queryParams("nomArticle") != null ? request.queryParams("nomArticle") : "anonymous";
			    String prix = request.queryParams("prixArticle") != null ? request.queryParams("prixArticle") : "anonymous";
			    String description = request.queryParams("descriptionArticle") != null ? request.queryParams("descriptionArticle") : "anonymous";
			   
			    Map<String, Object> attributes = new HashMap<>();
				attributes.put("nomArticle", nom);
				attributes.put("prixArticle", prix);
				attributes.put("descriptionArticle", description);

				System.out.println("attributes :"+attributes);	

				try {
					maDescriptionArticle.setDescription(description);					
					Article article = new Article();
					article.setNom(nom);
					article.setPrix(Double.parseDouble(prix));
					maDescriptionArticle.addArticle(article);
					maDescriptionDao.create(maDescriptionArticle);
					attributes.put("article", article);
					return new ModelAndView(attributes, "affichageArticle.ftl");
				} catch (PersistenceException e) {
//					System.out.println(e.printStackTrace());
//					System.out.println(e.toString());
//					attributes.put("erreur", e.getMessage());
//					attributes.put("erreur", e.fillInStackTrace());
//					attributes.put("erreur", e.getCause().getCause());
//					attributes.put("erreur", e.getLocalizedMessage());
//					attributes.put("erreur", e.getStackTrace());
					attributes.put("erreur", "article déjà présent en base");					
					return new ModelAndView(attributes, "home.ftl");
				}	

		}, new FreeMarkerEngine());
		
		get("/listerArticles", (request, response) -> {
				System.out.println("monSetArticleaaaaaaaa");
				Map<String, Object> attributes = new HashMap<>();
			
				try {
					Collection<Article> monSetArticle = new HashSet<Article>();
					System.out.println("monSetArticle 1: " + monSetArticle);
					monSetArticle = monArticleDao.listerArticles();
					System.out.println("monSetArticle 2: " + monSetArticle);
					attributes.put("monSetArticle", monSetArticle);
					return new ModelAndView(attributes, "affichagelisteArticles.ftl");
				}catch (Exception e) {
					attributes.put("erreur", "articles non présent en base");					
					return new ModelAndView(attributes, "home.ftl");
				}
		}, new FreeMarkerEngine());
			
		get("/creationClient", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "creationClient.ftl");
		}, new FreeMarkerEngine());

			post("/affichageClient", (request, response) -> {
				String nom = request.queryParams("nomClient") != null ? request.queryParams("nomClient") : "anonymous";
			    String prenom = request.queryParams("prenomClient") != null ? request.queryParams("prenomClient") : "unknown";
			    String adresseLivraison = request.queryParams("adresseLivraisonClient") != null ? request.queryParams("adresseLivraisonClient") : "anonymous";
			    String adresseFacturation = request.queryParams("adresseFacturationClient") != null ? request.queryParams("adresseFacturationClient") : "anonymous";
			    String telephone = request.queryParams("telephoneClient") != null ? request.queryParams("telephoneClient") : "anonymous";
			    String email = request.queryParams("emailClient") != null ? request.queryParams("emailClient") : "anonymous";
			    String age = request.queryParams("ageClient") != null ? request.queryParams("ageClient") : "anonymous";
			    Map<String, Object> attributes = new HashMap<>();
				attributes.put("nomClient", nom);
				attributes.put("prenomClient", prenom);
				attributes.put("adresseLivraison", adresseLivraison);
				attributes.put("adresseFacturation", adresseFacturation);
				attributes.put("telephoneClient", telephone);
				attributes.put("emailClient", email);
				attributes.put("ageClient", age);
				System.out.println("attributes :"+attributes);	

				try {
					Client client = new Client();
					client.setNom(nom);
					client.setPrenom(prenom);
					client.setAge(age);
					client.setEmail(email);
					client.setTelephone(telephone);
					
					monAdresse.setAdresseLivraison(adresseLivraison);
					monAdresse.setAdresseFacturation(adresseFacturation);
					System.out.println("adresseLivraison  :" +adresseLivraison);
					System.out.println("adresseFacturation  :" +adresseFacturation);
					
					monAdresse.addClient(client);	
					System.out.println("monAdresse : " +monAdresse);
					monAdresseDao.create(monAdresse);
					System.out.println("client 1 : " + client);												
					attributes.put("client", client);
					return new ModelAndView(attributes, "affichageClient.ftl");
				} catch (PersistenceException e) {
					attributes.put("erreur", "utilisateur déjà présent en base");					
					return new ModelAndView(attributes, "home.ftl");
				}
			}, new FreeMarkerEngine());
					
		get("/listerClients", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
		
			try {
				Collection<Client> monSetClient = new HashSet<Client>();
				System.out.println("monSetClient 1: " + monSetClient);
				monSetClient = monClientDao.listerClients();
				System.out.println("monSetClient 2: " + monSetClient);
				attributes.put("monSetClient", monSetClient);
				return new ModelAndView(attributes, "affichagelisteClients.ftl");
			}catch (Exception e) {
				attributes.put("erreur", "clients non présent en base");					
				return new ModelAndView(attributes, "home.ftl");
			}
		}, new FreeMarkerEngine());
		
		get("/creationFacture", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "creationFacture.ftl");
		}, new FreeMarkerEngine());

			post("/affichageFacture", (request, response) -> {
				String idClient = request.queryParams("idClient") != null ? request.queryParams("idClient") : "anonymous";
			    String idArticle = request.queryParams("idArticle") != null ? request.queryParams("idArticle") : "unknown";
			    String quantiteArticle = request.queryParams("quantiteArticle") != null ? request.queryParams("quantiteArticle") : "anonymous";
			    Map<String, Object> attributes = new HashMap<>();
			    
				try {
					System.out.println("creationFacture");	
					Article article1 = new Article();
					article1 = monArticleDao.read(Long.parseLong(idArticle));
					System.out.println("article1 : " + article1);
					maLigneFacture.setArticle(article1);
					maLigneFacture.setQuantiteArticles(Integer.parseInt(quantiteArticle));
					maLigneFacture.setTotal(Integer.parseInt(quantiteArticle)*(article1.getPrix()));
					System.out.println("maLigneFacture : " + maLigneFacture);
					Client client = new Client();
					client = monClientDao.read(Long.parseLong(idClient));
					System.out.println("client 3:"+client);
					
					maFacture.setClient(client);
					maFacture.setDate(new java.util.Date());
//					Date maintenant = (Date) new java.util.Date(); 
//					DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//					String reportDate = df.format(maintenant);
//					attributes.put("reportDate", reportDate);
					maFacture.setStatus("Non payée");
					maFacture.addLigneFacture(maLigneFacture);
					maFacture.setTotal(maFacture.getTotalTTC());
					maFactureDao.create(maFacture);
					System.out.println("maFacture finale : " + maFacture);
					
					attributes.put("facture", maFacture);
					return new ModelAndView(attributes, "affichageFacture.ftl");
				} catch (PersistenceException e) {
					attributes.put("erreur", "erreur");					
					return new ModelAndView(attributes, "home.ftl");
				}finally {
					monAdresseDao.close();
				}
			}, new FreeMarkerEngine());
					
		get("/listerFactures", (request, response) -> {
//			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
		
			try {
				Collection<Facture> monSetFacture = new HashSet<Facture>();
				System.out.println("monSetFacture 1: " + monSetFacture);
				monSetFacture = maFactureDao.listerFactures();
				System.out.println("monSetFacture 2: " + monSetFacture);
				attributes.put("monSetFacture", monSetFacture);
				return new ModelAndView(attributes, "affichagelisteFactures.ftl");
			}catch (Exception e) {
				attributes.put("erreur", "Factures non présentes en base");					
				return new ModelAndView(attributes, "home.ftl");
			}
		}, new FreeMarkerEngine());
		
		get("/listerFactures2", (request, response) -> {
//			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
		
			try {
				Collection<Facture> monSetFacture = new HashSet<Facture>();
				System.out.println("monSetFacture 1: " + monSetFacture);
				monSetFacture = maFactureDao.listerFacturesImpayees();
				System.out.println("monSetFacture 2: " + monSetFacture);
				attributes.put("monSetFacture", monSetFacture);
				return new ModelAndView(attributes, "affichagelisteFactures.ftl");
			}catch (Exception e) {
				attributes.put("erreur", "Factures non présentes en base");					
				return new ModelAndView(attributes, "home.ftl");
			}
		}, new FreeMarkerEngine());
		
		get("/listerFactures3", (request, response) -> {
//			logger.debug("start");
			Map<String, Object> attributes = new HashMap<>();
		
			try {
				Collection<Facture> monSetFacture = new HashSet<Facture>();
				System.out.println("monSetFacture 1: " + monSetFacture);
				monSetFacture = maFactureDao.listerFacturesMontant(500.00);
				System.out.println("monSetFacture 2: " + monSetFacture);
				attributes.put("monSetFacture", monSetFacture);
				return new ModelAndView(attributes, "affichagelisteFactures.ftl");
			}catch (Exception e) {
				attributes.put("erreur", "Factures non présentes en base");					
				return new ModelAndView(attributes, "home.ftl");
			}
		}, new FreeMarkerEngine());
		
		
		get("/paiementFacture", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			return new ModelAndView(attributes, "paiementFacture.ftl");
		}, new FreeMarkerEngine());

			post("/affichagePaiementFacture", (request, response) -> {
				String idFacture = request.queryParams("idFacture") != null ? request.queryParams("idFacture") : "anonymous";			   
				Map<String, Object> attributes = new HashMap<>();
				try {
					System.out.println("paimentFacture");	
					Facture facture = new Facture();
					facture = maFactureDao.read(Long.parseLong(idFacture));
//					facture.setStatus("Payée");
					maFactureDao.update(facture);
					attributes.put("facture",facture);
					return new ModelAndView(attributes, "affichageFacture.ftl");
				} catch (PersistenceException e) {
					attributes.put("erreur", "utilisateur déjà présent en base");					
					return new ModelAndView(attributes, "home.ftl");
				}
			}, new FreeMarkerEngine());
			
		get("/supprimerFacture", (request, response) -> {
				Map<String, Object> attributes = new HashMap<>();
				return new ModelAndView(attributes, "supprimerFacture.ftl");
			}, new FreeMarkerEngine());

				post("/suppressionFacture", (request, response) -> {
					String idFacture = request.queryParams("idFacture") != null ? request.queryParams("idFacture") : "anonymous";			   
					Map<String, Object> attributes = new HashMap<>();
					try {
						System.out.println("paimentFacture");	
						Facture facture = new Facture();
						facture = maFactureDao.read(Long.parseLong(idFacture));
						maFactureDao.delete(facture);
						attributes.put("facture",facture);					
						return new ModelAndView(attributes, "suppressionFacture.ftl");
					} catch (PersistenceException e) {
						attributes.put("erreur", "facture absente en base");					
						return new ModelAndView(attributes, "home.ftl");
					}
		}, new FreeMarkerEngine());
		
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










