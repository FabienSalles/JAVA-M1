package fr.p10.miage.lmh.dpfactorysingleton;

public interface Shape2D {

	int getID();

	int getX();

	void setX(int x);

	int getY();

	void setY(int y);

	void draw();
	
	void move(int dX, int dY);

	//Shapes createShape();
}
