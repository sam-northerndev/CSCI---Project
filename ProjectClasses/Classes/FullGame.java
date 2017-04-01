/* Class conatins all the GUI's put together
 * April 1, 2017
 */
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

public class FullGame extends Application {
	@Override public void start(Stage stage){
		
		//Create the BorderPane
		BorderPane border = new BorderPane();
		
		//Creates the Vertical Box for Character Status information
		VBox stats = new VBox(10);
		stats.setPadding(new Insets(15,12,15,12));
		stats.setStyle("-fx-background-color:red");
			
		Text statTitle = new Text("Character Stats:"); //creating a title and adding it to the vertical box.
		statTitle.setFont(Font.font("Arial", FontWeight.THIN, 16));
		stats.getChildren().add(statTitle);
		
		Text HP = new Text("HP: 35");
		Text Attack = new Text("Attack: 5");
		Text Defense = new Text("Def: 10");
		
		stats.getChildren().add(HP);
		stats.getChildren().add(Attack);
		stats.getChildren().add(Defense);



		//Sets the Left border to the status box
		border.setLeft(stats);
		
		//Creates the GridPane
		GridPane grid = new GridPane();
		Button[][] board = new Button[8][8];
		grid.setHgap(0);
		grid.setVgap(0);
		grid.setStyle("-fx-background-color:blue");
		for (int i = 0; i<8; i++){
			for (int j = 0; j<8; j++){
				board[i][j] = new Button();
				board[i][j].setText("O");
				board[i][j].setStyle("-fx-border-color: black; -fx-background-color: green;"
						+ "-fx-text-fill:green;-fx-font-size:35");
				grid.add(board[i][j],i,j+1);
			}
		}
		grid.setPadding(new Insets(10,10,10,10));
		
		//Sets the grid to the center
		border.setCenter(grid);
		
		//Creates the scene
		Scene scene = new Scene(border);
		stage.setTitle("Game Board");
		stage.setScene(scene);
		stage.setResizable(true);
		stage.show();

	}
	public static void main(String[] args){
		Application.launch(args);
	}
}
