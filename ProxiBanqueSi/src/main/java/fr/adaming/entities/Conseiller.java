package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
/**
 * 
 * @author Team Défonce Tout
 *
 */
@Entity
@Table(name="conseillers")
public class Conseiller implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_conseiller;
	private String nom;
	private String prenom;
	private String reference_conseiller;
	
	//Securite
	private Boolean activated = true;
	private int role_id = 1;
	

	@ManyToOne
	@JoinColumn(name="agence_id_fk", referencedColumnName="id_agence")
	private Agence pAgence;
	
	@OneToMany(mappedBy="pConseiller",fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Client> pListeClient;
	
	/**
	 * Ctor vide
	 */
	public Conseiller() {
		super();
	}
	
	/**
	 * Ctor sans id
	 * @param nom
	 * @param prenom
	 * @param reference_conseiller
	 */
	public Conseiller(String nom, String prenom, String reference_conseiller) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.reference_conseiller = reference_conseiller;
	}
	
	/**
	 * Ctor charge
	 * @param id_conseiller
	 * @param nom
	 * @param prenom
	 * @param reference_conseiller
	 */
	public Conseiller(int id_conseiller, String nom, String prenom, String reference_conseiller) {
		super();
		this.id_conseiller = id_conseiller;
		this.nom = nom;
		this.prenom = prenom;
		this.reference_conseiller = reference_conseiller;
	}
	
	
	/**
	 * @return the id_conseiller
	 */
	public int getId_conseiller() {
		return id_conseiller;
	}

	/**
	 * @param id_conseiller the id_conseiller to set
	 */
	public void setId_conseiller(int id_conseiller) {
		this.id_conseiller = id_conseiller;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the reference_conseiller
	 */
	public String getReference_conseiller() {
		return reference_conseiller;
	}

	/**
	 * @param reference_conseiller the reference_conseiller to set
	 */
	public void setReference_conseiller(String reference_conseiller) {
		this.reference_conseiller = reference_conseiller;
	}

	/**
	 * 
	 * @return object Agence linked to the Conseiller
	 */
	public Agence getpAgence() {
		return pAgence;
	}

	/**
	 * 
	 * @param pAgence Object Agence linked to the Conseiller
	 */
	public void setpAgence(Agence pAgence) {
		this.pAgence = pAgence;
	}

	/**
	 * @return the pListeClient
	 */
	public List<Client> getpListeClient() {
		return pListeClient;
	}

	/**
	 * @param pListeClient the pListeClient to set
	 */
	public void setpListeClient(List<Client> pListeClient) {
		this.pListeClient = pListeClient;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	

}
