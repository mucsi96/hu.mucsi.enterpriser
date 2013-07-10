package hu.mucsi.enterpriser.ejb;

import hu.mucsi.enterpriser.jpa.User;
import hu.mucsi.enterpriser.jpa.User_;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.primefaces.model.SortOrder;

@Named
@Stateless
public class UserBean {

	@PersistenceContext
	EntityManager em;

	// @EJB
	// private MyObjFacade myObjFacade;

	public User findUserById(String id) {
		return em.createNamedQuery("User.findById", User.class).setParameter("id", id).getSingleResult();
	}

	public List<User> findUserByName(String name) {
		return em.createNamedQuery("User.findByName", User.class).setParameter("name", "%" + name.toLowerCase() + "%").getResultList();
	}

	private Predicate getFilterCondition(CriteriaBuilder cb, Root<User> user, Map<String, String> filters) {
		Predicate filterCondition = cb.conjunction();
		String wildCard = "%";
		for (Map.Entry<String, String> filter : filters.entrySet()) {
			String value = wildCard + filter.getValue().toLowerCase() + wildCard;
			if (!filter.getValue().equals("")) {
				if (!"name".equals(filter.getKey())) {
					Path<String> path = user.get(filter.getKey());
					filterCondition = cb.and(filterCondition, cb.like(path, value));
				} else {
					filterCondition = cb.and(filterCondition,
							cb.or(cb.like(cb.lower(user.get(User_.firstname)), value), cb.like(cb.lower(user.get(User_.lastname)), value)));
				}
			}
		}
		return filterCondition;
	}

	public int count(Map<String, String> filters) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<User> user = cq.from(User.class);
		cq.where(getFilterCondition(cb, user, filters));
		cq.select(cb.count(user));
		return em.createQuery(cq).getSingleResult().intValue();
	}

	public List<User> getResultList(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> user = cq.from(User.class);
		cq.where(getFilterCondition(cb, user, filters));
		if (sortField != null) {
			if (!"name".equals(sortField)) {
				if (sortOrder == SortOrder.ASCENDING) {
					cq.orderBy(cb.asc(user.get(sortField)));
				} else if (sortOrder == SortOrder.DESCENDING) {
					cq.orderBy(cb.desc(user.get(sortField)));
				}
			} else {
				if (sortOrder == SortOrder.ASCENDING) {
					cq.orderBy(cb.asc(user.get(User_.firstname)),cb.asc(user.get(User_.lastname)));
				} else if (sortOrder == SortOrder.DESCENDING) {
					cq.orderBy(cb.desc(user.get(User_.firstname)),cb.desc(user.get(User_.lastname)));
				}
			}
		}
		return em.createQuery(cq).setFirstResult(first).setMaxResults(pageSize).getResultList();
	}

}
