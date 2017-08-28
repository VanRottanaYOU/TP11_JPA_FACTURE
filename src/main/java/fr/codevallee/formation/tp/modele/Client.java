package fr.codevallee.formation.tp.modele;

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
@Table(name = "client")

public class Client {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idClient;
	
	@Column(length=40)
    private String email;
	
	@Column(length=40)
	private String nom;
	
	@Column(length=40)
	private String prenom;
	
	@Column(length=40)
	private String age;
	
	@Column(length=40)
	private String telephone;

//	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE},orphanRemoval=true)
//	private Set<Facture> listFacture;
//		
//	@ManyToOne
//	private AdresseFacturation adresseFacturation;
//    
//	@ManyToOne
//    private AdresseLivraison adresseLivraison;

	@ManyToOne
    private Adresse adresse;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

//	public Set<Facture> getListFacture() {
//		return listFacture;
//	}
//
//	public void setListFacture(Set<Facture> listFacture) {
//		this.listFacture = listFacture;
//	}
//
//	public AdresseFacturation getAdresseFacturation() {
//		return adresseFacturation;
//	}
//
//	public void setAdresseFacturation(AdresseFacturation adresseFacturation) {
//		this.adresseFacturation = adresseFacturation;
//	}
//
//	public AdresseLivraison getAdresseLivraison() {
//		return adresseLivraison;
//	}
//
//	public void setAdresseLivraison(AdresseLivraison adresseLivraison) {
//		this.adresseLivraison = adresseLivraison;
//	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", age="
				+ age + ", telephone=" + telephone + "]";
	}

//	@Override
//	public String toString() {
//		return "Client [idClient=" + idClient + ", email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", age="
//				+ age + ", telephone=" + telephone + ", listFacture=" + listFacture + ", adresseFacturation="
//				+ adresseFacturation + ", adresseLivraison=" + adresseLivraison + "]";
//	}
    
	
	
}
