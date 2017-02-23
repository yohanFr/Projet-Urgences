package fr.yohan.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import fr.yohan.dao.IAdresseDao;
import fr.yohan.entity.Adresse;


@Transactional
@Component
public class AdresseDaoImpl implements IAdresseDao {

	Logger log = Logger.getLogger(getClass());

	protected EntityManager em;

	@PersistenceContext(unitName = "entityManagerFactory")
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void save(Adresse adresse) {
		em.persist(adresse);
	}

	@Override
	public void delete(Adresse adresse) {
		Adresse toRemoved = em.merge(adresse);
		em.remove(toRemoved);
}

	@Override
	public Adresse find(int adresseID) {
		return em.find(Adresse.class, adresseID);
			}

	@Override
	public Adresse update(Adresse adresse) {
		return em.merge(adresse);
	}

}
