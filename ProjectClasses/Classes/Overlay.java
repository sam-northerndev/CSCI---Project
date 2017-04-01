import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.text.*;
import javafx.scene.layout.*;

public class Overlay extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		BorderPane border = new BorderPane();
		
		VBox stats = new VBox();
		stats.setPadding(new Insets(10));
		
		Text statTitle = new Text("Character Stats:"); //creating a title and adding it to the vertical box.
		statTitle.setFont(Font.font("Arial", FontWeight.THIN, 16));
		border.getChildren().add(statTitle);

		
		border.setLeft(stats);
		
		Scene mainScene = new Scene(border);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("CSCI Project - Game");
		primaryStage.setResizable(true);
		primaryStage.show();
		
		
		
		
	}
}
