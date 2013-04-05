package fr.p10.miage.lmh.dpinterpreter;

import java.text.DecimalFormat;

public final class Main {

	private Main() {
		super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Parser parser = Parser.getInstance();
		Expression expression = parser.parse("(x1 * x1) + (x2 * x3) - 4");
		Context context = new Context();
		context.setValue("x1", new Double("3"));
		context.setValue("x2", new Double("4.2"));
		context.setValue("x3", new Double("5.7"));
		Double result = expression.calculate(context);
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println(df.format(result));// affiche 28,98, qui est égale à 3*3 + 4.2*5.7 - 4
	}
}
