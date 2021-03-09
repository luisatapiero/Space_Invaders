
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	private Nave nave;
	private Bala bala;
	PImage imgInicio;
	PImage imgInstrucciones;
	PImage imgResumen;
	PImage imgJuego;
	int tiempo = 0;
	private ArrayList<Bala> listaBalas;

	int pantalla = 1;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(600, 900);
	}

	public void setup() {
		cargarFondos();
		listaBalas = new ArrayList<Bala>();
		nave = new Nave(this);
		//bala = new Bala(this);
	}

	public void draw() {

		imageMode(CENTER);
		// System.out.println(mouseX);
		cambioPantallas();

	}

	public void mousePressed() {
		clickBoton();

	}

	public void keyPressed() {
		if (nave.getPosX() > 0) {
			
			if (keyCode == LEFT) {
				nave.setPosX(nave.getPosX() - 10);
			}
		}
			if (nave.getPosX() < 600) {
				if (keyCode == RIGHT) {
					nave.setPosX(nave.getPosX() + 10);

				}
			}

		
		 
		if (key == ' ') {
			System.out.println("space");	
			initBala();

		}

	}

	public void cargarFondos() {
		imgInicio = loadImage("lib/inicio.jpg");
		imgInicio.resize(600, 900);
		imgInstrucciones = loadImage("lib/instrucciones.jpg");
		imgInstrucciones.resize(600, 900);
		imgResumen = loadImage("lib/resumen.jpg");
		imgResumen.resize(600, 900);
		imgJuego = loadImage("lib/juego.jpg");
		imgJuego.resize(600, 900);
	}

	public void cambioPantallas() {
		switch (pantalla) {
		case 1:
			background(imgInicio);
			break;

		case 2:
			background(imgJuego);
			nave.draw();
			drawBala();
			tiempo();
			break;

		case 3:
			background(imgInstrucciones);
			break;

		case 4:
			exit();
			break;

		case 5:
			background(imgResumen);
			break;

		}

	}

	public void clickBoton() {
		switch (pantalla) {
		case 1:
			if (mouseX > 188 && mouseX < 422 && mouseY > 439 && mouseY < 506) {
				pantalla = 2;
			} else if (mouseX > 188 && mouseX < 422 && mouseY > 555 && mouseY < 621) {
				pantalla = 3;
			} else if (mouseX > 188 && mouseX < 422 && mouseY > 670 && mouseY < 736) {
				pantalla = 4;
			}
			break;

		case 2:
			background(imgJuego);
			break;

		case 3:
			if (mouseX > 46 && mouseX < 217 && mouseY > 108 && mouseY < 174) {
				pantalla = 1;
			}
			break;

		case 4:
			background(imgResumen);
			if (mouseX > 170 && mouseX < 418 && mouseY > 522 && mouseY < 588) {
				pantalla = 2;
			}
			break;

		}
	}

	public void tiempo() {
		int tiempo = millis() / 1000;
		textSize(25);
		fill(245, 245, 245);
		text("Tiempo: " + tiempo, 410, 60);
	}
	
	private void initBala() {
			listaBalas.add(new Bala(nave.getPosX(), 783, this));
			System.out.println(listaBalas.size());

	}
	
	public void drawBala() {
		for (int i = 0; i < listaBalas.size(); i++) {
			listaBalas.get(i).mostrarBala();
			listaBalas.get(i).setDispara(!listaBalas.get(i).isDispara());
			//listaBalas.get(i).setbPosY(listaBalas.get(i).getbPosY()-100);
			//System.out.println(listaBalas.length);

		}
	}



	
	
}
