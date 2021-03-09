import processing.core.PApplet;

public class Enemigo {
	
	private int vida;
	private int velocidad;
	private int posX;
	private int posY;
	protected PApplet app;
	
	public Enemigo(int posX, int posY, int vida, int velocidad, PApplet app) {
		super();
		this.posX = posX;
		this.posY = posY;
		this.app = app;
		this.vida = vida;
		this.velocidad = velocidad;
		
		
	
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
	

}
