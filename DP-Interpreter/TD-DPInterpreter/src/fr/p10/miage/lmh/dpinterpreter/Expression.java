package fr.p10.miage.lmh.dpinterpreter;

/**
 * Racine de la hiérarchie de classes pour la définition 
 * d'une expression arithmétique.
 * Exemple adapté de : http://ooxs-be.goracer.nl/EN/java/design-patterns/Interpreter.html
 * @author lom
 *
 */
public abstract class Expression {
	
	public abstract Double calculate(Context context);

	public static Expression parse(String text) {
		Parser parser = Parser.getInstance();
		return parser.parse(text);
	}

	public abstract String toStructuredString();

	public String toString() {
		return toStructuredString();
	}

	public abstract boolean isTerminal();

	public boolean isOperator() {
		return false;
	}

	public boolean isParentheses() {
		return false;
	}

	public Operator asOperator() {
		throw new ClassCastException("Not an operator");
	}

	public Parentheses asParentheses() {
		throw new ClassCastException("Not parentheses");
	}
}
