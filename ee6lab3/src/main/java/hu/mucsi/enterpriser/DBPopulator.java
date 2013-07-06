package hu.mucsi.enterpriser;

import hu.mucsi.enterpriser.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class DBPopulator {

	@PersistenceContext
	EntityManager em;

	public void populate() {
		System.out.println("----------[Populating data]------------");
		
		em.persist(new User("Thomas","Mecker","thomas.mecker@gmail.com"));
		em.persist(new User("Neal","Graham","neal.graham@yahoo.com"));
		em.persist(new User("Myra","Sanchez","myra.sanchez@hotmail.com"));
		em.persist(new User("Lisa","Smith","lisa.smith@ibm.com"));
		em.persist(new User("Paul","Phelp","paul.phelp@apple.com"));
		em.persist(new User("Sheila","Lewis","sheila.lewis@yahoo.de"));
		em.persist(new User("Thomas","James","thomas.james@sony.tw"));
		
	}
}
