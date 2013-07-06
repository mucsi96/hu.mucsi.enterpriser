package hu.mucsi.enterpriser;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServerStartupListener implements ServletContextListener {
	
	@Inject
	DBPopulator populator;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("----------[Server started]------------");
		populator.populate();		
	}

}
