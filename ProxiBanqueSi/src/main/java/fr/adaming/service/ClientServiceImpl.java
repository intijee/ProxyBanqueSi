package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.IClientDao;
import fr.adaming.entities.Client;

public class ClientServiceImpl implements IClientService{
	
	private IClientDao clientDao;
	
	/**
	 * @param clientDao the clientDao to set
	 */
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}
	

	public List<Client> getAllClient() {
		return clientDao.getAllClient();
	}

	public Client getByReference(String reference_client) {
		return clientDao.getByReference(reference_client);
	}

	public void addClient(Client client) {
		clientDao.addClient(client);
		
	}

	public void deleteClient(String reference_client) {
		clientDao.deleteClient(reference_client);
		
	}

	public void updateClient(Client client) {
		clientDao.updateClient(client);
		
	}

}
