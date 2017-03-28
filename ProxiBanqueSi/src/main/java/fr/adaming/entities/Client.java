package fr.adaming.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
@Table(name="clients")
@XmlRootElement
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_client;
	private String nom;
	private String prenom;
	private String adresse;
	private String code_postal;
	private String ville;
	private String telephone;
	private long reference_client;
	private Boolean humain_0_entreprise_1;
	// Association
	@OneToMany(mappedBy="pClient",fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Compte> plListeCompte;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn (name="client_id_fk",referencedColumnName="id_conseiller")
	private Conseiller pConseiller;
	/**
	 * Ctor vide
	 */
	public Client() {
		super();
	}
	
	/**
	 * Ctor sans id
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param code_postal
	 * @param ville
	 * @param telephone
	 * @param reference_client
	 * @param humain_0_entreprise_1
	 */
	public Client(String nom, String prenom, String adresse, String code_postal, String ville, String telephone,
			long reference_client, Boolean humain_0_entreprise_1) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.code_postal = code_postal;
		this.ville = ville;
		this.telephone = telephone;
		this.reference_client = reference_client;
		this.humain_0_entreprise_1 = humain_0_entreprise_1;
	}

	/**
	 * Ctor avec id
	 * @param id_client
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param code_postal
	 * @param ville
	 * @param telephone
	 * @param reference_client
	 * @param humain_0_entreprise_1
	 */
	public Client(int id_client, String nom, String prenom, String adresse, String code_postal, String ville,
			String telephone, long reference_client, Boolean humain_0_entreprise_1) {
		super();
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.code_postal = code_postal;
		this.ville = ville;
		this.telephone = telephone;
		this.reference_client = reference_client;
		this.humain_0_entreprise_1 = humain_0_entreprise_1;
	}


	/**
	 * @return the id_client
	 */
	@XmlElement
	public int getId_client() {
		return id_client;
	}
	/**
	 * @param id_client the id_client to set
	 */
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	/**
	 * @return the nom
	 */
	@XmlElement
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
	@XmlElement
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
	 * @return the adresse
	 */
	@XmlElement
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the code_postal
	 */
	@XmlElement
	public String getCode_postal() {
		return code_postal;
	}
	/**
	 * @param code_postal the code_postal to set
	 */
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	/**
	 * @return the ville
	 */
	@XmlElement
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the telephone
	 */
	@XmlElement
	public String getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the reference_client
	 */
	@XmlElement
	public long getReference_client() {
		return reference_client;
	}
	/**
	 * @param reference_client the reference_client to set
	 */
	public void setReference_client(long reference_client) {
		this.reference_client = reference_client;
	}
	
	/**
	 * @return the humain_0_entreprise_1
	 */
	@XmlElement
	public Boolean getHumain_0_entreprise_1() {
		return humain_0_entreprise_1;
	}

	/**
	 * @param humain_0_entreprise_1 the humain_0_entreprise_1 to set
	 */
	public void setHumain_0_entreprise_1(Boolean humain_0_entreprise_1) {
		this.humain_0_entreprise_1 = humain_0_entreprise_1;
	}

	/**
	 * @return the plListeCompte
	 */
	public List<Compte> getPlListeCompte() {
		return plListeCompte;
	}

	/**
	 * @param plListeCompte the plListeCompte to set
	 */
	public void setPlListeCompte(List<Compte> plListeCompte) {
		this.plListeCompte = plListeCompte;
	}

	/**
	 * @return the pConseiller
	 */
	public Conseiller getpConseiller() {
		return pConseiller;
	}

	/**
	 * @param pConseiller the pConseiller to set
	 */
	public void setpConseiller(Conseiller pConseiller) {
		this.pConseiller = pConseiller;
	}

	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", code_postal=" + code_postal + ", ville=" + ville + ", telephone=" + telephone
				+ ", reference_client=" + reference_client + "]";
	}
	
	
	

}
