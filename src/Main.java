
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
	int puntos = 10;
	private ArrayList<Bala> listaBalas;
	private ArrayList<EnemigoMenor> listaEnemigo1;
	private ArrayList<EnemigoMayor> listaEnemigo2;

	int pantalla = 1;
	int tiempo1;
	int inicioTiempo;
	int tiempoActual;
	float vel;

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
		frameRate(60);
		inicioTiempo = millis();
		tiempoActual = 0;
	}

	public void draw() {

		imageMode(CENTER);
		cambioPantallas();

	}

	public void mousePressed() {
		clickBoton();

	}

	public void keyPressed() {
		if (nave.getPosX() > 0) {

			if (keyCode == LEFT) {
				nave.setPosX(nave.getPosX() - 20);
			}
		}
		if (nave.getPosX() < 600) {
			if (keyCode == RIGHT) {
				nave.setPosX(nave.getPosX() + 20);

			}
		}

		if (key == ' ') {
			initBala();

		}

	}

/////////////////////CARGAR FONDOS///////////////////////

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

/////////////////////CARGAR PANTALLAS///////////////////////

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
			eliminarNave();
			pierdeJuego();
			break;

		case 3:
			background(imgInstrucciones);
			break;

		case 4:
			exit();
			break;

		case 5:
			background(imgResumen);

			textSize(25);
			fill(93, 82, 249);
			text(puntos, 278, 407);
			text(tiempoActual / 1000, 365, 461);
			break;

		}

	}

/////////////////////BOTONES///////////////////////	

	private void clickBoton() {
		switch (pantalla) {
		case 1:
			reset();
			if (mouseX > 188 && mouseX < 422 && mouseY > 439 && mouseY < 506) {
				pantalla = 2;
			} else if (mouseX > 188 && mouseX < 422 && mouseY > 555 && mouseY < 621) {
				pantalla = 3;
			} else if (mouseX > 188 && mouseX < 422 && mouseY > 670 && mouseY < 736) {
				pantalla = 4;
			}
			break;

		case 2:

			break;

		case 3:
			if (mouseX > 46 && mouseX < 217 && mouseY > 108 && mouseY < 174) {
				pantalla = 1;
			}
			break;

		case 4:

			break;

		case 5:
			if (mouseX > 170 && mouseX < 418 && mouseY > 522 && mouseY < 588) {
				reset();
				pantalla = 2;

			}
			break;
		}
	}

/////////////////////TIEMPO///////////////////////	

	private void tiempo() {

		tiempoActual = millis() - inicioTiempo;
		textSize(25);
		fill(245, 245, 245);
		text("Tiempo: " + tiempoActual / 1000, 410, 60);
	}

/////////////////////PUNTOS///////////////////////

	private void puntuacion() {
		textSize(25);
		fill(245, 245, 245);
		text("Puntos: " + puntos, 50, 60);
	}

/////////////////////RESET///////////////////////

	private void reset() {
		puntos = 0;
		tiempoActual = 0;
		inicioTiempo = millis();
		frameCount = 0;
		listaBalas.clear();
		listaEnemigo1.clear();
		listaEnemigo2.clear();
		nave.setPosX(300);
	}

/////////////////////BALAS///////////////////////

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

			}

		}
	}

/////////////////////ENEMIGOS///////////////////////

	private void iniEnemigo1() {
		float vel = 2;
		if (puntos % 10 == 0 && puntos != 0) {
			vel += 2;
		} 
		
		if (frameCount == 60) {
			listaEnemigo1.add(new EnemigoMenor((int) random(15, 490), 2, 1, vel, this));
			frameCount = 0;

		}

	}

	private void drawEnemigo1() {
		for (int i = 0; i < listaEnemigo1.size(); i++) {
			listaEnemigo1.get(i).drawEn();

		}
	}

	private void iniEnemigo2() {
		
		float vel1 = 3;
		if (puntos % 10 == 0 && puntos != 0) {
			vel1 += 1;
		}
			
		if (puntos % 10 == 0 && puntos != 0) {
			if (listaEnemigo2.size() < 1) {
				listaEnemigo2.add(new EnemigoMayor((int) random(15, 490), 50, 2, vel1, this));
				frameCount = 0;

	
			}

		}

	}

	private void drawEnemigo2() {
		for (int i = 0; i < listaEnemigo2.size(); i++) {
			listaEnemigo2.get(i).drawEn2();

		}
	}

/////////////////////ELIMINAR ENEMIGOS///////////////////////	

	private void eliminarNave() {

		for (int i = 0; i < listaEnemigo1.size(); i++) {
			for (int j = 0; j < listaBalas.size(); j++) {
				if (listaBalas.get(j).getPosX() > (listaEnemigo1.get(i).getPosX() - (102 / 2))
						&& listaBalas.get(j).getPosX() < (listaEnemigo1.get(i).getPosX() + (102 / 2))
						&& listaBalas.get(j).getbPosY() > (listaEnemigo1.get(i).getPosY() - (54 / 2))
						&& listaBalas.get(j).getbPosY() < (listaEnemigo1.get(i).getPosY() + (54 / 2))) {
						listaEnemigo1.get(i).setVida(listaEnemigo1.get(i).getVida()-1);
						if (listaEnemigo1.get(i).getVida() == 0) {
							listaEnemigo1.remove(i);
						}
						listaBalas.remove(j);
						puntos += 1;
				}

			}
		}
		
		for (int i = 0; i < listaEnemigo2.size(); i++) {
			for (int j = 0; j < listaBalas.size(); j++) {
				if (listaBalas.get(j).getPosX() > (listaEnemigo2.get(i).getPosX() - (102 / 2))
						&& listaBalas.get(j).getPosX() < (listaEnemigo2.get(i).getPosX() + (102 / 2))
						&& listaBalas.get(j).getbPosY() > (listaEnemigo2.get(i).getPosY() - (54 / 2))
						&& listaBalas.get(j).getbPosY() < (listaEnemigo2.get(i).getPosY() + (54 / 2))) {
						listaEnemigo2.get(i).setVida(listaEnemigo2.get(i).getVida()-1);
						if (listaEnemigo2.get(i).getVida() == 0) {
							listaEnemigo2.remove(i);
						}
						listaBalas.remove(j);
						puntos += 2;
				}
		}					
	}
	}
/////////////////////PERDER///////////////////////	

	private void pierdeJuego() {
		int alturaLienzo = 900;
		for (int i = 0; i < listaEnemigo1.size(); i++) {
			if (alturaLienzo < (listaEnemigo1.get(i).getPosY() + (54 / 2))
					|| listaEnemigo1.get(i).getPosX() > (nave.getPosX() - (158 / 2))
							&& listaEnemigo1.get(i).getPosX() < (nave.getPosX() + (158 / 2))
							&& listaEnemigo1.get(i).getPosY() > (783 - (150 / 2))
							&& listaEnemigo1.get(i).getPosY() < (783 + (150 / 2))) {
				listaEnemigo1.remove(i);
				pantalla = 5;

			}

			for (int j = 0; j < listaEnemigo2.size(); j++) {
				if (listaEnemigo2.size() >= 1) {
					if (alturaLienzo < (listaEnemigo2.get(j).getPosY() + (54 / 2))
							|| listaEnemigo2.get(j).getPosX() > (nave.getPosX() - (158 / 2))
									&& listaEnemigo2.get(j).getPosX() < (nave.getPosX() + (158 / 2))
									&& listaEnemigo2.get(j).getPosY() > (783 - (150 / 2))
									&& listaEnemigo2.get(j).getPosY() < (783 + (150 / 2))) {
						listaEnemigo2.remove(j);
						pantalla = 5;
					}

				}
			}

		}

	}
}
