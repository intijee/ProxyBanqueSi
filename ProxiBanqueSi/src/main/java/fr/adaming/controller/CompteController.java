package fr.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import fr.adaming.entities.Client;
import fr.adaming.entities.Compte;

import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;

/**
 * Controller gérant les ajout/modification/affichage/suppression/association des comptes
 * 
 * 
 * @author Team Défonce Tout
 *
 */
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

	/**
	 * Affiche la liste des comptes
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listeComptes", method = RequestMethod.GET)
	public String afficherComptes(ModelMap model) {

		List<Compte> listeComptes = compteService.getAllCompte();

		model.addAttribute("comptesListe", listeComptes);

		return "afficher";
	}

	/**
	 * Affiche le formulaire d'ajout
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/afficheAjoutCompte", method = RequestMethod.GET)
	public String afficherFormAjout(Model model) {

		List<Client> listeClient = clientService.getAllClient();

		model.addAttribute("listeClients", listeClient);

		model.addAttribute("compteForm", new Compte());

		return ("ajouter");

	}

	/**
	 * Récupérer les infos du formulaire d'ajout/modif et fair l'ajout/modif.
	 * 
	 * @param model
	 * @param compte
	 * @return
	 */
	@RequestMapping(value = "/soumettreAjoutCompte", method = RequestMethod.POST)
	public String addCompte(Model model, @ModelAttribute("compteForm") Compte compte) {

		Client client = clientService.getByReference(compte.getpClient().getReference_client());

		compte.setpClient(client);

		if (compte.getId_compte() == 0) {
			try {

				compteService.addCompte(compte);

				return "afficher";

			} catch (Exception e) {

				return "ajouter";
			}
		} else {

			compteService.updateCompte(compte);

			return "afficher";
		}
	}

	/**
	 * Affiche le formulaire d'ajout/modification avec les info du compte
	 * 
	 * @param model
	 * @param id_compte
	 * @return
	 */
	@RequestMapping(value = "/modifierCompteAffiche/{id_compte}", method = RequestMethod.GET)
	public String afficherFormModif(Model model, @PathVariable("id_compte") int id_compte) {

		List<Client> listeClient = clientService.getAllClient();

		model.addAttribute("listeClients", listeClient);

		model.addAttribute("compteForm", compteService.getCompteById(id_compte));

		return ("ajouter");

	}
	
	/**
	 * Supprimer un compte depuis la liste affichée
	 * 
	 * @param model
	 * @param id_compte
	 * @return
	 */
	@RequestMapping(value = "/supprimerCompteAffiche/{id_compte}", method = RequestMethod.GET)
	public String supprimerCompteAffiche(Model model, @PathVariable("id_compte") int id_compte) {
		
		Compte compte = compteService.getCompteById(id_compte);
		
		compteService.deleteCompte(compte);

		return ("afficher");

	}
	
	/**
	 * Affiche le formulaire d'ajout
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/afficheModifierCompte", method = RequestMethod.GET)
	public String afficherFormModif(Model model) {

		List<Compte> listeComptes = compteService.getAllCompte();
		
		model.addAttribute("listeComptes", listeComptes);				

		model.addAttribute("compteForm", new Compte());

		return ("modifier");

	}
	
	

}
