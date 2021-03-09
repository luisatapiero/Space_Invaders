import processing.core.PApplet;
import processing.core.PImage;

public class EnemigoMayor extends Enemigo{
	
	PImage enemigo2;
	private PApplet app;

	
	public EnemigoMayor(int posX, int posY, int vida, float velocidad, PApplet app) {
		super(posX, posY, vida, velocidad, app);
		vida = 2;
		velocidad = 4;
		this.app = app;
	}
	
	public void mover() {
		setPosY(getPosY()+ getVelocidad());
	
	}
	

	private void cargarImg() {
		enemigo2 = app.loadImage("lib/enemigo2.png");
		enemigo2.resize(102, 54);
		app.image(enemigo2, getPosX(), getPosY());
	}
	
	public void drawEn2() {
		cargarImg();
		mover();
		
	}
}
