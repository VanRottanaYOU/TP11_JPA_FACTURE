package fr.codevallee.formation.tp.modele;


import java.util.Date;
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
@Table(name = "Facture")
//@SQLInsert( sql="INSERT INTO Facture(total) VALUES(article.prix * QuantiteArticles)")
public class Facture {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idFacture;
	
	@ManyToOne
    private Client client;
		
//	@ManyToOne
//	private Adresse adresseLivraison;
	
	@Column(length=10)
    private Date date;
    
	@Column(length=20)
    private String status;
    
	@OneToMany(mappedBy="facture",cascade = { CascadeType.ALL })
	private Set<LigneFacture> LignesFacture = new HashSet<LigneFacture>();
	
	@Column(length=40)
    private double total;

	public Long getId() {
		return idFacture;
	}

	public void setId(Long id) {
		this.idFacture = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

//	public Adresse getAdresseLivraison() {
//		return adresseLivraison;
//	}
//
//	public void setAdresseLivraison(Adresse adresseLivraison) {
//		this.adresseLivraison = adresseLivraison;
//	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<LigneFacture> getLignes() {
		return LignesFacture;
	}

	public void setLignes(Set<LigneFacture> lignes) {
		LignesFacture = lignes;
	}

	public double getTotalTTC() {
//		double total = 0;
//		for (Ligne ligne : lignes) {
//			total += ligne.getTotal();
//		}
//		return total;
		return LignesFacture
				.stream()
				.mapToDouble(LigneFacture::getTotal)
				.sum();
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public void addLigneFacture(LigneFacture ligneFacture) {
		LignesFacture.add(ligneFacture);
		ligneFacture.setFacture(this);
    }
  
}
