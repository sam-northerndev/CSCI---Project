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
	private Button[][] board;
	private LinkedList[][] map;
	private GridMap g;
	private VBox stats;
	private Text name;
	private Image blue1,blue2,blue3,red1,red2,red3;
	@Override public void start(Stage stage){
		
		//Creates the board from GridMap
		g = new GridMap();
		g.generateObjective();
		g.generateObstacles();
		g.generateCharacter(new Character("Bob","B"), new Character("Craig","B"), new Character("Sam","B"),"blue");
		g.generateCharacter(new Character("Man","R"), new Character("Woman","R"), new Character("Child","R"),"red");
		map = g.getGrid();
		
		//Create the BorderPane
		BorderPane border = new BorderPane();
		
		//Creates the Vertical Box for Character Status information
		stats = new VBox(10);
		stats.setPadding(new Insets(15,12,15,12));
		stats.setStyle("-fx-background-color:red");
			
		Text statTitle = new Text("Character Stats:"); //creating a title and adding it to the vertical box.
		statTitle.setFont(Font.font("Arial", FontWeight.THIN, 16));
		stats.getChildren().add(statTitle);
		
		name = new Text("Bob");
		//Text Attack = new Text("Attack: 5");
		//Text Defense = new Text("Def: 10");
		
		stats.getChildren().add(name);
		//stats.getChildren().add(Attack);
		//stats.getChildren().add(Defense);

		//Sets the Left border to the status box
		border.setLeft(stats);
		
		//Creates the GridPane
		GridPane grid = new GridPane();
		board = new Button[8][8];
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
				grid.add(board[i][j],j,i);
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
		
		blue1 = new Image(new File("C:/Users/Joan/Documents/Eclipse/Project 2.0/stick figure - grey.png").toURI().toString());
		blue2 = new Image(new File("C:/Users/Joan/Documents/Eclipse/Project 2.0/stick figure - grey.png").toURI().toString());
		blue3 = new Image(new File("C:/Users/Joan/Documents/Eclipse/Project 2.0/stick figure - grey.png").toURI().toString());
		red1 = new Image(new File("C:/Users/Joan/Documents/Eclipse/Project 2.0/stick-person-red.png").toURI().toString());
		red2 = new Image(new File("C:/Users/Joan/Documents/Eclipse/Project 2.0/stick-person-red.png").toURI().toString());
		red3 = new Image(new File("C:/Users/Joan/Documents/Eclipse/Project 2.0/stick-person-red.png").toURI().toString());
		
		//Sets the characters to their Starting Position on the board GUI (Alpha - using Color coded letters to display character)
		//(will replace with pictures of characters when available)
		board[1][0].setGraphic(new ImageView(blue1));
		//board[1][0].setStyle("-fx-border-color: black; -fx-background-color: green;"
		//		+ "-fx-text-fill:blue;-fx-font-size:35;");
		board[1][1].setGraphic(new ImageView(blue2));
		//board[1][1].setStyle("-fx-border-color: black; -fx-background-color: green;"
		//+ "-fx-text-fill:blue;-fx-font-size:35;");
		board[0][1].setGraphic(new ImageView(blue3));
		//board[0][1].setStyle("-fx-border-color: black; -fx-background-color: green;"
		//		+ "-fx-text-fill:blue;-fx-font-size:35;");
		board[6][7].setGraphic(new ImageView(red1));
		//board[6][7].setStyle("-fx-border-color: black; -fx-background-color: green;"
		//		+ "-fx-text-fill:red;-fx-font-size:35;");
		board[6][6].setGraphic(new ImageView(red2));
		//board[6][6].setStyle("-fx-border-color: black; -fx-background-color: green;"
		//+ "-fx-text-fill:red;-fx-font-size:35;");
		board[7][6].setGraphic(new ImageView(red3));
		//board[7][6].setStyle("-fx-border-color: black; -fx-background-color: green;"
		//		+ "-fx-text-fill:red;-fx-font-size:35;");
		
		//Adds the obstacles to the board
		for (int i = 0; i<8; i++){
			for(int j = 0; j<8; j++){
				if(map[0][i].getNode(j).getObstacle() != null){
					board[i][j].setText("O");
					board[i][j].setStyle("-fx-text-fill: orange; -fx-background-color: green;"
							+ "-fx-border-color: black;-fx-font-size:35;");
				}
			}
		}
		

		
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
		//Finds the button that was pressed
		for (int i = 0; i<8; i++){
			for (int j = 0; j<8 ; j++){
				if(event.getSource() == board[i][j]){
					//Checks if the button has character on it
					if(map[0][i].getNode(j).getCharacter() != null){
						//Display characters stats
						Character c = map[0][i].getNode(j).getCharacter();
						name.setText(c.getName());
						//checks to see if the character is on the current player's team
						if (c.getTeam().equals("B")||c.getTeam().equals("R")){
							//sets the Action of the button to move/attack with the character
							if(j+1 < 8 && map[0][i].getNode(j+1).getEmptySpace() != null)
								board[i][j+1].setOnAction(this::processMoveCharRight);
							if(j-1 >= 0 && map[0][i].getNode(j-1).getEmptySpace() != null)
								board[i][j-1].setOnAction(this::processMoveCharLeft);
							if(i-1 >= 0 && map[0][i-1].getNode(j).getEmptySpace() != null)
								board[i-1][j].setOnAction(this::processMoveCharUp);
							if(i+1 < 8 && map[0][i+1].getNode(j).getEmptySpace() != null)
								board[i+1][j].setOnAction(this::processMoveCharDown);
						}
					}
				}
			}
		}
	}
	
	//Process for character movement to the right
	public void processMoveCharRight(ActionEvent event){
		//Finds the button that was pressed
		for (int i = 0; i<8; i++){
			for (int j = 0; j<8 ; j++){
				if(event.getSource() == board[i][j]){
					//Moves the character on the GridMap
					Character c = map[0][i].getNode(j-1).getCharacter();
					g.moveChar("right", c);
					//Move the character on the board
					board[i][j-1].setGraphic(null);
					if (c.getTeam().equals("B")){
						board[i][j].setGraphic(new ImageView(blue1));
					}
					else {
						board[i][j].setGraphic(new ImageView(red1));
					}
					System.out.println("Move Right");
					g.displayMap();
					if (i-1 >=0 && j-1 >=0)
						board[i-1][j-1].setOnAction(this::processButtonPress);
					if (j-2 >=0)
						board[i][j-2].setOnAction(this::processButtonPress);
					if (i+1 < 8 && j-1 >= 0)
						board[i+1][j-1].setOnAction(this::processButtonPress);
					board[i][j].setOnAction(this::processButtonPress);
				}
			}
		}
	}
	
	//Process for character movement to the left
	public void processMoveCharLeft(ActionEvent event){
		//Finds the button that was pressed
		for (int i = 0; i<8; i++){
			for (int j = 0; j<8 ; j++){
				if(event.getSource() == board[i][j]){
					//Moves the character on the GridMap
					Character c = map[0][i].getNode(j+1).getCharacter();
					g.moveChar("left", c);
					board[i][j+1].setGraphic(null);
					//Move the character on the board
					if (c.getTeam().equals("B")){
						board[i][j].setGraphic(new ImageView(blue1));
					}
					else {
						board[i][j].setGraphic(new ImageView(red1));
					}
					System.out.println("Move Left");
					g.displayMap();
					if(j+2 < 8)
						board[i][j+2].setOnAction(this::processButtonPress);
					board[i][j].setOnAction(this::processButtonPress);
					if (i + 1 < 8 && j + 1 < 8)
						board[i+1][j+1].setOnAction(this::processButtonPress);
					if (i-1 >= 0 && j+1 < 8)
						board[i-1][j+1].setOnAction(this::processButtonPress);
				}
			}
		}
	}
	
	//Process for character movement upward
	public void processMoveCharUp(ActionEvent event){
		//Finds the button that was pressed
		for (int i = 0; i<8; i++){
			for (int j = 0; j<8 ; j++){
				if(event.getSource() == board[i][j]){
					//Moves the character on the GridMap
					Character c = map[0][i+1].getNode(j).getCharacter();
					g.moveChar("up", c);
					//Move the character on the board
					board[i+1][j].setGraphic(null);
					if (c.getTeam().equals("B")){
						board[i][j].setGraphic(new ImageView(blue1));
					}
					else {
						board[i][j].setGraphic(new ImageView(red1));
					}
					System.out.println("Move Up");
					g.displayMap();
					if (i+1 < 8 && j+1 < 8)
						board[i+1][j+1].setOnAction(this::processButtonPress);
					if (i+1 < 8 && j-1 >= 0)
						board[i+1][j-1].setOnAction(this::processButtonPress);
					board[i][j].setOnAction(this::processButtonPress);
					if (i+2 > 8)
						board[i+2][j].setOnAction(this::processButtonPress);
				}
			}
		}
	}
	
	//Process for character movement downward
	public void processMoveCharDown(ActionEvent event){
		//Finds the button that was pressed
		for (int i = 0; i<8; i++){
			for (int j = 0; j<8 ; j++){
				if(event.getSource() == board[i][j]){
					//Moves the character on the GridMap
					Character c = map[0][i-1].getNode(j).getCharacter();
					g.moveChar("down", c);
					//Move the character on the board
					board[i-1][j].setGraphic(null);
					if (c.getTeam().equals("B")){
						board[i][j].setGraphic(new ImageView(blue1));
					}
					else {
						board[i][j].setGraphic(new ImageView(red1));
					}
					System.out.println("Move Down");
					g.displayMap();
					if (i-1 >= 0 && j+1 < 8)
						board[i-1][j+1].setOnAction(this::processButtonPress);
					if (i-1 >=0 && j-1 >=0)
						board[i-1][j-1].setOnAction(this::processButtonPress);
					board[i][j].setOnAction(this::processButtonPress);
					if (i-2 >= 0)
						board[i-2][j].setOnAction(this::processButtonPress);
				}
			}
		}
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
}
