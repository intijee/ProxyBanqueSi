package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.entities.Client;
import fr.adaming.entities.Compte;
import fr.adaming.entities.Conseiller;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;

@Controller
@RequestMapping("/compte")
public class CompteController {

	@Autowired
	ICompteService compteService;

	@Autowired
	IClientService clientService;

	public void setCompteService(ICompteService compteService) {
		this.compteService = compteService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	@RequestMapping(value = "/listeComptes", method = RequestMethod.GET)
	public String afficherComptes(ModelMap model) {

		List<Compte> listeComptes = compteService.getAllCompte();

		model.addAttribute("comptesListe", listeComptes);

		return "afficher";
	}

	// Lien vers le formulaire d'ajout et lui attribuer le modele
	@RequestMapping(value = "/afficheAjoutCompte", method = RequestMethod.GET)
	public String afficherFormAjout(Model model) {

		List<Client> listeClient = clientService.getAllClient();

		model.addAttribute("listeClients", listeClient);

		model.addAttribute("compteForm", new Compte());

		return ("ajouter");

	}

	// Envoi des donnée du formulaire via la methode ajouteEmploye.
	@RequestMapping(value = "/soumettreAjoutCompte", method = RequestMethod.POST)
	public String addCompte(Model model, @ModelAttribute("compteForm") Compte compte) {

		try {

			Client client = clientService.getByReference(compte.getpClient().getReference_client());

			compte.setpClient(client);

			compteService.addCompte(compte);

			// clientService.as
			return "afficher";

		} catch (Exception e) {

			return "ajouter";
		}

	}
}
