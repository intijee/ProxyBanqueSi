package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Agence;
import fr.adaming.entities.Client;

public interface IAgenceDao {
	
	public Agence getAgenceByRef(String ref_agence);
	public List<Agence> getAllAgence ();
	public void addAgence (Agence agence);
	public void deleteAgence (String reference_agence);
	public void updateAgence (Agence agence);
}
