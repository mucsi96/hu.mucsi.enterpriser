package hu.mucsi.enterpriser.jsf;

import javax.enterprise.inject.Model;

@Model
public class UsersFilterBean {
	private String value="";

	public String getValue() {
		System.out.println("Ge: " + value);
		return value;
		
	}

	public void setValue(String value) {
		System.out.println("SET: " + value);
		this.value = value;
	}
	
}
