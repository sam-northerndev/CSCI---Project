/* This class contains the methods for the main menu/title screen of the game
 * It allows the user to select a character from the saved list of characters
 * or create their own character (i.e choose name and class)
 * Started: April 11, 2017
 */
import java.io.*;
import javafx.application.Application;
import javafx.geometry.Pos;
//import javafx.event.ActionEvent;
//import javafx.scene.layout.VBox;
//import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
//import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.*;
//import javafx.scene.image.*;
public class GameStart extends Application {
	@Override public void start(Stage stage){
		//Create a pane for the launch screen
		
		//Creates Pane that holds the title of the game
		StackPane titleScreen = new StackPane();
		titleScreen.setPrefSize(500, 500);
		Label titleName = new Label("GAME TITLE");
		titleName.setFont(new Font("Arial",30));
		titleName.setTextFill(Paint.valueOf("BLUE"));
		titleName.setStyle("-fx-text-color: blue");
		titleName.setAlignment(Pos.CENTER);
		titleScreen.getChildren().add(titleName);
		
		Scene title = new Scene (titleScreen);
		stage.setScene(title);
		stage.setResizable(false);
		stage.show();
	}
	public static void main(String[] args){
		Application.launch(args);
	}

}
