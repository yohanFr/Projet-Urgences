package fr.yohan.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.ITelephoneDao;
import fr.yohan.entity.Telephone;


@Transactional
@Component
public class TelephoneDaoImpl implements ITelephoneDao {

	Logger log = Logger.getLogger(getClass());

	protected EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void save(Telephone telephone) {
		em.persist(telephone);

	}

	@Override
	public void delete(Telephone telephone) {
		Telephone toRemoved = em.merge(telephone);
		em.remove(toRemoved);

	}

	@Override
	public Telephone find(int telephoneID) {
		return em.find(Telephone.class, telephoneID);
	}

	@Override
	public Telephone update(Telephone telephone) {
		return em.merge(telephone);
	}

	}
