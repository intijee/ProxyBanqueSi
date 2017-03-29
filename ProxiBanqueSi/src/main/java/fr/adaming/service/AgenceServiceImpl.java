package fr.adaming.service;

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

}
