package poo.td3.factorysingleton;

import java.util.ArrayList;
import java.util.List;


public final class Sheet {
	List<Shapes> shapesList = new ArrayList<Shapes>();

	public Sheet() {
	}
	
	public void add(Shapes s) {
		shapesList.add(s);
	}

	public void del(int id) {
		for (int i = 0; i < shapesList.size(); i++) {
			if (shapesList.get(i).getID() == id) {
				shapesList.remove(i);
				break;
			}
		}
	}

	public Shapes get(int pos) {
		return shapesList.get(pos);
	}

	public int size() {
		return shapesList.size();
	}

	public void drawAll() {
		for (Shapes sh : shapesList) {
			sh.draw();
		}
	}
}
