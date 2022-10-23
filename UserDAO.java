package FPL.SIDSD.DAO;

import FPL.SIDSD.Entities.User;

public interface UserDAO extends Idao<User>{

	User Login(String login, String password);

}
