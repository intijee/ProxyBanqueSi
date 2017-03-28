package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Client;

public interface IClientDao {
	public List<Client> getAllClient();
	public Client getByReference (String reference_client);
	public Client getById (int id_client);
	public void addClient (Client client);
	public void deleteClient (String reference_client);
	public void updateClient (Client client);
	
}
