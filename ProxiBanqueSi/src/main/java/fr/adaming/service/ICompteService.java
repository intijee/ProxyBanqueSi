package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Compte;

public interface ICompteService {

	

	public void addCompte(Compte compte) throws Exception;
	
	public void deleteCompte(Compte compte);
	
	public void updateCompte(Compte compte);
	
	public Compte getCompteById(int id);
	
	public Compte getCompteByNumero(long numero);
	
	public List<Compte> getAllCompte();
	
	public void depot(Compte compte, double somme);
	
	public void retrait(Compte compte, double somme) throws Exception;
	
	public void virement(Compte debiteur, Compte credite, double somme) throws Exception;
	
	
}

