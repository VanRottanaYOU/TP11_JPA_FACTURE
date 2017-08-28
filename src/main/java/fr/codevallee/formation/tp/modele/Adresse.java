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
@Table(name = "adresse")

public class Adresse {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=200)
    private String adresseLivraison;

	@Column(length=200)
    private String adresseFacturation;
	
//	@OneToMany(mappedBy="adresseLivraison")
//	private Set<Client> client;

	@OneToMany(mappedBy="adresse",cascade = { CascadeType.ALL })
	private Set<Client> listeclients = new HashSet<Client>();;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(String adresse) {
		this.adresseLivraison = adresse;
	}
	
	public String getAdresseFacturation() {
		return adresseFacturation;
	}
	
	public void setAdresseFacturation(String adresse) {
		this.adresseFacturation = adresse;
	}

	public void addClient(Client client) {
		listeclients.add(client);
		client.setAdresse(this);
    }

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", adresseLivraison=" + adresseLivraison + ", adresseFacturation="
				+ adresseFacturation + ", listeclients=" + listeclients + "]";
	}
	
//	public Set<Client> getClient() {
//		return client;
//	}
//
//	public void setClient(Set<Client> client) {
//		this.client = client;
//	}
	
	
				 	
}
