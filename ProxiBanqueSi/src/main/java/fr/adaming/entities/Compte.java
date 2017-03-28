package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * nom de la table 
 * @author inti0277
 *
 */
@Entity
@Table(name = "comptes")
public class Compte implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * attributs de la classe compte
	 */
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_compte;
	@Column(name="numero")
	private long numero;
	@Column(name="solde")
	private double solde;
	@Column(name="date_ouverture")
	private Date date_ouverture;

	/**
	 * attribut de compte épargne
	 */
	@Column(name="taux")
	private long taux;

	/**
	 * attribut de compte courant
	 */
	@Column(name="decouvert")
	private double decouvert;

	/**
	 * booléen : épargne (1) ou courant (0)
	 */
	@Column(name="type")
	private boolean type;
	
	/**
	 * Attribut transient qui sert à transporter les informations du client
	 */
	@Transient
	private int numero_client;

	/**
	 * déclaration de l'association avec le client
	 */
	@ManyToOne
	@JoinColumn(name="client_id_fk",referencedColumnName="id_client")
	private Client pclient;
	
	/**
	 * constructeur compte générique
	 */
	/**
	 * /** constructeur avec id
	 * 
	 * @param id_compte
	 * @param numero
	 * @param solde
	 * @param date_ouverture
	 */
	public Compte(int id_compte, long numero, double solde, Date date_ouverture,int numero_client) {
		super();
		this.id_compte = id_compte;
		this.numero = numero;
		this.solde = solde;
		this.date_ouverture = date_ouverture;
		this.numero_client=numero_client;
	}

	/**
	 * constructeur sans id
	 * 
	 * @param numero
	 * @param solde
	 * @param date_ouverture
	 */
	public Compte(long numero, double solde, Date date_ouverture,int numero_client) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.date_ouverture = date_ouverture;
		this.numero_client=numero_client;
	}

	/**
	 * constructeur vide
	 */
	public Compte() {
		super();
	}

	/**
	 * constructeur compte courant
	 */
	/**
	 * constructeur avec id
	 * 
	 * @param id_compte
	 * @param numero
	 * @param solde
	 * @param date_ouverture
	 * @param decouvert
	 * @param type
	 */
	public Compte(int id_compte, long numero, double solde, Date date_ouverture, double decouvert, boolean type,int numero_client) {
		super();
		this.id_compte = id_compte;
		this.numero = numero;
		this.solde = solde;
		this.date_ouverture = date_ouverture;
		this.decouvert = decouvert;
		this.type = type;
		this.numero_client=numero_client;
	}

	/**
	 * constructeur sans id
	 * 
	 * @param numero
	 * @param solde
	 * @param date_ouverture
	 * @param decouvert
	 * @param type
	 */
	public Compte(long numero, double solde, Date date_ouverture, double decouvert, boolean type,int numero_client) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.date_ouverture = date_ouverture;
		this.decouvert = decouvert;
		this.type = type;
		this.numero_client=numero_client;
	}

	/**
	 * constructeur compte epargne
	 */
	/**
	 * constructeur compte epargne sans id
	 * 
	 * @param numero
	 * @param solde
	 * @param date_ouverture
	 * @param taux
	 */
	public Compte(int id_compte, long numero, double solde, Date date_ouverture, long taux, boolean type,int numero_client) {
		super();
		this.id_compte = id_compte;
		this.numero = numero;
		this.solde = solde;
		this.date_ouverture = date_ouverture;
		this.taux = taux;
		this.type = type;
		this.numero_client=numero_client;
	}

	/**
	 * constructeur compte epargne avec id
	 */
	public Compte(long numero, double solde, Date date_ouverture, long taux, boolean type,int numero_client) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.date_ouverture = date_ouverture;
		this.taux = taux;
		this.type = type;
		this.numero_client=numero_client;
	}

	/**
	 * @return the id_compte
	 */
	public int getId_compte() {
		return id_compte;
	}

	/**
	 * @param id_compte
	 *            the id_compte to set
	 */
	public void setId_compte(int id_compte) {
		this.id_compte = id_compte;
	}

	/**
	 * @return the numero
	 */
	public long getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(long numero) {
		this.numero = numero;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 *            the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * @return the date_ouverture
	 */
	public Date getDate_ouverture() {
		return date_ouverture;
	}

	/**
	 * @param date_ouverture
	 *            the date_ouverture to set
	 */
	public void setDate_ouverture(Date date_ouverture) {
		this.date_ouverture = date_ouverture;
	}

	/**
	 * @return the taux
	 */
	public long getTaux() {
		return taux;
	}

	/**
	 * @param taux
	 *            the taux to set
	 */
	public void setTaux(long taux) {
		this.taux = taux;
	}

	/**
	 * @return the decouvert
	 */
	public double getDecouvert() {
		return decouvert;
	}

	/**
	 * @param decouvert
	 *            the decouvert to set
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	/**
	 * @return the type
	 */
	public boolean isType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(boolean type) {
		this.type = type;
	}
	
	/**
	 * @return the numero_client
	 */
	public int getNumero_client() {
		return numero_client;
	}

	/**
	 * @param numero_client the numero_client to set
	 */
	public void setNumero_client(int numero_client) {
		this.numero_client = numero_client;
	}

	@Override
	public String toString() {
		return "Compte [id_compte=" + id_compte + ", numero=" + numero + ", solde=" + solde + ", date_ouverture="
				+ date_ouverture + ", taux=" + taux + ", decouvert=" + decouvert + ", type=" + type + "]";
	}

}
