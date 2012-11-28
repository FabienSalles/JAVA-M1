package FileSystemJ;

import java.util.HashSet;
import java.util.Set;


public class UserRegistry {
	
	public class User {
		private String uid;
		public User(String uid) { this.uid = uid; }
		public String getUid() { return uid; }
		@Override
		public String toString() { return this.uid; }
		@Override
		public boolean equals(Object o) {
			if(this==o) {return true;}
			else if(o==null) {return false;}
			else if(!(o instanceof User)) {return false;}
			else {return ((User)o).uid.equals(this.uid);}
		}
		@Override
		public int hashCode() { return this.uid.hashCode(); }

	}

	private static Set<User> uids;
	public static UserRegistry registry = new UserRegistry();
	
	public UserRegistry() { uids = new HashSet<User>(); }
	
	public boolean createUser(String uid) {
		return uids.add(new User(uid));
	}
	
	public boolean removeUser(String uid) {
		return uids.remove(new User(uid));
	}
	
	public boolean containsUser(String uid) {
		return uids.contains(new User(uid));
	}
	
	public User get(String uid) {
		if(containsUser(uid)) { return new User(uid); }
		else {return null;}
	}

	public User getAndCreateIfNeeded(String username) {
		User rtr;
		if(!containsUser(username)) {
			createUser(username);
		}
		rtr = get(username);
		return rtr;
	}
	
}
