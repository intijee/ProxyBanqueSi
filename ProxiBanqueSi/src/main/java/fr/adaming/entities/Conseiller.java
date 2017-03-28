package fr.adaming.entities;

import java.io.Serializable;

public class Conseiller implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Attributs
	private int id_conseiller;
	private String nom;
	private String prenom;
	private long reference_conseiller;
	
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
	public Conseiller(String nom, String prenom, long reference_conseiller) {
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
	public Conseiller(int id_conseiller, String nom, String prenom, long reference_conseiller) {
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
	public long getReference_conseiller() {
		return reference_conseiller;
	}

	/**
	 * @param reference_conseiller the reference_conseiller to set
	 */
	public void setReference_conseiller(long reference_conseiller) {
		this.reference_conseiller = reference_conseiller;
	}

	@Override
	public String toString() {
		return "Conseiller [id_conseiller=" + id_conseiller + ", nom=" + nom + ", prenom=" + prenom
				+ ", reference_conseiller=" + reference_conseiller + "]";
	}
	
	
	
}
