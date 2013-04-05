package fr.p10.miage.lmh.dpinterpreter;

/**
 * Non-terminal expression.
 * @author lom
 *
 */
public abstract class Term extends Expression {
	@Override
	public boolean isTerminal() {
		return false;
	}
}
