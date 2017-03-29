package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Client;
import fr.adaming.entities.Conseiller;
import fr.adaming.service.IClientService;
import fr.adaming.service.IConseillerService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientService clientService;

	@Autowired
	private IConseillerService conseillerService;
	

	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}
	
	
	
	//========================Ajouter Client=========================================
	//Afficher formulaire
	@RequestMapping(value = "/afficherFormAjouter", method = RequestMethod.GET)
	public ModelAndView ajouterClientFormulaire(){
		return new ModelAndView("clientPages/formulaireAjout","clientForm",new Client());
	}
	
	//Soumettre formulaire
	@RequestMapping(value = "/soumettreFormAjouter", method = RequestMethod.POST)
	public String soumettreFormulaireAjouter(Model model, @ModelAttribute("clientForm") Client client){
		
		Conseiller conseiller = conseillerService.getConseillerByReference(client.getpConseiller().getReference_conseiller());
		client.setpConseiller(conseiller);
		
		clientService.addClient(client);
		
		//MAJ de la liste
		List<Client> listeClient = clientService.getAllClient();
		model.addAttribute("clientListe", listeClient);
		return "clientPages/accueil";
	}
	
	
	//=======================Supprimer Client==========================================
	//Afficher formulaire
	@RequestMapping(value = "/affichFormSupprimer", method = RequestMethod.GET)
	public String supprimerClientFormulaire(){
		return "clientPages/formulaireSuppression";
	}
		
	//Soumettre formulaire
	@RequestMapping(value = "/soumettreFormSupprimer", method = RequestMethod.POST)
	public String soumettreFormulaireSupprimer(Model model, @RequestParam("reference_param") String reference){
		clientService.deleteClient(reference);
		
		//MAJ de la liste
		List<Client> listeClient = clientService.getAllClient();
		model.addAttribute("clientListe", listeClient);
		return "clientPages/accueil"; 
	}
	
	
	//=======================Rechercher Client==========================================
	//Afficher formulaire
	@RequestMapping(value = "/affichFormRechercher", method = RequestMethod.GET)
	public ModelAndView rechercherEmployeFormulaire(){
		return new ModelAndView("clientPages/formulaireRecherche", "clientForm", new Client());
	}
	
	//Soumettre formulaire
	@RequestMapping(value = "/soumettreFormRechercher", method = RequestMethod.POST)
	public String soumettreFormulaireRechercher(Model model, String reference){
		Client client  = clientService.getByReference(reference);
		
		//Envoi de l'objet
		model.addAttribute("client",client);
		return "clientPages/accueil"; 
	}
	
	
	
	//=======================Modifier Client============================================
	//Afficher formulaire
	@RequestMapping(value = "/affichFormModifier", method = RequestMethod.GET)
	public ModelAndView modifierEmployeFormulaire(){
		return new ModelAndView("affichFormRechercher/formulaireModication", "clientModifForm", new Client());
	}
	
	//Soumettre formulaire
	@RequestMapping(value = "/soumettreFormModifier", method = RequestMethod.POST)
	public String soumettreFormulaireModifier(Model model, Client client){
		
	Conseiller conseiller = conseillerService.getConseillerByReference(client.getpConseiller().getReference_conseiller());
	client.setpConseiller(conseiller);
	clientService.updateClient(client);
	
	//MAJ de la liste
	List<Client> listeClient = clientService.getAllClient();
	model.addAttribute("clientListe", listeClient);
	return "clientPages/accueil";

	}
	
	
	//=======================Afficher Client============================================
	@RequestMapping(value= "/accueil", method = RequestMethod.GET)
	public String accueil(ModelMap model){
		
		List<Client> listeClient =clientService.getAllClient();
		model.addAttribute("clientListe",listeClient);
		return "clientPages/accueil";
	}
	

}
