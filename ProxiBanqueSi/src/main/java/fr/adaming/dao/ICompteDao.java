package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Client;
import fr.adaming.entities.Compte;

public interface ICompteDao {

	
	public void addCompte(Compte compte);
	
	public void deleteCompte(Compte compte);
	
	public void updateCompte(Compte compte);
	
	public Compte getCompteById(int id);
	
	public Compte getCompteByNumero(long numero);
	
	public List<Compte> getAllCompte();
	
	public void depot(Compte compte, double somme);
	
	public void retrait(Compte compte, double somme);

	
}
