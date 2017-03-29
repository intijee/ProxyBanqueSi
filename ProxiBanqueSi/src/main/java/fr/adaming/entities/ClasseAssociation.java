package fr.adaming.entities;

/**
 * Classe association pour les web services
 * 
 * @author inti0301
 *
 */
public class ClasseAssociation {

	// attribut de l'agence

	private Agence assoAgence;

	// attribut du conseiler

	private Conseiller assoConseiller;

	// atribut du client

	private Client assoClient;

	// attrribut du compte

	private Compte assoCompte;

	// attrribut du compte2

	private Compte assoCredite;

	// somme de l'opération
	private double somme;

	/**
	 * constructeur vide
	 */
	public ClasseAssociation() {
		super();
	}

	/**
	 * constructeur plein
	 * 
	 * @param assoAgence
	 * @param assoConseiller
	 * @param assoClient
	 * @param assoCompte
	 * @param assoCredite
	 * @param somme
	 */
	public ClasseAssociation(Agence assoAgence, Conseiller assoConseiller, Client assoClient, Compte assoCompte,
			Compte assoCredite, double somme) {
		super();
		this.assoAgence = assoAgence;
		this.assoConseiller = assoConseiller;
		this.assoClient = assoClient;
		this.assoCompte = assoCompte;
		this.assoCredite = assoCredite;
		this.somme = somme;
	}

	/**
	 * @return the assoAgence
	 */
	public Agence getAssoAgence() {
		return assoAgence;
	}

	/**
	 * @param assoAgence
	 *            the assoAgence to set
	 */
	public void setAssoAgence(Agence assoAgence) {
		this.assoAgence = assoAgence;
	}

	/**
	 * @return the assoConseiller
	 */
	public Conseiller getAssoConseiller() {
		return assoConseiller;
	}

	/**
	 * @param assoConseiller
	 *            the assoConseiller to set
	 */
	public void setAssoConseiller(Conseiller assoConseiller) {
		this.assoConseiller = assoConseiller;
	}

	/**
	 * @return the assoClient
	 */
	public Client getAssoClient() {
		return assoClient;
	}

	/**
	 * @param assoClient
	 *            the assoClient to set
	 */
	public void setAssoClient(Client assoClient) {
		this.assoClient = assoClient;
	}

	/**
	 * @return the assoCompte
	 */
	public Compte getAssoCompte() {
		return assoCompte;
	}

	/**
	 * @param assoCompte
	 *            the assoCompte to set
	 */
	public void setAssoCompte(Compte assoCompte) {
		this.assoCompte = assoCompte;
	}

	/**
	 * @return the assoCredite
	 */
	public Compte getAssoCredite() {
		return assoCredite;
	}

	/**
	 * @param assoCredite
	 *            the assoCredite to set
	 */
	public void setAssoCredite(Compte assoCredite) {
		this.assoCredite = assoCredite;
	}

	/**
	 * @return the somme
	 */
	public double getSomme() {
		return somme;
	}

	/**
	 * @param somme
	 *            the somme to set
	 */
	public void setSomme(double somme) {
		this.somme = somme;
	}

}
