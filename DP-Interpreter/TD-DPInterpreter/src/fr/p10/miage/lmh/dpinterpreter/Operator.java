package fr.p10.miage.lmh.dpinterpreter;

/**
 * Un opérateur est une expression non terminale, i.e. un Term.
 * @author lom
 *
 */
public abstract class Operator extends Term {
	private Expression left;
	private Expression right;

	public Expression getLeft() {
		return left;
	}

	public void setLeft(Expression left) {
		this.left = left;
	}

	public Expression getRight() {
		return right;
	}

	public void setRight(Expression right) {
		this.right = right;
	}

	@Override
	public final String toStructuredString() {
		String leftStructuredString = left == null ? "empty" : getLeft().toStructuredString();
		String rightStructuredString = right == null ? "empty" : getRight().toStructuredString();

		StringBuilder buffer = new StringBuilder().append("[").append(leftStructuredString).append("]");
		buffer.append(" ").append(getSymbol()).append(" ");
		buffer.append("[").append(rightStructuredString).append("]");
		return buffer.toString();
	}

	protected abstract String getSymbol();

	@Override
	public Operator asOperator() {
		return this;
	}

	@Override
	public boolean isOperator() {
		return true;
	}
}
