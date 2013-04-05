package fr.p10.miage.lmh.dpinterpreter;

/**
 * Parentheses sont des expressions non-terminales.
 * Elles contiennent une seule expression.
 * @author lom
 *
 */
public final class Parentheses extends Term {
	private Expression expression;

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public Double calculate(Context context) {
		return expression.calculate(context);
	}

	@Override
	public String toStructuredString() {
		String structuredString = expression == null ? "empty" : expression.toStructuredString();

		return "[(" + structuredString + ")]";
	}

	@Override
	public Parentheses asParentheses() {
		return this;
	}

	@Override
	public boolean isParentheses() {
		return true;
	}
}
