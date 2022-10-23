package FPL.SIDSD.Bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import FPL.SIDSD.DAO.UserDAO;
import FPL.SIDSD.DAO.IMPL.UserDAOImpl;
import FPL.SIDSD.Entities.User;


@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAO userDao;
	private  User user;
	private boolean modifyContext;
	private String message;
	
	
    public UserBean() {
		
		this.userDao = new UserDAOImpl();
		this.user = new User();
		this.modifyContext = false;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public UserDAO getUserDao() {
		return userDao;
	}
 
	

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public boolean isModifyContext() {
		return modifyContext;
	}


	public void setModifyContext(boolean modifyContext) {
		this.modifyContext = modifyContext;
	}
    
    

	public List<User> getUsers() {
		
		return this.userDao.getAll();
	}
	
	public String valid() throws IOException
	{
		User valid = userDao.Login(this.user.getLogin(), this.user.getPassword());
		if (valid != null) {
			/*ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			externalContext.redirect(externalContext.getRequestContextPath() + "/WEB-INF/Home.xhtml");*/
			return "Home.xhtml";

		} else {
			//FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Incorrect Username and Passowrd","Please enter correct username and Password"));
			this.message ="Account Invalid";
			this.user = new User();
			return "login.xhtml" ;
		}
	}
	
   
    
	public void save() {
		
		this.userDao.create(this.user);
		this.modifyContext = false;
	}
	
	public void modify(User u) {
		
		this.user = u;
		this.modifyContext = true;
	}
	
	public void delete(User u) {
		
		this.userDao.delete(u);
	}
	
	
}
