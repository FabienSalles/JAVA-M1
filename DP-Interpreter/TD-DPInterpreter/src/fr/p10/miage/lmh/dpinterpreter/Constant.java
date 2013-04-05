package fr.p10.miage.lmh.dpinterpreter;

/**
 * Une constante est une expression terminale.
 * @author lom
 *
 */
public class Constant extends Terminal {
	private Double value = Double.NaN;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public Double calculate(Context context) {
		return getValue();
	}

	public String toStructuredString() {
		return value.toString();
	}	
}
