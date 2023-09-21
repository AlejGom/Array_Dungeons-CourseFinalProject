package controlador;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Entidades;

public class Paneles_Controller{

	@FXML private ImageView imagenPrincipal;
	@FXML private ImageView vida;
	@FXML private ImageView danyoArma;
	@FXML private ImageView corazon;

	public void refrescarInformacion(Entidades entidades) {

		Image image     = new Image(entidades.getUrl());
		Image vida      = new Image(obtenerVida(entidades.getVida()));
		Image corazon   = new Image(entidades.getCorazon());
		Image danyoArma = new Image(obtenerDanyoArma(entidades.getDanyoArma()));
		
		this.imagenPrincipal.setImage(image);
		this.vida.setImage(vida);
		this.corazon.setImage(corazon);
		this.danyoArma.setImage(danyoArma);

	}

	//Obtener la vida del personaje y asignarle un numero en funcion
	public String obtenerVida(int vida) {

		switch (vida) {
		
		case 10:return "icons/Numeros y letras/numero10.png";
		case 9:return "icons/Numeros y letras/numero9.png";
		case 8:return "icons/Numeros y letras/numero8.png";
		case 7:return "icons/Numeros y letras/numero7.png";
		case 6:return "icons/Numeros y letras/numero6.png";
		case 5:return "icons/Numeros y letras/numero5.png";
		case 4:return "icons/Numeros y letras/numero4.png";
		case 3:return "icons/Numeros y letras/numero3.png";
		case 2:return "icons/Numeros y letras/numero2.png";
		case 1:return "icons/Numeros y letras/numero1.png";
		case 0:return "icons/vacio.png";
			
		default:
			return "";
		}
	}
		public String obtenerDanyoArma(int danyo) {

			//Obtener el danyo del arma y asignarle un numero en funcion
			switch (danyo) {
			
			case 10:return "icons/Numeros y letras/numero10 blanco.png";
			case 9:return "icons/Numeros y letras/numero9 blanco.png";
			case 8:return "icons/Numeros y letras/numero8 blanco.png";
			case 7:return "icons/Numeros y letras/numero7 blanco.png";
			case 6:return "icons/Numeros y letras/numero6 blanco.png";
			case 5:return "icons/Numeros y letras/numero5 blanco.png";
			case 4:return "icons/Numeros y letras/numero4 blanco.png";
			case 3:return "icons/Numeros y letras/numero3 blanco.png";
			case 2:return "icons/Numeros y letras/numero2 blanco.png";
			case 1:return "icons/Numeros y letras/numero1 blanco.png";
			case 0:return "icons/vacio.png"; 
				
			default:
				return "";
			}
	}
}