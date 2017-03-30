package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Client;
import fr.adaming.entities.Compte;

@Repository
public class CompteDaoImpl implements ICompteDao {

	@PersistenceContext
	private EntityManager em;
	

	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * @param Le compte a ajouter dans la base de données
	 */
	@Override
	public void addCompte(Compte compte) {
		
		em.persist(compte);

	}

	/**
	 * Methode pour supprimer un compte de la base de données
	 * @param Le compte à supprimer dans la base de données
	 */
	@Override
	public void deleteCompte(Compte compte) {
	 Compte co = getCompteById(compte.getId_compte());
		em.remove(co);
		

	}

	
	/**
	 * Methode pour modifier un compte dans la base de données
	 * @param Le compte à modifier dans la base de données
	 */
	@Override
	public void updateCompte(Compte compte) {
		
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
		
		em.merge(compteUpdate);

	}

	
	/**
	 * Methode pour retrouver un compte grâce a son id
	 * @param L'id du compte à retrouver
	 * @return Le compte retrouvé
	 */
	@Override
	public Compte getCompteById(int id) {
		
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
			
		// Ecriture de la requete
		String req="select c from Compte c";
		
		Query query=em.createQuery(req);
		
		return query.getResultList();
	}

	
	/**
	 * Methode pour deposer de l'argent sur un compte
	 * @param Le compte à créditer
	 * @param La somme à créditer
	 */
	@Override
	public void depot(Compte compte, double somme) {
		
		// Ecriture de la requete
		String req="select c from Compte c where c.numero=:pNumero";
		
		Query query=em.createQuery(req);
		
		query.setParameter("pNumero", compte.getNumero());
		
		compte=(Compte) query.getSingleResult();
		
		compte.setSolde(compte.getSolde()+somme);
		
		em.merge(compte);
	}

	
	/**
	 * Methode pour retirer de l'argent sur un compte
	 * @param Le compte à débiter
	 * @param La somme à débiter
	 */
	@Override
	public void retrait(Compte compte, double somme) {


		// Ecriture de la requete
				String req="select c from Compte c where c.numero=:pNumero";
				
				Query query=em.createQuery(req);
				
				query.setParameter("pNumero", compte.getNumero());
				
				compte=(Compte) query.getSingleResult();
				
				compte.setSolde(compte.getSolde()-somme);
				
				em.merge(compte);
		
	}


}
