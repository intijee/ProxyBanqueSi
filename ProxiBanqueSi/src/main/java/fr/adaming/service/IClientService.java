package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.Conseiller;

public interface IClientService {
	
	public List<Client> getAllClient();
	public Client getByReference (String reference_client);
	public void addClient (Client client);
	public void deleteClient (String reference_client);
	public void updateClient (Client client);
	public Client getById (int id_client);
	public void associerClientConseiller (Client client, Conseiller conseiller) throws Exception;

}
