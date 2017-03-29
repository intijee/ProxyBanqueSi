package fr.adaming.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Classe représentant l'agence et encapsulant les informations de son gérant
 * @author inti0226
 *
 */
@Entity
@Table(name = "agences")
public class Agence implements Serializable {
	
	
	
	/**
	 * Implemente serializable
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_agence;
	@Column(name="reference_agence")
	private String reference_agence;
	@Column(name="date_creation")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date date_creation;
	@Column(name="nom_gerant")
	private String nom_gerant;
	@Column(name="reference_gerant")
	private String reference_gerant;
	@Column(name="password_gerant")
	private String password_gerant;

	/***
	 * déclaration de l'association 
	 */
	@OneToMany(mappedBy="pAgence",fetch=FetchType.LAZY,cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	// Cascade pour la propagation des operations
	private List<Conseiller> pConseiller;
	
	public List<Conseiller> getpConseiller() {
		return pConseiller;
	}

	public void setpConseiller(List<Conseiller> pConseiller) {
		this.pConseiller = pConseiller;
	}

	/**
	 * Constructeur vide
	 */
	public Agence() {
		super();
	}

	/**
	 * Constructeur avec paramètre sans id
	 * @param reference_agence
	 * @param date_creation
	 * @param nom_gerant
	 * @param reference_gerant
	 * @param password_gerant
	 */
	public Agence(String reference_agence, Date date_creation, String nom_gerant, String reference_gerant,
			String password_gerant) {
		super();
		this.reference_agence = reference_agence;
		this.date_creation = date_creation;
		this.nom_gerant = nom_gerant;
		this.reference_gerant = reference_gerant;
		this.password_gerant = password_gerant;
	}

	/**
	 * Constructeur avec paramètre et avec id
	 * @param id
	 * @param reference_agence
	 * @param date_creation
	 * @param nom_gerant
	 * @param reference_gerant
	 * @param password_gerant
	 */
	public Agence(int id, String reference_agence, Date date_creation, String nom_gerant, String reference_gerant,
			String password_gerant) {
		super();
		this.id_agence = id;
		this.reference_agence = reference_agence;
		this.date_creation = date_creation;
		this.nom_gerant = nom_gerant;
		this.reference_gerant = reference_gerant;
		this.password_gerant = password_gerant;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id_agence;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id_agence = id;
	}

	/**
	 * @return the reference_agence
	 */
	public String getReference_agence() {
		return reference_agence;
	}

	/**
	 * @param reference_agence the reference_agence to set
	 */
	public void setReference_agence(String reference_agence) {
		this.reference_agence = reference_agence;
	}

	/**
	 * @return the date_creation
	 */
	public Date getDate_creation() {
		return date_creation;
	}

	/**
	 * @param date_creation the date_creation to set
	 */
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	/**
	 * @return the nom_gerant
	 */
	public String getNom_gerant() {
		return nom_gerant;
	}

	/**
	 * @param nom_gerant the nom_gerant to set
	 */
	public void setNom_gerant(String nom_gerant) {
		this.nom_gerant = nom_gerant;
	}

	/**
	 * @return the reference_gerant
	 */
	public String getReference_gerant() {
		return reference_gerant;
	}

	/**
	 * @param reference_gerant the reference_gerant to set
	 */
	public void setReference_gerant(String reference_gerant) {
		this.reference_gerant = reference_gerant;
	}

	/**
	 * @return the password_gerant
	 */
	public String getPassword_gerant() {
		return password_gerant;
	}

	/**
	 * @param password_gerant the password_gerant to set
	 */
	public void setPassword_gerant(String password_gerant) {
		this.password_gerant = password_gerant;
	}

	
	
	@Override
	public String toString() {
		return "Agence [id=" + id_agence + ", reference_agence=" + reference_agence + ", date_creation=" + date_creation
				+ ", nom_gerant=" + nom_gerant + ", reference_gerant=" + reference_gerant + ", password_gerant="
				+ password_gerant + "]";
	}
	
	

	
	

}
