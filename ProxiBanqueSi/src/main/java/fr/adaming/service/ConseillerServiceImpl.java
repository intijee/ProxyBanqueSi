package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.IConseillerDao;
import fr.adaming.entities.Conseiller;

public class ConseillerServiceImpl implements IConseillerService{

	private IConseillerDao conseillerDao;
	
	/**
	 * setter 
	 * @param conseillerDao
	 */
	public void setConseillerDao(IConseillerDao conseillerDao) {
		this.conseillerDao = conseillerDao;
	}

	/**
	 * Methode qui renvoie la liste des conseillers existants
	 */
	@Override
	public List<Conseiller> getAllConseiller() {
		return conseillerDao.getAllConseiller();
	}

	/**
	 * Methode qui renvoie un conseiller trouve par sa reference
	 */
	@Override
	public Conseiller getConseillerByReference(String reference_conseiller) {
		return conseillerDao.getConseillerByReference(reference_conseiller);
	}

	/**
	 * Methode qui renvoie un conseiller trouve par son id
	 */
	@Override
	public Conseiller getConseillerById(int id_conseiller) {
		return conseillerDao.getConseillerById(id_conseiller);
		 
	}
	
	/**
	 * Methode qui ajoute un conseiller dans la base
	 */
	@Override
	public void addConseiller(Conseiller conseiller) {
		conseillerDao.addConseiller(conseiller);
		
	}

	/**
	 * Methode qui met a jour un conseiller de la base
	 */
	@Override
	public void updateConseiller(Conseiller conseiller) {
		conseillerDao.updateConseiller(conseiller);
		
	}

	/**
	 * Methode qui supprime un conseiller de la base renseigné par sa reference
	 */
	@Override
	public void deleteConseiller(String reference_conseiller) {
		conseillerDao.deleteConseiller(reference_conseiller);
		
	}

}
