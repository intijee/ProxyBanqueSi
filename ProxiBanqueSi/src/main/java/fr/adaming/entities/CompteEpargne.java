package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;

public class CompteEpargne extends Compte {

	/**
	 * attribut
	 */
	double decouvert;

	/**
	 * constructeur avec id
	 */
	public CompteEpargne(int id_compte, long numero, double solde, Date date_ouverture, double decouvert) {
		super(id_compte, numero, solde, date_ouverture);
		this.decouvert = decouvert;
	}

	/**
	 * constructeur sans id
	 * @param numero
	 * @param solde
	 * @param date_ouverture
	 * @param decouvert
	 */
	public CompteEpargne(long numero, double solde, Date date_ouverture, double decouvert) {
		super(numero, solde, date_ouverture);
		this.decouvert = decouvert;
	}

	/**
	 * constructeur vide
	 */
	public CompteEpargne() {
		super();
	}

	/**
	 * get et set
	 * @return
	 */
	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

/**
 * affichage du résultat
 */
	@Override
	public String toString() {
		return "CompteEpargne [decouvert=" + decouvert + "]";
	}
	
	

	
	
	
}
