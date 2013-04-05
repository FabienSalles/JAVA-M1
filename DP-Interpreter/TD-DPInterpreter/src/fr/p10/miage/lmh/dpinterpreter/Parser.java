package fr.p10.miage.lmh.dpinterpreter;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Le parser des expressions arithmétiques.
 * C'est un singleton.
 */
public final class Parser {

	 private Parser (){
		super();
	 }
	
	 private static final class ParserHolder {
	     private static final Parser INSTANCE =  new Parser();
	 }

	  public static Parser getInstance() {
	      return ParserHolder.INSTANCE;
	 } 
	
	
	public Expression parse(String text) {
		String regex = "\\s*(";
		regex += "([-+]?\\d+([.]\\d+)?)";//numerical value
		regex += "|([a-zA-Z]\\w*)";//parameter name
		regex += "|(\\()";// a '('
		regex += "|(\\))";// a ')'
		regex += "|(([-+*/])))\\s*";// an operator -+/*
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		System.out.println("parsing: " + text);
		Expression rootExpression = null;
		Stack<Expression> expressions = new Stack<Expression>();
		while (matcher.find()) {
			String currentToken = matcher.group(1);
			String numericalValue = matcher.group(2);
			;
			String parameterName = matcher.group(4);
			String opeParentheses = matcher.group(5);
			String closeParentheses = matcher.group(6);
			String operator = matcher.group(7);

			handleExpression(expressions, currentToken, numericalValue, parameterName, opeParentheses, closeParentheses, operator);
		}
		rootExpression = expressions.pop();
		return rootExpression;
	}

	/**
	 * This method exists for the unit tests and avoids having to call
	 * {@link #handleExpression(Stack, String, String, String, String, String, String)}
	 * with the same string for the description parameter and one of the other
	 * parameters like this: parser.handleExpressionForUnitTesting(expressions,
	 * "(", null, null, "(", null, null); which could easily lead to mistakes in
	 * the unit tests.
	 */
	protected void handleExpressionForUnitTesting(Stack<Expression> expressions, String numericalValue, String parameterName, String opeParentheses,
			String closeParentheses, String operator) {
		String description = "undetermined";

		if (numericalValue != null) {
			description = numericalValue;
		} else if (parameterName != null) {
			description = parameterName;
		} else if (operator != null) {
			description = operator;
		} else if (opeParentheses != null) {
			description = opeParentheses;
		} else if (closeParentheses != null) {
			description = closeParentheses;
		}
		handleExpression(expressions, description, numericalValue, parameterName, opeParentheses, closeParentheses, operator);
	}

	protected void handleExpression(Stack<Expression> expressions, String description, String numericalValue, String parameterName, String opeParentheses,
			String closeParentheses, String operator) {
		if (numericalValue != null) {
			Constant constant = new Constant();
			constant.setValue(new Double(numericalValue));
			assign(expressions, constant);
		} else if (parameterName != null) {
			Variable parameter = new Variable();
			parameter.setName(parameterName);

			assign(expressions, parameter);
		} else if (operator != null) {
			Operator operation = null;
			if ("+".equals(operator)) {
				operation = new Addition();
			} else if ("*".equals(operator)) {
				operation = new Multiplication();
			} else if ("/".equals(operator)) {
				operation = new Division();
			} else if ("-".equals(operator)) {
				operation = new Subtraction();
			} else {
				throw new UnsupportedOperationException("Unsupported operator:" + operator);
			}
			operation.setLeft(expressions.pop());

			assign(expressions, operation);
		} else if (opeParentheses != null) {
			Parentheses parentheses = new Parentheses();
			assign(expressions, parentheses);
			expressions.push(parentheses);
		} else if (closeParentheses != null) {
			Expression expression = expressions.pop();
			Expression previous = expressions.pop();
			if (previous.isOperator()) {
				Operator operation = previous.asOperator();
				operation.setRight(expression);
			} else if (previous.isParentheses()) {
				Parentheses parentheses = previous.asParentheses();
				parentheses.setExpression(expression);
			} else {
				throw new IllegalStateException("Illegal State in the Parser");
			}
		}
		System.out.println(description + "\t\t##\t" + expressions);
	}

	private void assign(Stack<Expression> expressions, Expression expression) {
		if (!expressions.isEmpty()) {
			Expression top = expressions.peek();
			if (!top.isTerminal()) {
				if (top instanceof Operator) {
					((Operator) top).setRight(expression);
				} else {
					expressions.push(expression);
				}
			} else {
				throw new IllegalStateException("Expect non terminal expression as parent");
			}
		} else {
			expressions.push(expression);
		}
	}
}
