package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Compte;

@Repository
public class CompteDaoImpl implements ICompteDao {

	@Autowired
	private EntityManagerFactory emf;
	
	
	/**
	 * @param emf the emf to set
	 */
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	/**
	 * @param Le compte a ajouter dans la base de données
	 */
	@Override
	public void addCompte(Compte compte) {
		
		EntityManager em=emf.createEntityManager();
		
		em.persist(compte);

	}

	/**
	 * Methode pour supprimer un compte de la base de données
	 * @param Le compte à supprimer dans la base de données
	 */
	@Override
	public void deleteCompte(Compte compte) {
		
		EntityManager em=emf.createEntityManager();
		
		em.remove(compte);
		

	}

	
	/**
	 * Methode pour modifier un compte dans la base de données
	 * @param Le compte à modifier dans la base de données
	 */
	@Override
	public void updateCompte(Compte compte) {
		
		EntityManager em=emf.createEntityManager();
		
		// On retrouve le compte grâce à son id 
		Compte compteUpdate=em.find(Compte.class, compte.getId_compte());
		
		// Affectation des nouvelles valeurs
		compteUpdate.setSolde(compte.getSolde());
		compteUpdate.setNumero(compte.getNumero());
		
		compteUpdate.setDate_ouverture(compte.getDate_ouverture());
		
		compteUpdate.setType(compte.isType());
		
		
		// Si le compte est un compte épargne
		if (compte.isType()==false){
		compteUpdate.setDecouvert(compte.getDecouvert());
		}
		
		// Si le compte est un compte courant
		else {
		compteUpdate.setTaux(compte.getTaux());
		}

	}

	
	/**
	 * Methode pour retrouver un compte grâce a son id
	 * @param L'id du compte à retrouver
	 * @return Le compte retrouvé
	 */
	@Override
	public Compte getCompteById(int id) {
		
		EntityManager em=emf.createEntityManager();
		
		if (em.find(Compte.class, id)!=null){
			return em.find(Compte.class, id);
		} else {
			return null;
		}
		
		
	}

	/**
	 * Methode pour retrouver un compte dans la base de données grace a son numéro
	 * @param Le numéro du compte à retrouver
	 * @return Le compte retrouvé
	 */
	@Override
	public Compte getCompteByNumero(long numero) {
		
		EntityManager em=emf.createEntityManager();
		
		// Ecriture de la requete 
		String req="select c from Compte c where c.numero=:pNumero";
		
		Query query=em.createQuery(req);
		
		query.setParameter("pNumero", numero);
		
		if (query.getSingleResult()!=null){
			return (Compte) query.getSingleResult();
		} else {
			return null;
		}
		
	}

	/**
	 * Methode pour recupérer la liste des comptes
	 * @return La liste des comptes
	 */
	@Override
	public List<Compte> getAllCompte() {
		
		EntityManager em=emf.createEntityManager();
		
		// Ecriture de la requete
		String req="select c from Compte c";
		
		Query query=em.createQuery(req);
		
		return query.getResultList();
	}

}
