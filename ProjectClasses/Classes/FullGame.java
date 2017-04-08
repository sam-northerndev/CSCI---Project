/* Class contains all the GUI's put together
 * April 1, 2017
 */
import java.io.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;

public class FullGame extends Application {
	@Override public void start(Stage stage){
		
		//Creates the board from GridMap
		GridMap g = new GridMap();
		g.generateObjective();
		g.generateObstacles();
		g.generateCharacter(new Character("Bob","B"), new Character("Craig","B"), new Character("Sam","B"),"blue");
		g.generateCharacter(new Character("Man","R"), new Character("Woman","R"), new Character("Child","R"),"red");
		
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
				board[i][j].setStyle("-fx-border-color: black; -fx-background-color: green;-fx-font-size:35");
				board[i][j].setMinSize(80, 80);
				board[i][j].setMaxSize(80, 80);
				board[i][j].setOnAction(this::processButtonPress);
				grid.add(board[i][j],i,j+1);
			}
		}
		grid.setPadding(new Insets(10,10,10,10));
		
		//Set the images of the characters to their beginning position
		//Uses the GridMap to locate the characters
		//1.Sets the towers
		ImageView bTower = new ImageView
				(new Image(new File("C:/Users/Joan/Documents/Eclipse/Project CSCI 1101/qk1yu_Dn.jpg").toURI().toString()));
		bTower.setFitHeight(50);
		bTower.setFitWidth(27);
		StackPane bTowerPane = new StackPane();
		bTowerPane.getChildren().add(bTower);
		board[0][0].setText("");
		board[0][0].setGraphic(bTowerPane);
		
		ImageView rTower = new ImageView (new Image(new File("C:/Users/Joan/Documents/Eclipse/Project CSCI 1101/"
				+ "033893-simple-red-glossy-icon-culture-castle-five-towers[1].png").toURI().toString()));
		rTower.setFitHeight(52);
		rTower.setFitWidth(27);
		StackPane rTowerPane = new StackPane();
		rTowerPane.getChildren().add(rTower);
		board[7][7].setText("");
		board[7][7].setGraphic(rTowerPane);
		
		//Sets the characters to their Starting Position on the board GUI (Alpha - using Color coded letters to display character)
		//(will replace with pictures of characters when available)
		board[1][0].setText("C");
		board[1][0].setStyle("-fx-border-color: black; -fx-background-color: green;"
				+ "-fx-text-fill:blue;-fx-font-size:35");
		board[1][1].setText("C");
		board[1][1].setStyle("-fx-border-color: black; -fx-background-color: green;"
		+ "-fx-text-fill:blue;-fx-font-size:35");
		board[0][1].setText("C");
		board[0][1].setStyle("-fx-border-color: black; -fx-background-color: green;"
				+ "-fx-text-fill:blue;-fx-font-size:35");
		board[6][7].setText("C");
		board[6][7].setStyle("-fx-border-color: black; -fx-background-color: green;"
				+ "-fx-text-fill:red;-fx-font-size:35");
		board[6][6].setText("C");
		board[6][6].setStyle("-fx-border-color: black; -fx-background-color: green;"
		+ "-fx-text-fill:red;-fx-font-size:35");
		board[7][6].setText("C");
		board[7][6].setStyle("-fx-border-color: black; -fx-background-color: green;"
				+ "-fx-text-fill:red;-fx-font-size:35");
		

		
		//Sets the grid to the center
		border.setCenter(grid);
		
		//Creates the scene
		Scene scene = new Scene(border);
		stage.setTitle("Game Board");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}
	//Button Press processing method
	public void processButtonPress(ActionEvent event){
		
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
}
