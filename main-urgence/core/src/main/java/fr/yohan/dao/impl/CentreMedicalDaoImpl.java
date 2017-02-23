package fr.yohan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.ICentreMedicalDao;
import fr.yohan.entity.CentreMedical;
import fr.yohan.entity.GPSLoc;


@Transactional
@Component
public class CentreMedicalDaoImpl implements ICentreMedicalDao {

	Logger log = Logger.getLogger(getClass());

	protected EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void save(CentreMedical centreMedical) {
		em.persist(centreMedical);

	}

	@Override
	public void delete(CentreMedical centreMedical) {
		CentreMedical toRemoved = em.merge(centreMedical);
		em.remove(toRemoved);

	}

	@Override
	public CentreMedical find(int centreMedicalID) {
		return em.find(CentreMedical.class, centreMedicalID);
	}

	@Override
	public CentreMedical update(CentreMedical centreMedical) {
		return em.merge(centreMedical);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CentreMedical> getCentreMedicalByLoc(GPSLoc gpsLocNE,GPSLoc gpsLocSW) {
		Query q = em.createQuery("FROM CentreMedical where "
				+ "gpsLoc.latitude <"+gpsLocNE.getLatitude()+" "
				+ "AND gpsLoc.longitude <"+gpsLocNE.getLongitude()+" "
						+ "AND gpsLoc.latitude >"+gpsLocSW.getLatitude()+" "
						+ "AND gpsLoc.longitude >"+gpsLocSW.getLongitude()
						);
		return (List<CentreMedical>) q.getResultList();
		}

}
