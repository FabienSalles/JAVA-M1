package fr.p10.miage.lmh.dpinterpreter;

public final class Variable extends Terminal {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Double calculate(Context context) {
		//throw an IllegalArgumentException when there is no value for the name
		if (context.value(name) == null)
			throw new IllegalArgumentException("No value for this variable: " + name);
		return context.value(name);
	}

	public String toStructuredString() {
		return name;
	}
}
