package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Agence;
import fr.adaming.entities.Compte;

public interface IAgenceService {
	
	public Agence getAgenceByRefService(String ref_agence);

	public List<Agence> getAllAgenceService();
	
	public void addAgence (Agence agence);
	public void deleteAgence (String reference_agence);
	public void updateAgence (Agence agence);
	
	public List<Compte> getCompteByAgenceService(Agence agence);
}
