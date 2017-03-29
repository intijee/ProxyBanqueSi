package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Agence;

public interface IAgenceService {
	
	public Agence getAgenceByRefService(String ref_agence);

	public List<Agence> getAllAgenceService();
}
