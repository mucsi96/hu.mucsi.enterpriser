package hu.mucsi.enterpriser.jsf;

import java.util.List;
import java.util.Map;

import hu.mucsi.enterpriser.ejb.UserBean;
import hu.mucsi.enterpriser.jpa.User;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

@Model
public class UserListBean {
	
	@Inject
	private UserBean userBean;
	
	private LazyDataModel<User> lazyModel;  
	  
    private User selectedUser;  
    
    public UserListBean() {
    	lazyModel = new LazyDataModel<User>() {

    		
    		private int rowCount;
    		private static final long serialVersionUID = 1L;
    		
    		@Override
    		public int getRowCount() {
    			return rowCount;
    		}

    		@Override
    		public User getRowData(String id) {
    			return userBean.findUserById(id);
    		}

    		@Override
    		public Object getRowKey(User user) {
    			return user.getId();
    		}

    		@Override
    		public List<User> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
    			rowCount = userBean.count(filters);
    			return userBean.getResultList(first, pageSize, sortField, sortOrder, filters);
    		}
    	};
    	
    	lazyModel.setPageSize(10);
    }

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public LazyDataModel<User> getLazyModel() {
		return lazyModel;
	}
	
}
