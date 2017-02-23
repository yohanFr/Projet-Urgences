package fr.yohan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.IFormationDao;
import fr.yohan.entity.Formation;

@Transactional
@Component
public class FormationDaoImpl implements IFormationDao {
	
	Logger log = Logger.getLogger(getClass());

	protected EntityManager em;

	@PersistenceContext(unitName="entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void save(Formation entity) {
		em.persist(entity);
	}

	public void delete(Formation entity) {
		Formation toRemoved = em.merge(entity);
		em.remove(toRemoved);

	}

	public Formation find(int entityID) {
		return em.find(Formation.class, entityID);
	}

	@SuppressWarnings("unchecked")
	public List<Formation> findAll() {
		Query q = em.createQuery("FROM Formation" );
			return (List<Formation>) q.getResultList();
	}

	public Formation update(Formation entity) {
		return em.merge(entity);
	}
}

