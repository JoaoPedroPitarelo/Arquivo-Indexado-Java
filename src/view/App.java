package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("/view/fxml/main.fxml"));
		String arquivoCSS = getClass().getResource("/view/assets/style/style.css").toExternalForm();
		
		Scene principal = new Scene(root, 1000, 600);
	
		principal.getStylesheets().add(arquivoCSS);

		primaryStage.getIcons().add(new Image((getClass().getResourceAsStream("/view/assets/images/icon.png"))));
		primaryStage.setTitle("Clinica do Seu Jorge");
		primaryStage.setResizable(false);
		primaryStage.centerOnScreen();
		primaryStage.setScene(principal);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
