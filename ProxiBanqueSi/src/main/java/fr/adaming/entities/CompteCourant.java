package fr.adaming.entities;

import java.io.Serializable;
import java.util.Date;

public class CompteCourant extends Compte {
	
	/**
	 * attribut
	 */
 double taux;

 /**
  * constructeur avec id
  * @param id_compte
  * @param numero
  * @param solde
  * @param date_ouverture
  * @param taux
  */
	public CompteCourant(int id_compte, long numero, double solde, Date date_ouverture, double taux) {
		super(id_compte, numero, solde, date_ouverture);
		this.taux = taux;
	}

	/**
	 * constructeur sans id
	 * @param numero
	 * @param solde
	 * @param date_ouverture
	 * @param taux
	 */
public CompteCourant(long numero, double solde, Date date_ouverture, double taux) {
	super(numero, solde, date_ouverture);
	this.taux = taux;
}

/**
 * compte courant
 */
	public CompteCourant() {
		super();
	}

	/**
	 * get et set
	 * @return
	 */
public double getTaux() {
	return taux;
}

public void setTaux(double taux) {
	this.taux = taux;
}

/**
 * affichage du résultat
 */
@Override
public String toString() {
	return "CompteCourant [taux=" + taux + "]";
}
 

 
 
 
}
