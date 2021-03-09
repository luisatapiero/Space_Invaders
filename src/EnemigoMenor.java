import processing.core.PApplet;
import processing.core.PImage;

public class EnemigoMenor extends Enemigo {
	
		PImage enemigo1;

	public EnemigoMenor(int posX, int posY, int vida, int velocidad, PApplet app) {
		super(posX, posY, vida, velocidad, app);
		vida = 1;
		velocidad +=2;
		this.app = app;
		
	
	} 

}
