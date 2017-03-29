package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Agence;

public interface IAgenceDao {
	
	public Agence getAgenceByRef(String ref_agence);
	public List<Agence> getAllAgence ();

}
