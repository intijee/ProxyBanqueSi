package fr.adaming.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.adaming.WSSoapClient.WebServiceBourse;
import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.entities.Action;
import fr.adaming.entities.ClasseAssociation;
import fr.adaming.entities.Client;
import fr.adaming.entities.Compte;
import fr.adaming.entities.Conseiller;
import fr.adaming.entities.Pret;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;
import fr.adaming.service.IConseillerService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private IClientService clientService;

	@Autowired
	private IConseillerService conseillerService;

	@Autowired
	private ICompteService compteService;

	/**
	 * @param compteService
	 *            the compteService to set
	 */
	public void setCompteService(ICompteService compteService) {
		this.compteService = compteService;
	}

	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	// ========================Ajouter
	// Client=========================================
	// Afficher formulaire
	@RequestMapping(value = "/afficherFormAjouter", method = RequestMethod.GET)
	public ModelAndView ajouterClientFormulaire() {
		List<Conseiller> listeConseiller = conseillerService.getAllConseiller();
		ModelAndView model = new ModelAndView();
		model.addObject("conseillerListe", listeConseiller);
		model.addObject("clientForm", new Client());
		model.setViewName("clientPages/formulaireAjout");
		return model;
	}

	// Soumettre formulaire
	@RequestMapping(value = "/soumettreFormAjouter", method = RequestMethod.POST)
	public String soumettreFormulaireAjouter(Model model, @ModelAttribute("clientForm") Client client) {

		Conseiller conseiller = conseillerService
				.getConseillerByReference(client.getpConseiller().getReference_conseiller());
		client.setpConseiller(conseiller);

		clientService.addClient(client);

		// MAJ de la liste
		List<Client> listeClient = clientService.getAllClient();
		model.addAttribute("clientListe", listeClient);
		return "clientPages/accueil";
	}

	// =======================Supprimer
	// Client==========================================
	// Afficher formulaire
	@RequestMapping(value = "/affichFormSupprimer", method = RequestMethod.GET)
	public String supprimerClientFormulaire(Model model) {

		List<Client> listeClient = clientService.getAllClient();
		model.addAttribute("clientListe", listeClient);
		model.addAttribute("supprimerForm", new Client());
		return "clientPages/formulaireSuppression";
	}

	// Soumettre formulaire
	@RequestMapping(value = "/soumettreFormSupprimer", method = RequestMethod.POST)
	public String soumettreFormulaireSupprimer(Model model, @ModelAttribute("supprimerForm") Client client) {

		clientService.deleteClient(client.getReference_client());

		// MAJ de la liste
		List<Client> listeClient = clientService.getAllClient();
		model.addAttribute("clientListe", listeClient);
		return "clientPages/accueil";
	}

	// =======================Rechercher
	// Client==========================================
	// Afficher formulaire
	@RequestMapping(value = "/affichFormRechercher", method = RequestMethod.GET)
	public ModelAndView rechercherEmployeFormulaire() {
		return new ModelAndView("clientPages/formulaireRecherche", "clientForm", new Client());
	}

	// Soumettre formulaire
	@RequestMapping(value = "/soumettreFormRechercher", method = RequestMethod.POST)
	public String soumettreFormulaireRechercher(Model model, String reference) {
		Client client = clientService.getByReference(reference);

		// Envoi de l'objet
		model.addAttribute("client", client);
		return "clientPages/accueil";
	}

	// =======================Modifier
	// Client============================================
	// Afficher formulaire
	@RequestMapping(value = "/affichFormModifier", method = RequestMethod.GET)
	public ModelAndView modifierEmployeFormulaire() {

		List<Conseiller> listeConseiller = conseillerService.getAllConseiller();
		List<Client> listeClient = clientService.getAllClient();
		ModelAndView model = new ModelAndView();
		model.addObject("clientListe", listeClient);
		model.addObject("clientModifForm", new Client());
		model.addObject("conseillerListe", listeConseiller);
		model.setViewName("clientPages/formulaireModification");
		return model;
	}

	// Soumettre formulaire
	@RequestMapping(value = "/soumettreFormModifier", method = RequestMethod.POST)
	public String soumettreFormulaireModifier(Model model, @ModelAttribute("clientModifForm") Client client) {

		Conseiller conseiller = conseillerService
				.getConseillerByReference(client.getpConseiller().getReference_conseiller());
		client.setpConseiller(conseiller);
		clientService.updateClient(client);

		// MAJ de la liste
		List<Client> listeClient = clientService.getAllClient();
		model.addAttribute("clientListe", listeClient);
		return "clientPages/accueil";

	}

	// =======================Afficher
	// Client============================================
	@RequestMapping(value = "/accueil", method = RequestMethod.GET)
	public String accueil(ModelMap model) {

		List<Client> listeClient = clientService.getAllClient();
		model.addAttribute("clientListe", listeClient);
		return "clientPages/accueil";
	}

	// =======================Afficher Cours de la bourse
	// ============================================
	@RequestMapping(value = "/action", method = RequestMethod.GET)
	public String coursAction(ModelMap model) {
		Map<String, BigDecimal> coursAction = new HashMap<>();
		WebServiceBourse serviceBourse = new WebServiceBourse();
		coursAction = serviceBourse.getStocks();
		List<Action> listeAction = new ArrayList<>();

		for (int i = 0; i < coursAction.size(); i++) {
			Action action = new Action();
			action.setNom((String) coursAction.keySet().toArray()[i]);
			action.setCours((BigDecimal) coursAction.get(coursAction.keySet().toArray()[i]));
			listeAction.add(action);
		}

		model.addAttribute("actionListe", listeAction);

		return "clientPages/bourse";
	}

	// =======================Afficher Cours de la
	// bourse et formulaire============================================
	@RequestMapping(value = "/fortune", method = RequestMethod.GET)
	public String getClientFortune(ModelMap model) {
		// Listes des comptes VIP
		List<Compte> listeCompte = compteService.getAllCompte();
		List<Compte> listeCompteRiches = new ArrayList<>();
		for (Compte compte : listeCompte) {
			if (compte.getSolde() > 500000 && compte.isType()) {
				listeCompteRiches.add(compte);
			}
		}
		// Cours de la bourse

		List<Action> listeAction = new ArrayList<>();
		Map<String, BigDecimal> coursAction = new HashMap<>();
		WebServiceBourse serviceBourse = new WebServiceBourse();
		coursAction = serviceBourse.getStocks();
		for (int i = 0; i < coursAction.size(); i++) {
			Action action = new Action();
			action.setNom((String) coursAction.keySet().toArray()[i]);
			action.setCours((BigDecimal) coursAction.get(coursAction.keySet().toArray()[i]));
			listeAction.add(action);
		}

		// Retour des attributs model
		model.addAttribute("actionForm", new ClasseAssociation()); // formulaire
																	// pour
																	// boursicoter
		model.addAttribute("fortuneListe", listeCompteRiches); // liste des
																// comptes
																// riches
		model.addAttribute("actionListe", listeAction); // liste des actions
		return "clientPages/afficherFortune";
	}

	// =======================Envoi du
	// formulaire============================================
	@RequestMapping(value = "/soumettreAction", method = RequestMethod.POST)
	public String soumettreClientFortune(ModelMap model,
			@ModelAttribute("actionForm") ClasseAssociation classeAssociation) {
		Compte compte = compteService.getCompteByNumero(classeAssociation.getAssoCompte().getNumero());
		String nom_action = classeAssociation.getNom_action();

		int quantite = classeAssociation.getQuantite();
		//
		Map<String, BigDecimal> coursAction = new HashMap<>();
		WebServiceBourse serviceBourse = new WebServiceBourse();
		coursAction = serviceBourse.getValues();

		// Retourner le cours de l'action gr�ce � sa cl�
		BigDecimal cours = coursAction.get(classeAssociation.getNom_action());
		// Debuggage
		System.out.println("-----------" + coursAction.containsKey(classeAssociation.getNom_action()));
		System.out.println("compte : " + compte.getNumero());
		System.out.println("action : " + nom_action);
		System.out.println("cours : " + cours);
		System.out.println("quantite : " + quantite);
		Double somme = quantite * cours.doubleValue();
		try {
			compteService.retrait(compte, somme);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// -------------------- Retour des informations des comptes et de la
		// bourse----------------------//
		List<Compte> listeCompte = compteService.getAllCompte();
		List<Compte> listeCompteRiches = new ArrayList<>();
		for (Compte compte2 : listeCompte) {
			if (compte2.getSolde() > 500000 && compte2.isType()) {
				listeCompteRiches.add(compte2);
			}
		}
		// Cours de la bourse

		List<Action> listeAction = new ArrayList<>();
		Map<String, BigDecimal> coursAction2 = new HashMap<>();
		WebServiceBourse serviceBourse2 = new WebServiceBourse();
		coursAction2 = serviceBourse2.getStocks();
		for (int i = 0; i < coursAction2.size(); i++) {
			Action action = new Action();
			action.setNom((String) coursAction2.keySet().toArray()[i]);
			action.setCours((BigDecimal) coursAction2.get(coursAction2.keySet().toArray()[i]));
			listeAction.add(action);
		}

		// Retour des attributs model
		model.addAttribute("actionForm", new ClasseAssociation()); // formulaire
																	// pour
																	// boursicoter
		model.addAttribute("fortuneListe", listeCompteRiches); // liste des
																// comptes
																// riches
		model.addAttribute("actionListe", listeAction); // liste des actions
		return "clientPages/afficherFortune";
	}

	// -----------------------Simulation de pr�t----------------------///
	@RequestMapping(value = "/simulation", method = RequestMethod.GET)
	public String formulaireSimulation(ModelMap model) {
		List<Client> listeClient = clientService.getAllClient();
		model.addAttribute("listeClient", listeClient);
		model.addAttribute("simulationForm", new Pret());

		return "clientPages/simulationPret";
	}

	@RequestMapping(value = "/soumettreFormSimulation", method = RequestMethod.POST)
	public String simulation(ModelMap model, @ModelAttribute("simulationForm") Pret pret) {
		Client client = clientService.getByReference(pret.getpClient().getReference_client());
		List<Compte> listCompte = client.getPlListeCompte();
		if (listCompte == null) {
			return "accesRefusePage";
		}
		
		// R�cup�ration des attributs du pret
		double solde = 0;
		for (Compte compte : listCompte) {
			solde = solde + compte.getSolde();
		}
		double revenu = pret.getRevenue_client();
		int duree = pret.getDuree_mois();
		if (duree == 0) {
			return "accesRefusePage";
		}
		double montantPret = pret.getSomme_pret();
		// Calcul de l'indice de confiance
		double indice_confiance = revenu * 12 + solde;
		int categorie = 0;
		if (indice_confiance < 15000) {
			categorie = 6;
		} else if (indice_confiance < 20000) {
			categorie = 5;
		} else if (indice_confiance < 30000) {
			categorie = 4;
		} else if (indice_confiance < 40000) {
			categorie = 3;
		} else if (indice_confiance < 50000) {
			categorie = 2;
		} else {
			categorie = 1;
		}
		// Montant max du pret et taux d'int��t
		double coutPret = 0;
		double mensualite = 0;
		switch (categorie) {
		case 1:
			if (montantPret < 100000) {
				coutPret = montantPret * 1.03;
				mensualite = coutPret / duree;
			}
			break;
		case 2:
			if (montantPret < 50000) {
				coutPret = montantPret * 1.06;
				mensualite = coutPret / duree;
			}
			break;
		case 3:
			if (montantPret < 20000) {
				coutPret = montantPret * 1.09;
				mensualite = coutPret / duree;
			}
			break;
		case 4:
			if (montantPret < 10000) {
				coutPret = montantPret * 1.12;
				mensualite = coutPret / duree;
			}
			break;
		case 5:
			if (montantPret < 5000) {
				coutPret = montantPret * 1.15;
				mensualite = coutPret / duree;
			}
			break;
		}
		if (categorie == 0) {
			return "accesRefusePage";
		} else {
			Pret pretRetour = new Pret(pret.getpClient(), revenu, montantPret, duree);
			pretRetour.setCout_pret(coutPret);
			pretRetour.setMensualites(mensualite);
			pretRetour.setpClient(client);
			model.addAttribute("pret", pretRetour);
			// Liste des clients � retourner
			List<Client> listeClient = clientService.getAllClient();
			model.addAttribute("listeClient", listeClient);
			return "clientPages/simulationPret";
		}
	}
}
