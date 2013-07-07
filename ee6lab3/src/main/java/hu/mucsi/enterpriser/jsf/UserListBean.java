package hu.mucsi.enterpriser.jsf;

import hu.mucsi.enterpriser.ejb.UserBean;
import hu.mucsi.enterpriser.jpa.User;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class UserListBean {
	
	@Inject
	UserFilterBean userFilter;
	
	@Inject
	UserBean userBean;
	
	public List<User> getValue() {
		return userBean.findUserByName(userFilter.getValue());
	}

}
