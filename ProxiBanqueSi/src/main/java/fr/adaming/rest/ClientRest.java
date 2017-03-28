package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entities.Client;
import fr.adaming.service.IClientService;

/**
 * Controller du Client
 * 
 * @author inti0297
 *
 */
@RestController
@RequestMapping(value = "/client")
public class ClientRest {

	@Autowired
	private IClientService clientservice;

	/**
	 * @param clientservice
	 *            the clientservice to set
	 */
	public void setClientservice(IClientService clientservice) {
		this.clientservice = clientservice;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public int addClientWS(@RequestBody Client client) {
		try {
			clientservice.addClient(client);
			// Retourne 1 si l'ajout a réussi
			return new Integer(1);
		} catch (Exception e) {
			// Retourne 0 si l'ajout a échoué
			return new Integer(0);
		}
	};

	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Client> getAllClientWS() {
		return clientservice.getAllClient();
	};

	@RequestMapping(value = "/getByReference/{ref_param}", method = RequestMethod.GET, produces = "application/json")
	public Client getByReferenceWS(@PathVariable("ref_param") String reference_client) {
		try {
			// Trouver avec la ref
			Client client = clientservice.getByReference(reference_client);
			return client;
		} catch (Exception e) {
			return null;
		}
	};
	@RequestMapping(value = "/delete/{ref_param}", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteClientWS(@PathVariable("ref_param") String reference_client) {
try {
			
			// Supprimer le client dans la base de données
			clientservice.deleteClient(reference_client);
			
			// Retourne 1 si la suppression a reussi
			return new Integer(1);
			
		} catch (Exception e) {
			
			// Retourne 0 si la suppression a echoué
			return new Integer(0);
		}

	};
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public int updateClientWS(@RequestBody Client client) {
try {
			
			
			// Modification du client dans la base de données
			clientservice.updateClient(client);
			
			// Retourne 1 si la modification a reussi
			return new Integer(1);
			
		} catch (Exception e) {
			
			// Retourne 0 si la modification a raté
			return new Integer(0);
		}
	};
	@RequestMapping(value = "/getById/{id_param}", method = RequestMethod.DELETE, produces = "application/json")
	public Client getByIdWS(@PathVariable("id_param")int id_client) {
		try {
			// Trouver avec la ref
			Client client = clientservice.getById(id_client);
			return client;
		} catch (Exception e) {
			return null;
		}
	};

}
