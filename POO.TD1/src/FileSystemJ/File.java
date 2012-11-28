package FileSystemJ;

public abstract class File {
	
	public enum OpenMode {
		READ(), WRITE(), APPEND();
		private OpenMode() {}
	}

	private static UserRegistry userregistry = new UserRegistry();
	private static int nextId = 0;

	private int id;
	private String name;
	private UserRegistry.User user;
	private OpenMode mode;
	private boolean open;
	
	public File(String name, String username) {
		this.id = nextId++;
		this.name = name;
		this.mode = null;
		this.open = false;
		this.user = userregistry.getAndCreateIfNeeded(username);
	}
	
	@Override
	public String toString() {
		return ""+id+":"+user+" "+name;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) {return true;}
		else if(o==null) {return false;}
		else if(!(o instanceof File)) {return false;}
		else {
			File f = (File)o;
			return (this.id == f.id);
		}
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
	
	public int getId() { return id; }
	public String getName() { return name; }	
	public OpenMode getMode() { return mode; }
	public UserRegistry.User getUser() { return user; }
	
	public boolean open(OpenMode mode) {
		if(!open) { this.open=true; this.mode = mode; return true; }
		else { return false; }
	}

	public boolean close() {
		if(open) { this.open=false; this.mode = null; return true; }
		else { return false; }
	}
	
	public void rename(String newname) {
		name = newname;
	}
	
	public abstract String read();
	public abstract boolean write(String c);
	
}
