package modelo;

import controlador.Titulo_Controller;

public class ArrayDungeons {

	private Titulo_Controller titulo = new Titulo_Controller();

	//Atributos
	private Entidades[][] tablero;
	private int fila;
	private int columna;
	private int vidaPersonaje  = 10;
	private int danyoPersonaje = 0;
	public  int puntuacion;
	
	public String URL = "icons/PJ.png";


	//Constructor
	public ArrayDungeons() {

		super();
		
		
		this.tablero = new Entidades[3][3];

		this.fila    = 1;
		this.columna = 1;

		generarTablero();
		spawnearPersonaje();
	}

	//Getters
	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}
	
	public String getPuntuacion() {
		return puntuacion + "";
	}

	public Entidades getValor(int f, int c) {
		return this.tablero[f][c];
	}

	//Metodos

	// Entidad aleatoria mediante numeros aleatorios
	private Entidades generarEntidad(int filas, int columnas) {
		String[] entidades = {"Vacio", "Enemigo", "Pocion", "Arma", "Moneda", "Enemigo", "Pocion", "Moneda"};
		int r = (int) (Math.random()*(entidades.length));

		switch (entidades[r]) {
		case "Enemigo":
			return new Enemigo("icons/enemigo" + generarEnemigoAleatorio() + ".png", "Enemigo", generarVidaAleatoria(), 0, "icons/vacio.png");
		case "Vacio":
			return new Vacio("icons/vacio.png", "Vacio", 0, 0, "icons/vacio.png");
		case "Pocion":
			return new Pocion("icons/pocion.png", "Pocion", generarCuracionAleatoria(), 0, "icons/vacio.png");
		case "Arma":
			return new Arma("icons/arma" + generarArmaAleatoria() + ".png", "Arma", 0, generarVidaAleatoria(), "icons/vacio.png");
		case "Moneda":
			return new Arma("icons/moneda.png", "Moneda", 0, generarVidaAleatoria(), "icons/vacio.png");
		default:
			return null;
		}
	}

	//Genera un tablero de 9x9 inicializado como entidad aleatoria
	public void generarTablero() {

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {

				tablero[i][j] = generarEntidad(i, j);
			}
		}
	}

	//Genera el personaje en la posicion actual del tablero
	private void spawnearPersonaje() {
		this.tablero[this.fila][this.columna] = new Personaje(URL, "Personaje", vidaPersonaje, danyoPersonaje, "icons/corazon.png");
	}

	private void despawnearPersonaje(int f, int c) {
		this.tablero[f][c] = generarEntidad(f, c);
	}

	//Metodo para mover el personaje
	public void moverPersonaje(String direccion) {

		int filaAux    = this.fila;
		int columnaAux = this.columna;

		switch (direccion) {
		case "W": if (filaAux > 0)    { this.fila    = filaAux - 1;    calculosAtributosPersonaje(this.fila, this.columna);} break;
		case "A": if (columnaAux > 0) { this.columna = columnaAux - 1; calculosAtributosPersonaje(this.fila, this.columna);} break;
		case "S": if (filaAux < 2)    { this.fila    = filaAux + 1;    calculosAtributosPersonaje(this.fila, this.columna);} break;
		case "D": if (columnaAux < 2) { this.columna = columnaAux + 1; calculosAtributosPersonaje(this.fila, this.columna);} break;
		}

		despawnearPersonaje(filaAux, columnaAux);		
		spawnearPersonaje();
	}

	//Metodo para restar la vida actual del enemigo al personaje
	private void calculosAtributosPersonaje(int f, int c) {
		//Calculos para cuando el personaje se cruza con un enemigo
		if (getValor(f, c).id.equals("Enemigo")) {
			if (this.danyoPersonaje != 0) {
				if (this.danyoPersonaje - getValor(f, c).getVida() < 0) {
					if (this.vidaPersonaje - (getValor(f, c).getVida() - this.danyoPersonaje) <= 0) {
						titulo.abrirVentana("vista/PantallaMuerte.fxml");
						
					} else {
						this.puntuacion += getValor(f, c).getVida();
						System.out.println(puntuacion);
						this.vidaPersonaje -= (getValor(f, c).getVida() - this.danyoPersonaje);
						this.danyoPersonaje = 0;
					}
				} else {
					this.puntuacion += getValor(f, c).getVida();
					System.out.println(puntuacion);
					this.danyoPersonaje = this.danyoPersonaje - getValor(f, c).getVida();
				}
			} else {
				if (this.vidaPersonaje - getValor(f, c).getVida() <= 0) {
					titulo.abrirVentana("vista/PantallaMuerte.fxml");
					this.vidaPersonaje = 0;
					
				} else {
					this.puntuacion += getValor(f, c).getVida();
					System.out.println(puntuacion);
					this.vidaPersonaje = this.vidaPersonaje - getValor(f, c).getVida();
				}
			}
		}
		//Calculos para cuando el personaje recoge una pocion
		if (getValor(f, c).id.equals("Pocion")) {
			if (this.vidaPersonaje + getValor(f, c).getVida() >= 10) {
				this.vidaPersonaje = 10;
				
			} else {
				this.vidaPersonaje +=getValor(f, c).getVida();
			}
		}
		//Calculos para cuando el personaje recoge un arma
		if (getValor(f, c).id.equals("Arma")) {
			this.danyoPersonaje = getValor(f, c).getDanyoArma();
		}
		//Calculos para cuando el personaje recoge una moneda
		if (getValor(f, c).id.equals("Moneda")) {
			this.puntuacion += getValor(f, c).getDanyoArma();
			System.out.println(puntuacion);
		}
	}
	//Genera un numero aleatorio para asignarlo a la vida
	private int generarVidaAleatoria() {
		return (int) (Math.random()*(11 - 1) + 1);
	}

	private int generarCuracionAleatoria() {
		return (int) (Math.random()*(6 - 1) + 1);
	}

	private int generarEnemigoAleatorio() {
		return (int) (Math.random()*(5 - 1) + 1);
	}
	private int generarArmaAleatoria() {
		return (int) (Math.random()*(3 - 1) + 1);
	}
}