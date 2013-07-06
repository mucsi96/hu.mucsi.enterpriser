package hu.mucsi.enterpriser.ejb;

import hu.mucsi.enterpriser.jpa.User;
import hu.mucsi.enterpriser.jsf.UsersFilterBean;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@Stateless
public class UserBean {
	
	@PersistenceContext
	EntityManager em;
	
	@Inject
	UsersFilterBean userFilter;
	
	private List<User> users;
	
	public void matchUser(AjaxBehaviorEvent evt) {
		users = em.createNamedQuery("User.findByName",User.class).setParameter("name", "%" + userFilter.getValue().toLowerCase() +  "%").getResultList();
	}

	public List<User> getUsers() {
		return users;
	}
}
