package hu.mucsi.enterpriser.jsf;

import javax.enterprise.inject.Model;

@Model
public class UserFilterBean {
	private String value="";

	public String getValue() {
		return value;
		
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
