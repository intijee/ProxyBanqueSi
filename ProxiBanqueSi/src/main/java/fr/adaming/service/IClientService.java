package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;

public interface IClientService {
	
	public List<Client> getAllClient();
	public Client getByReference (String reference_client);
	public void addClient (Client client);
	public void deleteClient (String reference_client);
	public void updateClient (Client client);

}
