package basic.homework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class homework_member_main extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader load = new FXMLLoader(getClass().getResource("homework_member.fxml"));
		Parent root = load.load();
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("homework_member");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		root.requestFocus();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
