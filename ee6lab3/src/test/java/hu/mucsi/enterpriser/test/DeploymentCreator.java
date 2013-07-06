package hu.mucsi.enterpriser.test;

import java.io.File;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class DeploymentCreator {

	private static WebArchive deployment;

	public static WebArchive createDeployment() {
		if (deployment == null) {

			deployment = ShrinkWrap.create(WebArchive.class, "test.war")
					.setWebXML(new File("src/main/webapp/WEB-INF/web.xml"))
					.addPackage("hu.mucsi.enterpriser")
					.addPackage("hu.mucsi.enterpriser.model")
					.addAsResource(new File("src/main/resources/META-INF/persistence.xml"), "META-INF/persistence.xml")
					.addAsWebResource(new File("src/main/webapp/index.xhtml"))
					.addAsWebResource(new File("src/main/webapp/greet.xhtml"))
					.addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"));
		}

		System.out.println(deployment.toString(true));
		return deployment;
	}
}
