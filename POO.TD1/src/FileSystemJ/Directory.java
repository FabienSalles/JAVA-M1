package FileSystemJ;

import java.util.HashMap;
import java.util.Map;

public final class Directory extends File {
	
	private Map<Integer,File> contents; // PATTERN
	
	public Directory(String name, String username) {
		super(name, username);
		contents = new HashMap<Integer,File>();
	}
	
	public void add(File f) { // PATTERN METHOD
		contents.put(f.getId(), f);
	}
	
	public File remove(File f) { // PATTERN METHOD
		return contents.remove(f.getId());
	}
	
	public File get(File f) { // PATTERN METHOD
		return contents.get(f.getId());
	}
	
	@Override
	public String read() {
		if(getMode() == OpenMode.READ) {
			String rtr = "";
			for(File f: contents.values()) {rtr += "\n"+f.getName();}
			return rtr;
		}
		else { return null; }
	}

	@Override
	public boolean write(String c) {
		if(getMode() == OpenMode.WRITE) {
			contents.clear();
			SimpleFile f = new SimpleFile(c,getUser().getUid());
			contents.put(f.getId(), f);
			return true;
		}
		else if(getMode() == OpenMode.APPEND) {
			SimpleFile f = new SimpleFile(c,getUser().getUid());
			contents.put(f.getId(), f);			
			return true;
		}
		else { return false; }
	}
	
	@Override
	public String toString() {
		String rtr = "(d)"+super.toString()+"[";
		for (File f : contents.values()) { rtr += "\n"+f.toString(); }
		rtr += "]";
		return rtr;
	}

}
