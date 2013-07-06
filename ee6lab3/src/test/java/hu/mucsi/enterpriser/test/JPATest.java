package hu.mucsi.enterpriser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import hu.mucsi.enterpriser.DBPopulator;
import hu.mucsi.enterpriser.model.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class JPATest {
	
	@Inject
	DBPopulator populator;
	
	@PersistenceContext
    EntityManager em;
    
    @Inject
    UserTransaction utx;
	
	@Deployment
	@OverProtocol("Servlet 3.0")
	public static WebArchive createDeployment() {
		return DeploymentCreator.createDeployment();
	}
	
	@Test
	public void usersShouldBePopulated() throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		utx.begin();
		assertTrue(populator.getPopulatedUsers() > 0);
		assertEquals(em.createNamedQuery("User.findAll").getResultList().size(),populator.getPopulatedUsers());
		utx.commit();
	}
	
	@Test
	public void resourcesShouldBePopulated() throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		utx.begin();
		assertTrue(populator.getPopulatedResources() > 0);
		assertEquals(em.createNamedQuery("Resource.findAll").getResultList().size(),populator.getPopulatedResources());
		utx.commit();
	}
	
	@Test
	public void anyUserShouldHaveResource() throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		utx.begin();
		assertTrue(em.createNamedQuery("User.findAll",User.class).getResultList().get(0).getResources().size()>0);
		utx.commit();
	}

}
