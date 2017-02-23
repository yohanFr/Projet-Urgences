package fr.yohan.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.ISpecialisationDao;
import fr.yohan.entity.Specialisation;

@Transactional
@Component
public class SpecialisationDaoImpl implements ISpecialisationDao{
	
	Logger log = Logger.getLogger(getClass());

	protected EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void save(Specialisation specialisation) {
		em.persist(specialisation);

	}

	@Override
	public void delete(Specialisation specialisation) {
		Specialisation toRemoved = em.merge(specialisation);
		em.remove(toRemoved);

	}

	@Override
	public Specialisation find(int specialisationID) {
		return em.find(Specialisation.class, specialisationID);
	}

	@Override
	public Specialisation update(Specialisation specialisation) {
		return em.merge(specialisation);
	}

	

}
