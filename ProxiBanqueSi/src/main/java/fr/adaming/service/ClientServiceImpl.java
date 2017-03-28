package fr.adaming.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Client;
import fr.adaming.entities.Conseiller;

/**
 * Service pour le client
 * @author inti0297
 *
 */
@Service
@Transactional
public class ClientServiceImpl implements IClientService{
	
	@Autowired
	private IClientDao clientDao;
	
	/**
	 * @param clientDao the clientDao to set
	 */
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}
	
	/**
	 * Afficher la liste des clients
	 * @return Liste des clients
	 */
	public List<Client> getAllClient() {
		return clientDao.getAllClient();
	}
	/**
	 * Afficher un client en fonction de sa référence
	 * @param reference du client
	 * @return le client
	 */
	public Client getByReference(String reference_client) {
		return clientDao.getByReference(reference_client);
	}
	/**
	 * Ajouter un client à la BDD
	 * @param Client
	 */
	public void addClient(Client client) {
		clientDao.addClient(client);
		
	}
	/**
	 * Supprimer un client
	 * @param Référence du client à supprimer
	 */
	public void deleteClient(String reference_client) {
		clientDao.deleteClient(reference_client);
		
	}
	/**
	 * modifier un client
	 * @param Client à modifier
	 */
	public void updateClient(Client client) {
		clientDao.updateClient(client);
		
	}

	@Override
	public Client getById(int id_client) {
		return clientDao.getById(id_client);
	}

	@Override
	public void associerClientConseiller(Client client, Conseiller conseiller) {
				
		List<Client> listeClients = clientDao.getAllClient();
		int verif = 0;
		for (Client cl : listeClients) {
			if(cl.getpConseiller().equals(conseiller))
				verif=verif++;
			if (verif<=10) {
				client.setpConseiller(conseiller);
			} 
		}
	}

}
