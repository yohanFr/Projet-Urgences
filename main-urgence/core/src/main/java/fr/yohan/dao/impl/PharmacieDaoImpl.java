package fr.yohan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.IPharmacieDao;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Pharmacie;

@Transactional
@Component
public class PharmacieDaoImpl implements IPharmacieDao {

	Logger log = Logger.getLogger(getClass());

	protected EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void save(Pharmacie pharmacie) {
		em.persist(pharmacie);

	}

	@Override
	public void delete(Pharmacie pharmacie) {
		Pharmacie toRemoved = em.merge(pharmacie);
		em.remove(toRemoved);

	}

	@Override
	public Pharmacie find(int pharmacieID) {
		return em.find(Pharmacie.class, pharmacieID);
	}

	@Override
	public Pharmacie update(Pharmacie pharmacie) {
		return em.merge(pharmacie);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pharmacie> getPharmacieByLoc(GPSLoc gpsLocNE,GPSLoc gpsLocSW) {
		Query q = em.createQuery("FROM Pharmacie where "
				+ "gpsLoc.latitude <"+gpsLocNE.getLatitude()+" "
				+ "AND gpsLoc.longitude <"+gpsLocNE.getLongitude()+" "
						+ "AND gpsLoc.latitude >"+gpsLocSW.getLatitude()+" "
						+ "AND gpsLoc.longitude >"+gpsLocSW.getLongitude()
						);
		System.out.println(q);
		return (List<Pharmacie>) q.getResultList();
	}

}
