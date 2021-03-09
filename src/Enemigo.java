import processing.core.PApplet;

public class Enemigo {
	
	protected int vida;
	private float velocidad;
	private int posX;
	private float posY;
	protected PApplet app;
	
	public Enemigo(int posX, int posY, int vida, float velocidad, PApplet app) {
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



	public float getVelocidad() {
		return velocidad;
	}




	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}




	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float f) {
		this.posY = f;
	}
	
	
	

}
