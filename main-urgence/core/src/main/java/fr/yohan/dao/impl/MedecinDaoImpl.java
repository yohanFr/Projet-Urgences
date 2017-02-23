package fr.yohan.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.IMedecinDao;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Medecin;
import fr.yohan.entity.Professionnel;

@Transactional
@Component
public class MedecinDaoImpl implements IMedecinDao {

	Logger log = Logger.getLogger(getClass());

	protected EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void save(Medecin medecin) {
		em.persist(medecin);
	}

	@Override
	public void delete(Medecin medecin) {
		Medecin toRemoved = em.merge(medecin);
		em.remove(toRemoved);
	}

	@Override
	public Medecin find(int medecinID) {
		return em.find(Medecin.class, medecinID);
	}

	@Override
	public Medecin update(Medecin medecin) {
		return em.merge(medecin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medecin> getMedecinByLoc(GPSLoc gpsLocNE, GPSLoc gpsLocSW) {
		Query q = em.createQuery(
				"FROM Medecin where " + "gpsLoc.latitude <" + gpsLocNE.getLatitude() + " "
						+ "AND gpsLoc.longitude <" + gpsLocNE.getLongitude() + " " + "AND gpsLoc.latitude >"
						+ gpsLocSW.getLatitude() + " " + "AND gpsLoc.longitude >" + gpsLocSW.getLongitude());
		List<Medecin> meds = q.getResultList();
		System.out.println(meds);
		return meds;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medecin> getAllMedecins() {
		Query q = em.createQuery("FROM Medecin");
//		List<Professionnel> pros = q.getResultList();
//		System.out.println(pros);
		return q.getResultList();
	}

}
