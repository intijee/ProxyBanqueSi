package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Client;

/**
 * Dao pour le client
 * 
 * @author inti0297
 *
 */
@Repository
public class ClientDaoImpl implements IClientDao {

	@PersistenceContext
	private EntityManager em;

	/**
	 * @param em
	 *            the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	// -------------------------------------------Méthode du
	// crud--------------------------------//

	/**
	 * Afficher la liste des clients
	 * 
	 * @return Liste des clients
	 */
	public List<Client> getAllClient() {
		// EntityManager em = emf.createEntityManager();
		String req = "SELECT c from Client c";
		Query query = em.createQuery(req);
		if (query.getResultList().size()!=0) {
			return query.getResultList();
		}else{
			return null;
		}
		
	}

	/**
	 * Afficher un client en fonction de sa référence
	 * 
	 * @param reference
	 *            du client
	 * @return le client
	 */
	public Client getByReference(String reference_client) {
		// EntityManager em = emf.createEntityManager();
		String req = "Select c from Client c Where c.reference_client=:pRefClient";
		Query query = em.createQuery(req);
		query.setParameter("pRefClient", reference_client);
		if ((Client) query.getSingleResult() != null) {
			return (Client) query.getSingleResult();
		} else {
			return null;
		}
	}

	/**
	 * Ajouter un client à la BDD
	 * 
	 * @param Client
	 */
	public void addClient(Client client) {
		// EntityManager em = emf.createEntityManager();
		em.persist(client);

	}

	/**
	 * Supprimer un client
	 * 
	 * @param Référence
	 *            du client à supprimer
	 */
	public void deleteClient(String reference_client) {
		// EntityManager em = emf.createEntityManager();
		String req = "Select c from Client c Where c.reference_client=:pRefClient";
		Query query = em.createQuery(req);
		Client c = (Client) query.getSingleResult();
		em.remove(c);

	}

	/**
	 * modifier un client
	 * 
	 * @param Client
	 *            à modifier
	 */
	public void updateClient(Client client) {
		// EntityManager em = emf.createEntityManager();
		Client c = em.find(Client.class, client.getId_client());
		c.setNom(client.getNom());
		c.setPrenom(client.getPrenom());
		c.setAdresse(client.getAdresse());
		c.setCode_postal(client.getCode_postal());
		c.setVille(client.getVille());
		c.setReference_client(client.getReference_client());
		c.setTelephone(client.getTelephone());
		c.setHumain_0_entreprise_1(client.getHumain_0_entreprise_1());
		em.merge(c);
	}

	@Override
	public Client getById(int id_client) {
		// EntityManager em = emf.createEntityManager();
		Client c = em.find(Client.class, id_client);
		return c;
	}

}
