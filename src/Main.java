
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	
	PImage imgInicio;
	PImage imgInstrucciones;
	PImage imgResumen;
	PImage imgJuego;
	
	
	int pantalla = 1;
	
	public Main() {	

	}

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
		
	}
	
	public void settings() {
		size (600, 900);
	}
	
	public void setup() {
		cargarFondos();
		//cargarBotones();
		
	}
	
	public void draw() {
		imageMode(CENTER);
		System.out.println(mouseX);
		cambioPantallas();
		
		
		
		/*image(bJugar,310,478);
		image(bInstrucciones,310,593);
		image(bSalir,310,708);*/
	}
	
	public void mousePressed() {
		clickBoton();	
		
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
			background (imgInicio);
			break;
			
		case 2:
			background (imgJuego);
			break;
			
		case 3:
			background (imgInstrucciones);
			break;
			
		case 4:
			background (imgResumen);
			break;
			
		case 5:
			
			break;

		}
		
	}
	
	public void clickBoton() {
		switch (pantalla) {
		case 1:
			if (mouseX > 188 && mouseX < 422 && mouseY > 439 && mouseY < 506){
				pantalla = 2;
			} else if (mouseX > 188 && mouseX < 422 && mouseY > 555 && mouseY < 621){
				pantalla = 3;
			}else if (mouseX > 188 && mouseX < 422 && mouseY > 670 && mouseY < 736){
					pantalla = 4;
			}
			break;
			
		case 2:
			background (imgJuego);
			break;
			
		case 3:
			if (mouseX > 46 && mouseX < 217 && mouseY > 108 && mouseY < 174){
				pantalla = 1;
			}
			break;
			
		case 4:
			background (imgResumen);
			if (mouseX > 170 && mouseX < 418 && mouseY > 522 && mouseY < 588){
				pantalla = 2;
			}
			break;
		
			}
	}
	


}
