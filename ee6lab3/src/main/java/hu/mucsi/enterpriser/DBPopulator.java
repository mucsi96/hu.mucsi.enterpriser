package hu.mucsi.enterpriser;

import hu.mucsi.enterpriser.jpa.Resource;
import hu.mucsi.enterpriser.jpa.User;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Singleton
public class DBPopulator {

	@PersistenceContext
	EntityManager em;
	
	private int users;
	private int resources;

	public void populate() {
		System.out.println("----------[Populating data]------------");
		populateUsers();
		populateResources();
	}
	
	private <T> void persistAll(List<T> entities) {
		for(T entity:entities) {
			em.persist(entity);
		}
	}
	
	public void populateUsers() {
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(new Resource("Notebook","Dell","Inspiron 3521","http://www.edigital.hu/Notebook/www.edigital.hu/files/product_images/kepek/354/394953.jpg"));
		resources.add(new Resource("Notebook","Apple","MacBook Pro","http://www.edigital.hu/Notebook/www.edigital.hu/files/product_images/kepek/347/382919.jpg"));
		resources.add(new Resource("Notebook","Samsung","NP300E5C-S06HU","http://www.edigital.hu/Notebook/www.edigital.hu/files/product_images/kepek/340/370336.jpg"));
		resources.add(new Resource("Keyboard","Logitech","K400","http://www.edigital.hu/Vezetek_nelkuli_billentyuzet/www.edigital.hu/files/product_images/kepek/269/279364.jpg"));
		resources.add(new Resource("Keyboard","Genius","KB-M200","http://www.edigital.hu/Vezetekes_billentyuzet/www.edigital.hu/files/product_images/kepek/352/391705.jpg"));
		resources.add(new Resource("Keyboard","A4TECH","KD-126","http://www.edigital.hu/Vezetekes_billentyuzet/www.edigital.hu/files/product_images/kepek/354/395723.jpg"));
		resources.add(new Resource("Mouse","Logitec"," M185","http://www.edigital.hu/Vezetek_nelkuli_eger/www.edigital.hu/files/product_images/kepek/271/280947.jpg"));
		resources.add(new Resource("Mouse","Genius","Traveler 9000","http://www.edigital.hu/Vezetek_nelkuli_eger/www.edigital.hu/files/product_images/kepek/273/286003.jpg"));
		resources.add(new Resource("Mouse","Gigabyte","GM-M7580","http://www.edigital.hu/Vezetek_nelkuli_eger/www.edigital.hu/files/kepek/d_71459.jpg"));
		resources.add(new Resource("Monitor","Samsung","T22B300","http://www.edigital.hu/Monitor/www.edigital.hu/files/product_images/kepek/326/353677.jpg"));
		resources.add(new Resource("Monitor","LG","22EN33S-B","http://www.edigital.hu/Monitor/www.edigital.hu/files/product_images/kepek/350/387164.jpg"));
		resources.add(new Resource("Monitor","LG","29EA93-P","http://www.edigital.hu/Monitor/www.edigital.hu/files/product_images/kepek/345/379409.jpg"));
		resources.add(new Resource("PC","HP","Pro 3500MT","http://www.edigital.hu/Komplett_gep/www.edigital.hu/files/product_images/kepek/353/393589.jpg"));
		resources.add(new Resource("PC","Asus","Essentio CM6830-HU005S","http://www.edigital.hu/Komplett_gep/www.edigital.hu/files/product_images/kepek/356/399039.jpg"));
		resources.add(new Resource("PC","Apple","Mac mini","http://www.edigital.hu/Komplett_gep/Apple_Mac_mini_25GHz_(md387mg/www.edigital.hu/files/product_images/kepek/342/371951.jpg"));
		resources.add(new Resource("Pendrive","Kingston","DataTraveler SE9","http://www.edigital.hu/Pendrive/www.edigital.hu/files/product_images/kepek/323/353315.jpg"));
		resources.add(new Resource("Mobilephone","Samsung","I9505 Galaxy S 4","http://www.edigital.hu/Okostelefon/www.edigital.hu/files/product_images/kepek/353/393150.jpg"));
		resources.add(new Resource("Fax","Xerox","TF4075","http://www.edigital.hu/Fax_es_faxkiegeszito/www.edigital.hu/files/product_images/kepek/347/384556.jpg"));
		resources.add(new Resource("Projector","Benq","MS502","http://www.edigital.hu/Projektor/www.edigital.hu/files/product_images/kepek/335/364173.jpg"));
		persistAll(resources);
		this.resources = resources.size();
		
		
		List<Object> users = new ArrayList<Object>();
		users.add(new User("Thomas","Mecker","thomas.mecker@gmail.com").addResources(resources.get(0)));
		users.add(new User("Sheila","Lewis","sheila.lewis@yahoo.de").addResources(resources.get(1)));
		users.add(new User("Neal","Graham","neal.graham@yahoo.com").addResources(resources.get(2)));
		users.add(new User("Myra","Sanchez","myra.sanchez@hotmail.com").addResources(resources.get(3)).addResources(resources.get(6)).addResources(resources.get(9)).addResources(resources.get(12)));
		users.add(new User("Lisa","Smith","lisa.smith@ibm.com").addResources(resources.get(4)).addResources(resources.get(7)).addResources(resources.get(10)).addResources(resources.get(13)));
		users.add(new User("Paul","Phelp","paul.phelp@apple.com").addResources(resources.get(5)).addResources(resources.get(8)).addResources(resources.get(11)).addResources(resources.get(14)));
		users.add(new User("Thomas","James","thomas.james@sony.tw").addResources(resources.get(15)).addResources(resources.get(16)).addResources(resources.get(17)).addResources(resources.get(18)));
		persistAll(users);
		this.users = users.size();
	}
	
	public void populateResources() {
		
	}
	
	public int getPopulatedUsers() {
		return users;
	}
	
	public int getPopulatedResources() {
		return resources;
	}
}
