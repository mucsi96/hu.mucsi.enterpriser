package hu.mucsi.enterpriser.ejb;

import hu.mucsi.enterpriser.jpa.User;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@Stateless
public class UserBean {
	
	@PersistenceContext
	EntityManager em;
	
	public List<User> findUserByName(String name) {
		return em.createNamedQuery("User.findByName",User.class).setParameter("name", "%" + name.toLowerCase() +  "%").getResultList();
	}

	
}
