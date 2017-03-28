package fr.adaming.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICompteDao;
import fr.adaming.entities.Compte;

@Service
@Transactional
public class CompteServiceImpl implements ICompteService {

	private ICompteDao compteDao;

	/**
	 * @param compteDao the compteDao to set
	 */
	public void setCompteDao(ICompteDao compteDao) {
		this.compteDao = compteDao;
	}

	@Override
	public void addCompte(Compte compte) {


		compteDao.addCompte(compte);

	}

	@Override
	public void deleteCompte(Compte compte) {


		compteDao.deleteCompte(compte);

	}

	@Override
	public void updateCompte(Compte compte) {
		compteDao.updateCompte(compte);

	}

	@Override
	public Compte getCompteById(int id) {
	
		return compteDao.getCompteById(id);
	}

	@Override
	public Compte getCompteByNumero(long numero) {
	
		return compteDao.getCompteByNumero(numero);
	}

	@Override
	public List<Compte> getAllCompte() {
		
		return compteDao.getAllCompte();
	}

}