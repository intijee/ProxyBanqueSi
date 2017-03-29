package fr.adaming.entities;

/**
 * Classe association pour les web services
 * @author inti0301
 *
 */
public class ClasseAssociation {
	
	// attribut de l'agence
	
	private Agence assoAgence;
	
	//attribut du conseiler
	
	private Conseiller assoConseiller;
	
	//atribut du client
	
	private Client assoClient;
	
	//attrribut du compte
	
	private Compte assoCompte;

	
	
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
	 */
	public ClasseAssociation(Agence assoAgence, Conseiller assoConseiller, Client assoClient, Compte assoCompte) {
		super();
		this.assoAgence = assoAgence;
		this.assoConseiller = assoConseiller;
		this.assoClient = assoClient;
		this.assoCompte = assoCompte;
	}



	/**
	 * @return the assoAgence
	 */
	public Agence getAssoAgence() {
		return assoAgence;
	}

	/**
	 * @param assoAgence the assoAgence to set
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
	 * @param assoConseiller the assoConseiller to set
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
	 * @param assoClient the assoClient to set
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
	 * @param assoCompte the assoCompte to set
	 */
	public void setAssoCompte(Compte assoCompte) {
		this.assoCompte = assoCompte;
	}
	
	
}
