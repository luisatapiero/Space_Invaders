import processing.core.PApplet;
import processing.core.PImage;

public class EnemigoMenor extends Enemigo {
	
		PImage enemigo1;
		int vida = 1;

	public EnemigoMenor(int posX, int posY, int vida, int velocidad, PApplet app) {
		super(posX, posY, vida, velocidad, app);
		this.vida = vida;
		
		this.app = app;
	
	} 
	
	public void mover() {
			setPosY(getPosY()+ getVelocidad());
		
	}
	

	private void cargarImg() {
		enemigo1 = app.loadImage("lib/enemigo1.png");
		enemigo1.resize(102, 54);
		app.image(enemigo1, getPosX(), getPosY());
	}
	
	public void drawEn() {
		cargarImg();
		mover();
		
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
}
