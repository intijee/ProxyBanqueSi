package fr.adaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.entities.Agence;

public class AgenceDaoImpl implements IAgenceDao{

	@Autowired
	private EntityManager em;
	
	/**
	 * @param em the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}



	@Override
	public Agence getAgenceByRef(String ref_agence) {
		
	String req = "Select a from Agence ca Where a.reference_agence=:pRefAgence";
	Query query = em.createQuery(req);
	query.setParameter("pRefAgence", ref_agence);
		if ((Agence) query.getSingleResult() != null){
		return (Agence) query.getSingleResult();
	}else{
		return null;
	}
	}

}
