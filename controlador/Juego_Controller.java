package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.ArrayDungeons;

public class Juego_Controller implements Initializable{

	//Atributos
	private Titulo_Controller titulo;
	private ArrayDungeons    tablero;

	//Declaraciones FXML
	@FXML private ImageView boton_volverMenu;
	@FXML private AnchorPane panelJuego;
	@FXML private Paneles_Controller panel_1Controller;
	@FXML private Paneles_Controller panel_2Controller;
	@FXML private Paneles_Controller panel_3Controller;
	@FXML private Paneles_Controller panel_4Controller;
	@FXML private Paneles_Controller panel_5Controller;
	@FXML private Paneles_Controller panel_6Controller;
	@FXML private Paneles_Controller panel_7Controller;
	@FXML private Paneles_Controller panel_8Controller;
	@FXML private Paneles_Controller panel_9Controller;
	
	@FXML private Button botonPrueba;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		boton_volverMenu.setOnMouseClicked((event) -> volverMenu());
		botonPrueba.setOnAction((event)            -> easterEgg());

		panelJuego.requestFocus();

		titulo  = new Titulo_Controller();
		tablero = new ArrayDungeons();		
		
		refrescarPaneles();

	}
	
	@FXML
	void pulsarTecla(KeyEvent event) {
		
		switch (event.getCode()) {
		case W: moverPersonaje("W"); break;
		case A: moverPersonaje("A"); break;
		case S: moverPersonaje("S"); break;
		case D: moverPersonaje("D"); break;
		default:
			break;
		}
	}

	// -------------------------------------------------------------------------------------------------
	// -																							   -
	// - METODOS 																					   -
	// -																							   -
	// -------------------------------------------------------------------------------------------------

	public void volverMenu() {

		Stage primaryStage = (Stage) boton_volverMenu.getScene().getWindow();
		titulo.abrirVentana("vista/PaginaTituloMenu.fxml");
		primaryStage.close();
	}
	
	private void moverPersonaje(String direccion) {
				
		tablero.moverPersonaje(direccion);			
		refrescarPaneles();		
	}
	
	private void refrescarPaneles() {
				
		// Actualizar el panel segun lo que le pases
		this.panel_1Controller.refrescarInformacion(this.tablero.getValor(0, 0));
		this.panel_2Controller.refrescarInformacion(this.tablero.getValor(0, 1));
		this.panel_3Controller.refrescarInformacion(this.tablero.getValor(0, 2));
		this.panel_4Controller.refrescarInformacion(this.tablero.getValor(1, 0));
		this.panel_5Controller.refrescarInformacion(this.tablero.getValor(1, 1));
		this.panel_6Controller.refrescarInformacion(this.tablero.getValor(1, 2));
		this.panel_7Controller.refrescarInformacion(this.tablero.getValor(2, 0));
		this.panel_8Controller.refrescarInformacion(this.tablero.getValor(2, 1));
		this.panel_9Controller.refrescarInformacion(this.tablero.getValor(2, 2));
	}
	
	private void easterEgg() {
		tablero.URL = "icons/easterEgg.png";
		refrescarPaneles();
	}
}