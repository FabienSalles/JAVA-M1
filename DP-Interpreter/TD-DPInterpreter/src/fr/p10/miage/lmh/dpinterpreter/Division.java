package fr.p10.miage.lmh.dpinterpreter;

public final class Division extends Operator {
	@Override
	public Double calculate(Context context) {
		return getLeft().calculate(context) / getRight().calculate(context);
	}

	@Override
	protected String getSymbol() {
		return "/";
	}
}
