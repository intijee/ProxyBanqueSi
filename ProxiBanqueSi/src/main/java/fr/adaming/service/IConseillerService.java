package fr.adaming.service;

import java.util.List;

import fr.adaming.entities.Agence;
import fr.adaming.entities.Conseiller;

public interface IConseillerService {

	public List<Conseiller> getAllConseiller();
	public Conseiller getConseillerByReference(String reference_conseiller);
	public Conseiller getConseillerById(int id_conseiller);
	public void addConseiller(Conseiller conseiller);
	public void updateConseiller(Conseiller conseiller);
	public void deleteConseiller(String reference_conseiller);
	
	public void associerAgenceConseiller(Agence agence, Conseiller conseiller);
}
