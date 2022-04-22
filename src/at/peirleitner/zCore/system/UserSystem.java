package at.peirleitner.zCore.system;

import java.util.ArrayList;
import java.util.Collection;

import at.peirleitner.zCore.util.User;

public class UserSystem {

	private Collection<User> cachedUsers;
	
	public UserSystem() {
		this.cachedUsers = new ArrayList<>();
	}
	
	public Collection<User> getCachedUsers() {
		return this.cachedUsers;
	}
	
	public Collection<User> getUsers() {
		return null;
	}
	
}
