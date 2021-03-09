import processing.core.PApplet;
import processing.core.PImage;

public class Nave {
	
	private int dir, posX;
	PImage nave;
	private PApplet app;
	
	public Nave(PApplet app) {

		this.app = app;
		
	}
	
	
	private void cargarNave(){
		nave = app.loadImage("lib/nave.png");
		nave.resize(158, 150);
	}
	
	public void draw() {
		cargarNave();
		app.image(nave, 300, 783);
	
	
	}
}
