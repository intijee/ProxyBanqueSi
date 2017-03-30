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
import org.springframework.web.bind.annotation.RequestParam;

import fr.adaming.entities.ClasseAssociation;
import fr.adaming.entities.Client;
import fr.adaming.entities.Compte;

import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;

/**
 * Controller gérant les ajout/modification/affichage/suppression/association
 * des comptes
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

		return "comptePages/afficher";
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

		return ("comptePages/ajouter");

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

		
			try {

				compteService.addCompte(compte);

				// rafraichir la liste
				List<Compte> listeComptes = compteService.getAllCompte();

				model.addAttribute("comptesListe", listeComptes);

				return "comptePages/afficher";

			} catch (Exception e) {

				return "comptePages/ajouter";
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

		return ("comptePages/modifierFromAffiche");

	}

	/**
	 * Supprimer un compte depuis la liste affichée
	 * 
	 * @param model
	 * @param id_compte
	 * @return
	 */
	@RequestMapping(value = "/supprimerCompteAffiche", method = RequestMethod.GET)
	public String supprimerCompteAffiche(Model model, @RequestParam("id_compte") int id_compte) {

		Compte compte = compteService.getCompteById(id_compte);

		compteService.deleteCompte(compte);

		// rafraichir la liste
		List<Compte> listeComptes = compteService.getAllCompte();

		model.addAttribute("comptesListe", listeComptes);

		return ("comptePages/afficher");

	}

	/**
	 * Affiche le formulaire de modification
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/afficheModifierCompte", method = RequestMethod.GET)
	public String afficherFormModif(Model model) {

		List<Compte> listeComptes = compteService.getAllCompte();

		model.addAttribute("listeComptes", listeComptes);

		model.addAttribute("compteForm", new Compte());

		return ("comptePages/modifier");

	}

	/**
	 * Soumettre le formulaire d'ajout
	 * 
	 * @param model
	 * @param compte
	 * @return
	 */
	@RequestMapping(value = "/soumettreModifierCompte", method = RequestMethod.POST)
	public String modifCompte(Model model, @ModelAttribute("compteForm") Compte compte) {

		compteService.updateCompte(compte);

		// rafraichir la liste
		List<Compte> listeComptes = compteService.getAllCompte();

		model.addAttribute("comptesListe", listeComptes);

		return "comptePages/afficher";

	}

	/**
	 * Affiche le formulaire de suppression
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/afficheSupprimerCompte", method = RequestMethod.GET)
	public String afficherFormSuppr(Model model) {

		List<Compte> listeComptes = compteService.getAllCompte();

		model.addAttribute("listeComptes", listeComptes);

		model.addAttribute("compteForm", new Compte());

		return ("comptePages/supprimer");

	}

	/**
	 * Soumettre le formulaire d'ajout
	 * 
	 * @param model
	 * @param compte
	 * @return
	 */
	@RequestMapping(value = "/soumettreSupprimerCompte", method = RequestMethod.POST)
	public String supprCompte(Model model, @ModelAttribute("compteForm") Compte compte) {

		Compte co = compteService.getCompteById(compte.getId_compte());
			
		compteService.deleteCompte(co);

		// rafraichir la liste
		List<Compte> listeComptes = compteService.getAllCompte();

		model.addAttribute("comptesListe", listeComptes);

		return "comptePages/afficher";

	}

	/**
	 * Afficher le formulaire des operations de virement
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/afficheOperationForm", method = RequestMethod.GET)
	public String afficherFormOperation(Model model) {

		List<Compte> listeComptes = compteService.getAllCompte();

		model.addAttribute("listeComptes", listeComptes);

		model.addAttribute("compteForm1", new ClasseAssociation());
		
		model.addAttribute("compteForm2", new ClasseAssociation());
		
		model.addAttribute("compteForm3", new ClasseAssociation());
	

		return ("comptePages/operation");

	}

	/**
	 * 
	 * Soumettre l'opération dépot
	 * 
	 * @param model
	 * @param compte
	 * @param somme
	 * @return
	 */
	@RequestMapping(value = "/soumettreDepotCompte", method = RequestMethod.POST)
	public String depot(Model model, @ModelAttribute("compteForm1") ClasseAssociation asso) {

		Compte compte = compteService.getCompteById(asso.getAssoCompte().getId_compte());
		
		compteService.depot(compte, asso.getSomme());

		return "accueil";

	}

	/**
	 * 
	 * Soumettre l'opération retrait
	 * 
	 * @param model
	 * @param compte
	 * @param somme
	 * @return
	 */
	@RequestMapping(value = "/soumettreRetraitCompte", method = RequestMethod.POST)
	public String retrait(Model model, @ModelAttribute("compteForm2") ClasseAssociation asso) {

		try {
			
			Compte compte = compteService.getCompteById(asso.getAssoCompte().getId_compte());
			
			compteService.retrait(compte, asso.getSomme());

			return "accueil";

		} catch (Exception e) {

			return "comptePages/operation";

		}
	}

	/**
	 * 
	 * Soumettre l'opération virement
	 * 
	 * @param model
	 * @param debiteur
	 * @param somme
	 * @param credite
	 * @return
	 */
	@RequestMapping(value = "/soumettreVirementCompte", method = RequestMethod.POST)
	public String virement(Model model, @ModelAttribute("compteForm3") ClasseAssociation asso ) {

		try {

			Compte deb = compteService.getCompteById(asso.getAssoCompte().getId_compte());
			
			Compte cred = compteService.getCompteById(asso.getAssoCredite().getId_compte());
			
			compteService.virement(deb, cred, asso.getSomme());

			return "accueil";

		} catch (Exception e) {

			return "comptePages/operation";

		}

	}

}
