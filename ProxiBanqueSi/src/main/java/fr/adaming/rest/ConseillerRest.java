package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.entities.Conseiller;
import fr.adaming.service.IConseillerService;

@RestController
@RequestMapping(value = "/conseiller")
public class ConseillerRest {
	
	@Autowired
	private IConseillerService conseillerService;


	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}


	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public int addConseillerWS(@RequestBody Conseiller conseiller) {
		try {
			conseillerService.addConseiller(conseiller);
			// Retourne 1 si l'ajout a réussi
			return new Integer(1);
		} catch (Exception e) {
			// Retourne 0 si l'ajout a échoué
			return new Integer(0);
		}
	};
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public List<Conseiller> getAllConseillerWS() {
		return conseillerService.getAllConseiller();
	};
	
	@RequestMapping(value = "/getByReference/{ref_param}", method = RequestMethod.GET, produces = "application/json")
	public Conseiller getByReferenceWS(@PathVariable("ref_param") String reference_conseiller) {
		try {
			// Trouver avec la ref
			Conseiller conseiller = conseillerService.getConseillerByReference(reference_conseiller);
			return conseiller;
		} catch (Exception e) {
			return null;
		}
	};
	
	
	@RequestMapping(value = "/delete/{ref_param}", method = RequestMethod.DELETE, produces = "application/json")
	public int deleteConseillerWS(@PathVariable("ref_param") String reference_conseiller) {
		try {
			// Supprimer le client dans la base de données
			conseillerService.deleteConseiller(reference_conseiller);
			// Retourne 1 si la suppression a reussi
			return new Integer(1);
		} catch (Exception e) {
			// Retourne 0 si la suppression a echoué
			return new Integer(0);
		}

	};
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public int updateClientWS(@RequestBody Conseiller conseiller) {
		try {
			// Modification du client dans la base de données
			conseillerService.updateConseiller(conseiller);
			// Retourne 1 si la modification a reussi
			return new Integer(1);
		} catch (Exception e) {
			// Retourne 0 si la modification a raté
			return new Integer(0);
		}
	};
	

	
	@RequestMapping(value = "/getById/{id_param}", method = RequestMethod.DELETE, produces = "application/json")
	public Conseiller getByIdWS(@PathVariable("id_param") int id_conseiller) {
		try {
			// Trouver avec la ref
			Conseiller conseiller = conseillerService.getConseillerById(id_conseiller);
			return conseiller;
		} catch (Exception e) {
			return null;
		}
	};
}
