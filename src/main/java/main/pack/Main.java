package main.pack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import kontrolery.mainWindowController;

public class Main  extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/fxml/mainWindow.fxml"));
		StackPane stackPane=loader.load();		//wyci¹ga stackPane z formatki FXML
		
		mainWindowController controller = loader.getController();	
		
		
		Scene scene = new Scene(stackPane);		//usatwia pane w scenie
		primaryStage.setScene(scene);			//ustawia scene w stage
			
		primaryStage.setTitle("Balistyka");
		primaryStage.show();
	}

}
