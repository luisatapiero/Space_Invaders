
import processing.core.PApplet;
import processing.core.PImage;

public class Bala {
	private Nave nave;
	PImage disparo;
	private int bPosY = 783;
	private int vel = 12;
	private PApplet app;
	private int posX;
	private boolean dispara;

	public Bala(int posX, int bPosY,PApplet app) {
		this.posX = posX;
		this.bPosY =  bPosY;
		this.app = app;
		nave = new Nave(app);
		dispara = false;
	}
	
	
	public void disparar() {
		if (dispara == true) {
			bPosY -= vel;
		}
		
	}
	
	public void mostrarBala() {
			app.noStroke();
			app.fill (255, 171, 85);
			app.circle (posX, bPosY, 10);
			disparar();
		
	}
	

	public int getbPosY() {
		return bPosY;
	}

	public void setbPosY(int bPosY) {
		this.bPosY = bPosY;
	}

	public boolean isDispara() {
		return dispara;
	}

	public void setDispara(boolean dispara) {
		this.dispara = dispara;
	}


	public int getPosX() {
		return posX;
	}

	//public ArrayList<Bala> getListaBalas() 

	
}
