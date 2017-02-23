package fr.yohan.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.yohan.dao.IProfessionnelDao;
import fr.yohan.entity.GPSLoc;
import fr.yohan.entity.Professionnel;

@Transactional
@Component
public class ProfessionnelDaoImpl implements IProfessionnelDao {

	Logger log = Logger.getLogger(getClass());

	protected EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void save(Professionnel medecin) {
		em.persist(medecin);
	}

	@Override
	public void delete(Professionnel medecin) {
		Professionnel toRemoved = em.merge(medecin);
		em.remove(toRemoved);
	}

	@Override
	public Professionnel find(int medecinID) {
		return em.find(Professionnel.class, medecinID);
	}

	@Override
	public Professionnel update(Professionnel medecin) {
		return em.merge(medecin);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professionnel> getProfessionnelByLoc(GPSLoc gpsLocNE, GPSLoc gpsLocSW) {
		Query q = em.createQuery("FROM professionnel where PRO_TYPE='MED' AND " + "gpsLoc.latitude <" + gpsLocNE.getLatitude() + " "
				+ "AND gpsLoc.longitude <" + gpsLocNE.getLongitude() + " " + "AND gpsLoc.latitude >"
				+ gpsLocSW.getLatitude() + " " + "AND gpsLoc.longitude >" + gpsLocSW.getLongitude());
		return (List<Professionnel>) q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professionnel> getAllProfessionnels() {
		Query q = em.createQuery("FROM professionnel where PRO_TYPE='MED'");
		List<Professionnel> res = q.getResultList();
		System.out.println(res);
		return res;
	}

}
