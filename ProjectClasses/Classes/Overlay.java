import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.Stage;
import javafx.geometry.Insets;
import javafx.scene.text.*;

public class Overlay extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		BorderPane leftBorder = new BorderPane();
		
		VBox stats = new VBox();
		stats.setPadding(new Insets(10));
		
		Text statTitle = new Text("Character Stats:"); //creating a title and adding it to the vertical box.
		statTitle.setFont(Font.font("Arial", FontWeight.Italic(), 16));
		leftBorder.getChildren().add(statTitle);
		
		Pane statList = new Pane();
		
		leftBorder.setLeft(stats);
		
		Scene mainScene = new Scene(leftBorder);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("CSCI Project - Game");
		primaryStage.show();
		
		
		
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
