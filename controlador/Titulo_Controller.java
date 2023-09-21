package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Titulo_Controller implements Initializable{

	//Declaraciones FXML
	@FXML private ImageView boton_jugar;
	@FXML private ImageView boton_creditos;
	@FXML private ImageView boton_salir;
	@FXML private ImageView boton_controles;
	@FXML private AnchorPane VentanaTitulo;



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		boton_jugar.setOnMouseClicked((event)     -> cambiarPaginaJuego());
		boton_salir.setOnMouseClicked((event)     -> cerrarAplicacion());
		boton_creditos.setOnMouseClicked((event)  -> abrirPaginaCreditos());
		boton_controles.setOnMouseClicked((event) -> abrirPaginaControles());



	}
	// -------------------------------------------------------------------------------------------------
	// -																							   -
	// - METODOS 																					   -
	// -																							   -
	// -------------------------------------------------------------------------------------------------

	private void cambiarPaginaJuego() {
		Stage primaryStage = (Stage) boton_jugar.getScene().getWindow();
		abrirVentana("vista/PaginaJuego.fxml");
		primaryStage.close();

	}
	private void abrirPaginaCreditos() {
		Stage primaryStage = (Stage) boton_creditos.getScene().getWindow();
		abrirVentana("vista/PaginaCreditos.fxml");
		primaryStage.close();
		
	}
	private void abrirPaginaControles() {
		Stage primaryStage = (Stage) boton_controles.getScene().getWindow();
		abrirVentana("vista/PaginaControles.fxml");
		primaryStage.close();
	}
	
	public void abrirVentana(String s) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(s));
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			scene.getStylesheets().add("vista/application.css");
			stage.setScene(scene);
			stage.getIcons().add(new Image(("icons/PJ.png")));
			stage.setTitle("Array Dungeons");
			stage.initStyle(StageStyle.UNDECORATED);
			stage.show();
			stage.setResizable(false);
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void cerrarAplicacion() {
		Platform.exit();
	}
}
