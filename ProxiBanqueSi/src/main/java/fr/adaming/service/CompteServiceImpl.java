package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.dao.ICompteDao;
import fr.adaming.entities.Compte;

@Service
@Transactional
public class CompteServiceImpl implements ICompteService {

	@Autowired
	private ICompteDao compteDao;

	/**
	 * @param compteDao
	 *            the compteDao to set
	 */
	public void setCompteDao(ICompteDao compteDao) {
		this.compteDao = compteDao;
	}

	@Autowired
	private IClientDao clientDao;

	/**
	 * @param clientDao
	 *            the clientDao to set
	 */
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public void addCompte(Compte compte) throws Exception {

		List<Compte> listeCompteClient = compte.getpClient().getPlListeCompte();
		
		int verif = 0;
		
		if (compte.isType() == true) {
			
			for (Compte cpt : listeCompteClient) {
				
				if (cpt.isType() == true) {
					
					verif = 1;
					
				} else {
					
					verif = 0;
					
				}
			}
		} else {
			
			for (Compte cpt : listeCompteClient) {
				
				if (cpt.isType() == false) {
					
					verif = 1;
					
				} else {
					
					verif = 0;
				}
			}
		}

		if (verif == 0) {
			compteDao.addCompte(compte);
		} else {
			throw new Exception("Le nombre de compte est dépassé");
		}

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
