package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Agence;

@Repository
public class AgenceDaoImpl implements IAgenceDao{

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}



	@Override
	public Agence getAgenceByRef(String ref_agence) {
		
	String req = "select a from Agence a where a.reference_agence=:pRefAgence";
	Query query = em.createQuery(req);
	query.setParameter("pRefAgence", ref_agence);
		if ((Agence) query.getSingleResult() != null){
		return (Agence) query.getSingleResult();
	}else{
		return null;
	}
	}



	@Override
	public List<Agence> getAllAgence() {
		String req = "select a from Agence a";
		Query query = em.createQuery(req);
		if (query.getResultList().size()!=0) {
			return query.getResultList();
		}else{
			return null;
		}
	}



	@Override
	public void addAgence(Agence agence) {
		em.persist(agence);
		
	}



	@Override
	public void deleteAgence(String reference_agence) {
		Agence a = getAgenceByRef(reference_agence);
		if (a != null) {
			 em.remove(a);
		} 
		
	}



	@Override
	public void updateAgence(Agence agence) {
		Agence a = em.find(Agence.class, agence.getId());
		a.setDate_creation(agence.getDate_creation());
		a.setNom_gerant(agence.getNom_gerant());
		a.setReference_gerant(agence.getReference_gerant());
		a.setReference_agence(agence.getReference_agence());
		a.setPassword_gerant(agence.getPassword_gerant());
		em.merge(a);
	}

}
