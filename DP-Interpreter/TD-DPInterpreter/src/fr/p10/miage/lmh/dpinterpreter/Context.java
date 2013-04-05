package fr.p10.miage.lmh.dpinterpreter;

import java.util.HashMap;
import java.util.Map;

public final class Context {
	private Map<String, Double> values;
	
	public Context(){
		values = new HashMap<String, Double>();
	}
	
	public Double value(String name){
		return values.get(name);
	}
	
	public void setValue(String name, Double value){
		this.values.put(name, value);
	}
	
}
