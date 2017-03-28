package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Compte;

public interface ICompteService {

	

	public void addCompte(Compte compte);
	
	public void deleteCompte(Compte compte);
	
	public void updateCompte(Compte compte);
	
	public Compte getCompteById(int id);
	
	public Compte getCompteByNumero(long numero);
	
	public List<Compte> getAllCompte();
	
	
}

