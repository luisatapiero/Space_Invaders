import processing.core.PApplet;
import processing.core.PImage;

public class Nave {

	private int posX = 300;
	PImage nave;
	private PApplet app;
	public int dir = 0;

	public Nave( PApplet app) {
	
		this.app = app;

	}

	

	private void cargarNave() {
		nave = app.loadImage("lib/nave.png");
		nave.resize(158, 150);
		app.image(nave, posX, 783);
	}

	public void draw() {
		
		cargarNave();


		

	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	
	
	
		 
	
}
