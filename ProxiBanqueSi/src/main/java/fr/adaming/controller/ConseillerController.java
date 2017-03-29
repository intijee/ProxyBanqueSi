package fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.entities.Agence;
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
		
		return "conseillerPages/accueil";
		
	}
	
	@RequestMapping(value="/ajouter",method=RequestMethod.GET)
	public String afficherFormAjouter(Model model){
		
		model.addAttribute("ajouterForm",new Conseiller());
		
		return "conseillerPages/ajouter";
	}
	
	
	@RequestMapping(value="/soumettreAjouter",method=RequestMethod.POST)
	public String soumettreFormulaireAjouter(Model model,@ModelAttribute("ajouterForm") Conseiller conseiller){
		
		
		Agence agence=agenceService.getAgenceByRefService(conseiller.getpAgence().getReference_agence());
		
		conseiller.setpAgence(agence);
		
		conseillerService.addConseiller(conseiller);
		
		return "conseillerPages/accueil";
		
	}
	
	@RequestMapping(value="/modifier",method=RequestMethod.GET)
	public String afficherFormModifier(Model model){
		
		
		model.addAttribute("modifierForm",new Conseiller());
		
		return "conseillerPages/modifier";
	}
	
	@RequestMapping(value="/soumettreModifier",method=RequestMethod.POST)
	public String soumettreFormulaireModifier(Model model, @ModelAttribute("modifierForm") Conseiller conseiller){
		
		Conseiller cons=conseillerService.getConseillerByReference(conseiller.getReference_conseiller());
		
		cons.setNom(conseiller.getNom());
		
		cons.setPrenom(conseiller.getPrenom());
		
		Agence agence=agenceService.getAgenceByRefService(conseiller.getpAgence().getReference_agence());
		
		cons.setpAgence(agence);
		
		conseillerService.updateConseiller(cons);
		
		return "conseillerPages/accueil";
	}
	
	

}
