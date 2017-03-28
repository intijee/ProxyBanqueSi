package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;

public class Compte implements Serializable {

	/**
	 * attributs de la classe compte
	 */
	int id_compte;
	long numero;
	double solde;
	Date date_ouverture;
	
	/**
	 * attribut de compte épargne
	 */
	long taux;
 
	/**
	 * attribut de compte courant
	 */
	double decouvert;
	
	
	/**
	 * booléen : épargne (1) ou courant (0)
	 */
	boolean type;
	
	
	/**
	 * déclaration des associations
	 */
	
	/**
	 * constructeur compte générique
	 */
	/**
	/**
	 * constructeur avec id	
	 * @param id_compte
	 * @param numero
	 * @param solde
	 * @param date_ouverture
	 */
	public Compte(int id_compte, long numero, double solde, Date date_ouverture) {
		super();
		this.id_compte = id_compte;
		this.numero = numero;
		this.solde = solde;
		this.date_ouverture = date_ouverture;
	}


	/**
	 * constructeur sans id
	 * @param numero
	 * @param solde
	 * @param date_ouverture
	 */
	public Compte(long numero, double solde, Date date_ouverture) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.date_ouverture = date_ouverture;
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
 * @param id_compte
 * @param numero
 * @param solde
 * @param date_ouverture
 * @param decouvert
 * @param type
 */
	public Compte(int id_compte, long numero, double solde, Date date_ouverture, double decouvert, boolean type) {
		super();
		this.id_compte = id_compte;
		this.numero = numero;
		this.solde = solde;
		this.date_ouverture = date_ouverture;
		this.decouvert = decouvert;
		this.type = type;
	}

/**
 * constructeur sans id 
 * @param numero
 * @param solde
 * @param date_ouverture
 * @param decouvert
 * @param type
 */
	public Compte(long numero, double solde, Date date_ouverture, double decouvert, boolean type) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.date_ouverture = date_ouverture;
		this.decouvert = decouvert;
		this.type = type;
	}

/**
 * constructeur compte epargne
 */
	/**
	 * constructeur compte epargne sans id
	 * @param numero
	 * @param solde
	 * @param date_ouverture
	 * @param taux
	 */
	public Compte(int id_compte, long numero, double solde, Date date_ouverture, long taux, boolean type) {
		super();
		this.id_compte = id_compte;
		this.numero = numero;
		this.solde = solde;
		this.date_ouverture = date_ouverture;
		this.taux = taux;
		this.type = type;
	}


/**
 * constructeur compte epargne avec id
 */
	public Compte(long numero, double solde, Date date_ouverture, long taux, boolean type) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.date_ouverture = date_ouverture;
		this.taux = taux;
		this.type = type;
	}


@Override
public String toString() {
	return "Compte [id_compte=" + id_compte + ", numero=" + numero + ", solde=" + solde + ", date_ouverture="
			+ date_ouverture + ", taux=" + taux + ", decouvert=" + decouvert + ", type=" + type + "]";
}


	
}
