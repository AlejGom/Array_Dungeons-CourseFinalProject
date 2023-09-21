package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.ArrayDungeons;

public class Final_Controller implements Initializable{
	
	private Titulo_Controller titulo = new Titulo_Controller();
	private ArrayDungeons infoJuego  = new ArrayDungeons();
	
	@FXML private ImageView  botonRetroceder;
	@FXML private TextField  puntuacionFinal;
	@FXML private AnchorPane panelFinal;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		botonRetroceder.setOnMouseClicked((event) -> volverMenu());
		puntuacionFinal.setText(infoJuego.getPuntuacion());
		
	}
	private void volverMenu() {

		Stage primaryStage = (Stage) botonRetroceder.getScene().getWindow();
		titulo.abrirVentana("vista/PaginaTituloMenu.fxml");
		primaryStage.close();
	}
}


