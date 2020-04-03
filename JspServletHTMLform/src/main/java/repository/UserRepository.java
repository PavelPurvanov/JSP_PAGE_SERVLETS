package repository;

import java.util.Set;
import java.util.TreeSet;

import model.UserBean;


public class UserRepository {
	
	private static Set<UserBean> UsersSet = new TreeSet<>();

	public UserRepository() {
	}

	public static void addUser(UserBean user) {
		UsersSet.add(user);
	}

	public static UserBean getUser(UserBean user) {
		for (UserBean repoUser : UsersSet) {
			if (repoUser.getEmail().equals(user.getEmail()) 
					&& repoUser.getPassword().equals(user.getPassword()))
				return repoUser;
		}
		return null;
	}
	
	
	public static UserBean getUserByID(Integer id) {
	for (UserBean idd : UsersSet) {
			if (idd.getId().equals(id))
			return idd;
	}
	return null;
		}
	
	public static UserBean update(UserBean user) {
		
		for(UserBean object : UsersSet)
	        if(object.getId().equals(user.getId())) {
	        	UsersSet.remove(object);
	        	UsersSet.add(user);
	            break;
	        }
		return null;
	}
	
	
	
	public static boolean contains(UserBean user) {
		for (UserBean repoUser : UsersSet) {
			if (repoUser.equals(user))
				return true;
		}
		return false;
	}
}
