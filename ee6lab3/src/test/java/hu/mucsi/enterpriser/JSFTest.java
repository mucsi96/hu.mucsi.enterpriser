package hu.mucsi.enterpriser;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.jsfunit.api.InitialPage;
import org.jboss.jsfunit.jsfsession.JSFClientSession;
import org.jboss.jsfunit.jsfsession.JSFServerSession;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Element;

@RunWith(Arquillian.class)
public class JSFTest {

	@Deployment
	@OverProtocol("Servlet 3.0")
	public static WebArchive createDeployment() {
		WebArchive war = ShrinkWrap
				.create(WebArchive.class, "test.war")
				.setWebXML(new File("src/main/webapp/WEB-INF/web.xml"))
				.addPackage(Package.getPackage("hu.mucsi.enterpriser"))
				// my test package
				.addAsWebResource(new File("src/main/webapp", "index.xhtml"))
				.addAsWebResource(new File("src/main/webapp", "greet.xhtml"))
				.addAsWebInfResource(
						new File("src/main/webapp/WEB-INF", "beans.xml"));
		System.out.println(war.toString(true));
		return war;
	}

	@Test
	@InitialPage("/faces/index.xhtml")
	public void testInitialPage(JSFServerSession server, JSFClientSession client)
			throws IOException {
		// Test navigation to initial viewID
		Assert.assertEquals("/index.xhtml", server.getCurrentViewID());

		// Set the param and submit
		client.setValue("name", "Stan");
		client.click("ok");

//		UIComponent greeting = server.findComponent("greeting");
//		System.out.println(greeting);
		// Assert.assertTrue(greeting.isRendered());
		
		Assert.assertEquals("/greet.xhtml", server.getCurrentViewID());
		
//		System.out.println(client.getPageAsText());

		Element greeting = client.getElement("greeting");
		String greeting_text = greeting.getChildNodes().item(0).getNodeValue();
		System.out.println(greeting_text);
		Assert.assertEquals("Hello Stan!",greeting_text);

		// Test a managed bean using EL. We cheat and use the request object.
		// Assert.assertEquals("Stan",
		// server.getManagedBeanValue("#{request.getParameter('form1:name')}"));
	}
}
