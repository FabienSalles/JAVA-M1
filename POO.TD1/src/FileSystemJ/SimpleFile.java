package FileSystemJ;

public final class SimpleFile extends File {

	private String contents;
	
	public SimpleFile(String name, String username) {
		super(name, username);
		this.contents = "";
	}
	
	@Override
	public String toString() {
		return "(f)"+super.toString();
	}

	@Override
	public String read() {
		if(getMode() == OpenMode.READ) { return contents; }
		else { return null; }
	}

	@Override
	public boolean write(String c) {
		if(getMode() == OpenMode.WRITE) { contents = c; return true; }
		else if (getMode() == OpenMode.APPEND) { contents += c; return true; }
		else { return false; }
	}
	
}
