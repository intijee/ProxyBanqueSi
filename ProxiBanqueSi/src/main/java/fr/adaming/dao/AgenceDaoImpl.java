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

}
