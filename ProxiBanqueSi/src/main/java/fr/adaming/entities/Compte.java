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
	 * déclaration des associations
	 */
	
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
	 * get et set
	 * @return
	 */
public int getId_compte() {
	return id_compte;
}

public void setId_compte(int id_compte) {
	this.id_compte = id_compte;
}

public long getNumero() {
	return numero;
}

public void setNumero(long numero) {
	this.numero = numero;
}

public double getSolde() {
	return solde;
}

public void setSolde(double solde) {
	this.solde = solde;
}

public Date getDate_ouverture() {
	return date_ouverture;
}

public void setDate_ouverture(Date date_ouverture) {
	this.date_ouverture = date_ouverture;
}

/**
 * affichage du résultat
 */
@Override
public String toString() {
	return "Compte [id_compte=" + id_compte + ", numero=" + numero + ", solde=" + solde + ", date_ouverture="
			+ date_ouverture + "]";
}
	
	
	
	
}
