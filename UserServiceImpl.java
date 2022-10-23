package FPL.SIDSD.Service.IMPL;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import FPL.SIDSD.DAO.UserDAO;
import FPL.SIDSD.DAO.IMPL.UserDAOImpl;
import FPL.SIDSD.Entities.User;
import FPL.SIDSD.Service.IUserService;

public class UserServiceImpl implements IUserService{
	
	private UserDAO userDao = new UserDAOImpl() ;

	@Override
	public List<User> getSorted() {
		List<User> users = this.userDao.getAll();
		
		  Collections.sort(users, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				
				return o1.getIdUser() - o2.getIdUser();
			}
		});
		
		return users;
	}

	@Override
	public String getFKey(int i) {
		// TODO Auto-generated method stub
		String login =  this.userDao.getById(i).getLogin();
		return login;
	}

}
