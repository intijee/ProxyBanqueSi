package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entities.Client;
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




	@RequestMapping(value="/add",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public int addCompteWS(@RequestBody Compte compte){

		try {

			Client client=clientService.getById(compte.getNumero_client());

			compte.setpClient(client);

			compteService.addCompte(compte);

			return new Integer(1);

		} catch (Exception e) {

			return new Integer(0);

		}
	}

	@RequestMapping(value="/delete/{num_compte}", method=RequestMethod.DELETE, produces="application/json")
	public int deleteCompteWS(@PathVariable ("num_compte") int num_compte){

		try {
			compteService.deleteCompte(compteService.getCompteByNumero(num_compte));

			return new Integer(1);
		} catch (Exception e) {

			return new Integer(0);

		}
	}

	@RequestMapping(value="/update", method=RequestMethod.PUT,consumes="application/json",produces="application/json")
	public int updateCompteWS(@RequestBody Compte compte){

		try {

			compteService.updateCompte(compte);

			return new Integer(1);

		} catch (Exception e){

			return new Integer(0);

		}
	}

	@RequestMapping(value="/getByNum",method=RequestMethod.GET,produces="application/json")
	public Compte getCompteByNumeroWS(@PathVariable ("num_compte") long numero_compte){

		return compteService.getCompteByNumero(numero_compte);
	}


	@RequestMapping(value="/getAll",method=RequestMethod.GET,produces="application/json")
	public List<Compte> getAllCompteWS(){
		return compteService.getAllCompte();
	}

	@RequestMapping(value="/retrait",method=RequestMethod.PUT,produces="application/json")
	public int retraitCompteWS(@RequestBody Compte compte, @PathVariable ("retrait") double retrait){
		try {
			compteService.retrait(compte, retrait);
			return new Integer(1);
		} catch (Exception e) {
			e.printStackTrace();
			return new Integer(0);
		}
	}

	@RequestMapping(value="/depot",method=RequestMethod.PUT,produces="application/json")
	public void depotCompteWS(@RequestBody Compte compte, @PathVariable ("depot") long depot){
		compteService.depot(compte, depot);
	}

	/**
	 * type de méthode ?
	 * @param debiteur
	 * @param credite
	 * @param virement
	 */
	@RequestMapping(value="/virement",method=RequestMethod.PUT,produces="application/json")
	public int virementCompteWS(@RequestBody Compte debiteur, @RequestBody Compte credite, @PathVariable ("virement") long virement){
		try {
			compteService.virement(debiteur, credite, virement);
			return new Integer(1);
		} catch (Exception e) {
			e.printStackTrace();
			return new Integer(0);
		}
	}

}


