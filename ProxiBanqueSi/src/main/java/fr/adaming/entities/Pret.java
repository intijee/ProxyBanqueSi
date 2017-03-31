package fr.adaming.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Pret {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_pret;
	
	private Client pClient;
	
	private double revenue_client;
	
	private double somme_pret;
	
	private int duree_mois;
	
	private double mensualites;
	
	private double cout_pret;

	
	
	/**
	 * 
	 */
	public Pret() {
		super();
	}

	/**
	 * @param id_pret
	 * @param pClient
	 * @param revenue_client
	 * @param somme_pret
	 * @param duree_mois
	 */
	public Pret(int id_pret, Client pClient, double revenue_client, double somme_pret, int duree_mois) {
		super();
		this.id_pret = id_pret;
		this.pClient = pClient;
		this.revenue_client = revenue_client;
		this.somme_pret = somme_pret;
		this.duree_mois = duree_mois;
	}

	/**
	 * @param pClient
	 * @param revenue_client
	 * @param somme_pret
	 * @param duree_mois
	 */
	public Pret(Client pClient, double revenue_client, double somme_pret, int duree_mois) {
		super();
		this.pClient = pClient;
		this.revenue_client = revenue_client;
		this.somme_pret = somme_pret;
		this.duree_mois = duree_mois;
	}

	/**
	 * @return the id_pret
	 */
	public int getId_pret() {
		return id_pret;
	}

	/**
	 * @param id_pret the id_pret to set
	 */
	public void setId_pret(int id_pret) {
		this.id_pret = id_pret;
	}

	/**
	 * @return the pClient
	 */
	public Client getpClient() {
		return pClient;
	}

	/**
	 * @param pClient the pClient to set
	 */
	public void setpClient(Client pClient) {
		this.pClient = pClient;
	}

	/**
	 * @return the revenue_client
	 */
	public double getRevenue_client() {
		return revenue_client;
	}

	/**
	 * @param revenue_client the revenue_client to set
	 */
	public void setRevenue_client(double revenue_client) {
		this.revenue_client = revenue_client;
	}

	/**
	 * @return the somme_pret
	 */
	public double getSomme_pret() {
		return somme_pret;
	}

	/**
	 * @param somme_pret the somme_pret to set
	 */
	public void setSomme_pret(double somme_pret) {
		this.somme_pret = somme_pret;
	}

	/**
	 * @return the duree_mois
	 */
	public int getDuree_mois() {
		return duree_mois;
	}

	/**
	 * @param duree_mois the duree_mois to set
	 */
	public void setDuree_mois(int duree_mois) {
		this.duree_mois = duree_mois;
	}

	/**
	 * @return the mensualites
	 */
	public double getMensualites() {
		return mensualites;
	}

	/**
	 * @param mensualites the mensualites to set
	 */
	public void setMensualites(double mensualites) {
		this.mensualites = mensualites;
	}

	/**
	 * @return the cout_pret
	 */
	public double getCout_pret() {
		return cout_pret;
	}

	/**
	 * @param cout_pret the cout_pret to set
	 */
	public void setCout_pret(double cout_pret) {
		this.cout_pret = cout_pret;
	}


	

}
