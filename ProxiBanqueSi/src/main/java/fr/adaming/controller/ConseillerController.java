package fr.adaming.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Agence;
import fr.adaming.entities.Compte;
import fr.adaming.entities.Conseiller;
import fr.adaming.service.IAgenceService;
import fr.adaming.service.IConseillerService;

@Controller
@RequestMapping("/conseiller")
public class ConseillerController {
	
	@Autowired
	private IConseillerService conseillerService;

	/**
	 * @param conseillerService the conseillerService to set
	 */
	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}
	
	@Autowired
	private IAgenceService agenceService;
	
	
	
	/**
	 * @param agenceService the agenceService to set
	 */
	public void setAgenceService(IAgenceService agenceService) {
		this.agenceService = agenceService;
	}

	@RequestMapping(value="/accueilConseiller",method=RequestMethod.GET)
	public String accueil(ModelMap model){
		List<Conseiller> listeConseiller = conseillerService.getAllConseiller();
		model.addAttribute("conseillerListe",listeConseiller);
		return "conseillerPages/accueil";
		
	}
	
	@RequestMapping(value="/ajouter",method=RequestMethod.GET)
	public String afficherFormAjouter(Model model){
		
		model.addAttribute("ajouterForm",new Conseiller());
		List<Agence> listeAgence=agenceService.getAllAgenceService();
		model.addAttribute("agenceListe",listeAgence);
		
		
		return "conseillerPages/ajouter";
	}
	
	
	@RequestMapping(value="/soumettreAjouter",method=RequestMethod.POST)
	public String soumettreFormulaireAjouter(Model model,@ModelAttribute("ajouterForm") Conseiller conseiller){
		
		
		Agence agence=agenceService.getAgenceByRefService(conseiller.getpAgence().getReference_agence());
		
		conseiller.setActivated(true);
		conseiller.setRole_id(1);
		conseiller.setpAgence(agence);
		
		conseillerService.addConseiller(conseiller);
		List<Conseiller> listeConseiller = conseillerService.getAllConseiller();
		model.addAttribute("conseillerListe",listeConseiller);
		
		return "conseillerPages/accueil";
		
	}
	
	@RequestMapping(value="/modifier",method=RequestMethod.GET)
	public String afficherFormModifier(Model model){
		
		List<Agence> listeAgence=agenceService.getAllAgenceService();
		List<Conseiller> listeConseiller = conseillerService.getAllConseiller();
		model.addAttribute("conseillerListe",listeConseiller);
		
		model.addAttribute("agenceListe",listeAgence);
		
		model.addAttribute("modifierForm",new Conseiller());
		
		return "conseillerPages/modifier";
	}
	
	@RequestMapping(value="/soumettreModifier",method=RequestMethod.POST)
	public String soumettreFormulaireModifier(Model model, @ModelAttribute("modifierForm") Conseiller conseiller){
		
		System.out.println(conseiller.getpAgence().getReference_agence());
		Conseiller cons=conseillerService.getConseillerByReference(conseiller.getReference_conseiller());
		
		cons.setNom(conseiller.getNom());
		
		cons.setPrenom(conseiller.getPrenom());
		
		Agence agence=agenceService.getAgenceByRefService(conseiller.getpAgence().getReference_agence());
		
		cons.setpAgence(agence);
		
		conseillerService.updateConseiller(cons);
		List<Conseiller> listeConseiller = conseillerService.getAllConseiller();
		model.addAttribute("conseillerListe",listeConseiller);
		
		return "conseillerPages/accueil";
	}
	
	
	@RequestMapping(value="/supprimer",method=RequestMethod.GET)
	public String afficherFormSupprimer(Model model){
		
		List<Conseiller> listeConseiller = conseillerService.getAllConseiller();
		model.addAttribute("conseillerListe",listeConseiller);
		
		model.addAttribute("supprimerForm",new Conseiller());
		
		return "conseillerPages/supprimer";
	}
	
	
	
	@RequestMapping(value="/soumettreSupprimer",method=RequestMethod.POST)
	public String soumettreFormulaireSupprimer(Model model, @ModelAttribute("supprimerForm") Conseiller conseiller){
		
		conseillerService.deleteConseiller(conseiller.getReference_conseiller());
		List<Conseiller> listeConseiller = conseillerService.getAllConseiller();
		model.addAttribute("conseillerListe",listeConseiller);
		return "conseillerPages/accueil";
	}
	
	@RequestMapping(value="/ajouterAgence",method=RequestMethod.GET)
	public String afficherFormAjouterAgence(Model model){
		
		model.addAttribute("agenceForm",new Agence());
		
		return "conseillerPages/ajouterAgence";
	}
	
	@RequestMapping(value="/soumettreFormAjouterAgence", method=RequestMethod.POST)
	public String soumettreFormAjouterAgence(Model model, @ModelAttribute("agenceForm") Agence agence){
		
		
		agenceService.addAgence(agence);
		
		List<Agence> agenceListe=agenceService.getAllAgenceService();
		
		model.addAttribute("listeAgence",agenceListe);
		
		return "conseillerPages/informationAgence";
	}
	
	//=======================Afficher liste de toutes les agences ============================================
	@RequestMapping(value= "/accueilAgence", method = RequestMethod.GET)
	public String accueilAgence(ModelMap model){
		
		List<Agence> listeAgence =agenceService.getAllAgenceService();
		model.addAttribute("agenceListe",listeAgence);
		
		model.addAttribute("auditForm", new Agence());
		return "conseillerPages/informationAgence";
		
		
	}
	
	//===================Afficher liste des comptes de l'agence ==========================
	
	@RequestMapping(value="/auditAgence", method = RequestMethod.GET)
	public String auditAgence(ModelMap model,@ModelAttribute("auditForm") Agence agence){
		List<Compte> listeCompteEntreprise = new ArrayList<>();		
		List<Compte> listeCompteHumain = new ArrayList<>();
		
		List<Compte> listeCompte = agenceService.getCompteByAgenceService(agence);
		
		for(Compte c : listeCompte){
			boolean b = c.getpClient().getHumain_0_entreprise_1();
			if(b == true){
				listeCompteEntreprise.add(c);
			}else{
				listeCompteHumain.add(c);
			}
		}
		
		model.addAttribute("entrepriseListe", listeCompteEntreprise);
		model.addAttribute("humainListe", listeCompteHumain);
		return "conseillerPages/auditAgence";
	}
	

}
