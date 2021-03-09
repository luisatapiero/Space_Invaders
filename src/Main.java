
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	private Nave nave;
	private Bala bala;
	private EnemigoMenor enemigoMenor;
	private EnemigoMayor enemigoMayor;
	PImage imgInicio;
	PImage imgInstrucciones;
	PImage imgResumen;
	PImage imgJuego;
	int tiempo = 0;
	int puntos = 0;
	private ArrayList<Bala> listaBalas;
	private ArrayList<EnemigoMenor> listaEnemigo1;
	private ArrayList<EnemigoMayor> listaEnemigo2;

	int pantalla = 1;
	private int vel;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());

	}

	public void settings() {
		size(600, 900);
	}

	public void setup() {
		cargarFondos();
		listaBalas = new ArrayList<Bala>();
		listaEnemigo1 = new ArrayList<EnemigoMenor>();
		listaEnemigo2 = new ArrayList<EnemigoMayor>();
		nave = new Nave(this);
		frameRate(90);
		// bala = new Bala(this);
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
				nave.setPosX(nave.getPosX() - 15);
			}
		}
		if (nave.getPosX() < 600) {
			if (keyCode == RIGHT) {
				nave.setPosX(nave.getPosX() + 15);

			}
		}

		if (key == ' ') {
			initBala();

		}

	}

	private void cargarFondos() {
		imgInicio = loadImage("lib/inicio.jpg");
		imgInicio.resize(600, 900);
		imgInstrucciones = loadImage("lib/instrucciones.jpg");
		imgInstrucciones.resize(600, 900);
		imgResumen = loadImage("lib/resumen.jpg");
		imgResumen.resize(600, 900);
		imgJuego = loadImage("lib/juego.jpg");
		imgJuego.resize(600, 900);
	}

	private void cambioPantallas() {
		switch (pantalla) {
		case 1:
			background(imgInicio);
			break;

		case 2:
			background(imgJuego);
			drawBala();
			nave.draw();
			eliminarBala();
			iniEnemigo1();
			drawEnemigo1();
			iniEnemigo2();
			drawEnemigo2();
			tiempo();
			puntuacion();
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

	private void clickBoton() {
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

	private void tiempo() {
		int tiempo = millis() / 1000;
		textSize(25);
		fill(245, 245, 245);
		text("Tiempo: " + tiempo, 410, 60);
	}
	
	private void puntuacion() {
		textSize(25);
		fill(245, 245, 245);
		text("Puntos: " + tiempo, 50, 60);
	}

	private void initBala() {
		listaBalas.add(new Bala(nave.getPosX(), 783, this));
		

	}

	private void drawBala() {
		for (int i = 0; i < listaBalas.size(); i++) {
			listaBalas.get(i).mostrarBala();
			listaBalas.get(i).setDispara(!listaBalas.get(i).isDispara());

		}
	}

	private void eliminarBala() {
		for (int i = 0; i < listaBalas.size(); i++) {
			if (listaBalas.get(i).getbPosY() < 0) {
				listaBalas.remove(i);
				//System.out.println(listaBalas.size());

			}

		}
	}
	
	
	private void iniEnemigo1() {
		int vel = 2;
		if (frameCount == 90) {
			listaEnemigo1.add(new EnemigoMenor((int) random(15,490), 2, 1, vel, this));
			//System.out.println(listaEnemigo1.size());

		}
		
	}
	
	private void drawEnemigo1() {
		for (int i = 0; i < listaEnemigo1.size(); i++) {
			listaEnemigo1.get(i).drawEn();
			//listaEnemigo1.get(i).setDispara(!listaEnemigo1s.get(i).isDispara());

		}
	}
	
	private void iniEnemigo2() {
		int vel1 = 4;
		if (puntos % 10 == 0 && puntos != 0) {
			listaEnemigo2.add(new EnemigoMayor((int) random(15,490), 50, 2, vel1, this));
			System.out.println(listaEnemigo2.size());
			//System.out.println(frameCount);
			frameCount = 0;
		}
		
	}
	
	private void drawEnemigo2() {
		for (int i = 0; i < listaEnemigo2.size(); i++) {
			listaEnemigo2.get(i).drawEn2();
			//listaEnemigo1.get(i).setDispara(!listaEnemigo1s.get(i).isDispara());

		}
	}
}
