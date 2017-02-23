package fr.yohan.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.IGPSLocDao;
import fr.yohan.entity.GPSLoc;


@Transactional
@Component
public class GPSLocDaoImpl implements IGPSLocDao {

	Logger log = Logger.getLogger(getClass());

	protected EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void save(GPSLoc gpsLoc) {
		em.persist(gpsLoc);

	}

	@Override
	public void delete(GPSLoc gpsLoc) {
		GPSLoc toRemoved = em.merge(gpsLoc);
		em.remove(toRemoved);

	}

	@Override
	public GPSLoc find(int gpsLocID) {
		return em.find(GPSLoc.class, gpsLocID);
	}

	@Override
	public GPSLoc update(GPSLoc gpsLoc) {
		return em.merge(gpsLoc);
	}

	}
