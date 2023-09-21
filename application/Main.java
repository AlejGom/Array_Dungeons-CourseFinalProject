package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			String fxml = "vista/PaginaTituloMenu.fxml";
			
			// Cargar la ventana
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
			
			// Cargar la Scene
			Scene scene = new Scene(root);
			
			// Asignar propiedades al Stage
			primaryStage.setTitle("Array Dungeons Titulo");
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setResizable(false);
			
			//Icono aplicacion
			primaryStage.getIcons().add(new Image(("icons/PJ.png")));
			
			// Asignar la scene y mostrar
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}