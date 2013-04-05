package fr.p10.miage.lmh.dpinterpreter;

/**
 * Terminal expression
 * @author lom
 */
public abstract class Terminal extends Expression {
	@Override
	public boolean isTerminal() {
		return true;
	}
}
