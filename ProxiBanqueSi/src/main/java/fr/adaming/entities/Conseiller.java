package fr.adaming.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
	

	@ManyToOne
	@JoinColumn(name="agence_id_fk", referencedColumnName="id_agence")
	private Agence pAgence;
	
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

	
}
