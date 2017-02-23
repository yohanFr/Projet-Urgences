package fr.yohan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.IInfirmierDao;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Infirmier;


@Transactional
@Component
public class InfirmierDaoImpl implements IInfirmierDao {

	Logger log = Logger.getLogger(getClass());

	protected EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void save(Infirmier infirmier) {
		em.persist(infirmier);

	}

	@Override
	public void delete(Infirmier infirmier) {
		Infirmier toRemoved = em.merge(infirmier);
		em.remove(toRemoved);

	}

	@Override
	public Infirmier find(int infirmierID) {
		return em.find(Infirmier.class, infirmierID);
	}

	@Override
	public Infirmier update(Infirmier infirmier) {
		return em.merge(infirmier);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Infirmier> getInfirmierByLoc(GPSLoc gpsLocNE,GPSLoc gpsLocSW) {
		Query q = em.createQuery("FROM Infirmier where "
				+ "gpsLoc.latitude <"+gpsLocNE.getLatitude()+" "
				+ "AND gpsLoc.longitude <"+gpsLocNE.getLongitude()+" "
						+ "AND gpsLoc.latitude >"+gpsLocSW.getLatitude()+" "
						+ "AND gpsLoc.longitude >"+gpsLocSW.getLongitude()
						);
		return (List<Infirmier>) q.getResultList();

		}

}
