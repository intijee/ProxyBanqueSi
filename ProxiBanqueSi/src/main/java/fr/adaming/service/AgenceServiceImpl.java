package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgenceDao;
import fr.adaming.entities.Agence;

@Service
@Transactional
public class AgenceServiceImpl implements IAgenceService{

	@Autowired
	IAgenceDao agenceDao;
	
	/**
	 * @param agenceDao the agenceDao to set
	 */
	public void setAgenceDao(IAgenceDao agenceDao) {
		this.agenceDao = agenceDao;
	}

	@Override
	public Agence getAgenceByRefService(String ref_agence) {
		
		return agenceDao.getAgenceByRef(ref_agence);
	}

	@Override
	public List<Agence> getAllAgenceService() {
		
		return agenceDao.getAllAgence();
	}

	@Override
	public void addAgence(Agence agence) {
		agenceDao.addAgence(agence);
		
	}

	@Override
	public void deleteAgence(String reference_agence) {
		agenceDao.deleteAgence(reference_agence);
		
	}

	@Override
	public void updateAgence(Agence agence) {
		agenceDao.updateAgence(agence);
		
	}

}
