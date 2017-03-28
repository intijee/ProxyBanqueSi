package fr.adaming.entities;
import java.io.Serializable;
import java.util.Date;

/**
 * Classe représentant l'agence et encapsulant les informations de son gérant
 * @author inti0226
 *
 */
public class Agence implements Serializable {
	
	
	
	/**
	 * Implemente serializable
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String reference_agence;
	
	private Date date_creation;
	
	private String nom_gerant;
	
	private String reference_gerant;
	
	private String password_gerant;

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
		this.id = id;
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
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	
	

	
	

}
