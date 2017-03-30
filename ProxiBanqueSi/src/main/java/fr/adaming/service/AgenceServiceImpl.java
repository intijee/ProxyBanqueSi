package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgenceDao;
import fr.adaming.dao.IConseillerDao;
import fr.adaming.entities.Agence;
import fr.adaming.entities.Conseiller;

@Service
@Transactional
public class AgenceServiceImpl implements IAgenceService {
	@Autowired
	IConseillerDao conseillerDao;
	/**
	 * @param conseillerDao
	 *            the conseillerDao to set
	 */
	public void setConseillerDao(IConseillerDao conseillerDao) {
		this.conseillerDao = conseillerDao;
	}

	@Autowired
	IAgenceDao agenceDao;

	/**
	 * @param agenceDao
	 *            the agenceDao to set
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
		Conseiller conseiller = new Conseiller(agence.getNom_gerant(), agence.getPassword_gerant(),
				agence.getReference_gerant());
		conseiller.setpAgence(agence);
		conseiller.setActivated(true);
		conseiller.setRole_id(2);
		conseillerDao.addConseiller(conseiller);
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
