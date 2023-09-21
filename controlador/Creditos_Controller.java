package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Creditos_Controller implements Initializable{
	
	private Titulo_Controller titulo = new Titulo_Controller();
	
	@FXML private ImageView botonVolverTitulo;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		botonVolverTitulo.setOnMouseClicked((event) -> volverMenu());
		
	}
	private void volverMenu() {

		Stage primaryStage = (Stage) botonVolverTitulo.getScene().getWindow();
		titulo.abrirVentana("vista/PaginaTituloMenu.fxml");
		primaryStage.close();
	}
}
