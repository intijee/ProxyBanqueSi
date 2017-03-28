package fr.adaming.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entities.Compte;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;

@RestController
@RequestMapping(value="/compte")
public class CompteRest {
	
	
	@Autowired
	private ICompteService compteService;

	/**
	 * @param compteService the compteService to set
	 */
	public void setCompteService(ICompteService compteService) {
		this.compteService = compteService;
	}
	
	@Autowired
	private IClientService clientService;
	
	/**
	 * @param clientService the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}




	@RequestMapping(value="/add")
	public int addCompteWS(@RequestBody Compte compte){
		
		try {
			
			clientService.getById(compte.getNumero_client());
			
			
			compteService.addCompte(compte);
			
			return new Integer(1);
			
			
			
		} catch (Exception e) {
			
			return new Integer(0);
			
		}
	}

}
