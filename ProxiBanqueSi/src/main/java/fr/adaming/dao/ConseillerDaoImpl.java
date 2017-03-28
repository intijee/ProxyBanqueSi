package fr.adaming.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.adaming.entities.Conseiller;

@Repository
public class ConseillerDaoImpl implements IConseillerDao{

	@PersistenceContext
	EntityManager em;
	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Conseiller> getAllConseiller() {
		Query query;
		String request = "SELECT c FROM Conseiller c";
		query  = em.createQuery(request);
		if(query.getResultList().size()!=0){
			return query.getResultList();
		}else{
			return null;
		}
	}

	@Override
	public Conseiller getConseillerByReference(String reference_conseiller) {
		
		String req = "Select c from Conseiller c Where c.reference_conseiller =:pRefConseiller";
		Query query = em.createQuery(req);
		query.setParameter("pRefConseiller", reference_conseiller);
		 
		if (query.getSingleResult() != null){
			return (Conseiller) query.getSingleResult();
		}else{
			return null;
		}
	}

	@Override
	public Conseiller getConseillerById(int id_conseiller) {
			
		return em.find(Conseiller.class, id_conseiller);
	}

	@Override
	public void addConseiller(Conseiller conseiller) {
		em.persist(conseiller);
		
	}

	@Override
	public void updateConseiller(Conseiller conseiller) {
		em.merge(conseiller);
		
	}

	@Override
	public void deleteConseiller(String reference_conseiller) {
		Conseiller conseiller = this.getConseillerByReference(reference_conseiller);
		em.remove(conseiller);
		
	}

}
