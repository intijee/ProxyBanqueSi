package fr.adaming.rest;

import fr.adaming.service.IClientService;

/**
 * Controller du Client
 * @author inti0297
 *
 */
public class ClientRest {
	
	
	private IClientService clientservice;

	/**
	 * @param clientservice the clientservice to set
	 */
	public void setClientservice(IClientService clientservice) {
		this.clientservice = clientservice;
	}
	
	

}
