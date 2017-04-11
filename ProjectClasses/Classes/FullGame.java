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
import javafx.scene.image.*;

public class FullGame extends Application {
	private Button[][] board;
	private LinkedList[][] map;
	private GridMap g;
	private VBox stats;
	private Text title;
	private Text name;
	private Text hp;
	private Image blue1,blue2,blue3,red1,red2,red3;
	private Image tree,water,hole,rock;
	private Image rTower,bTower;
	@Override public void start(Stage stage){
		
		//assigns the Image objects to their respective image
		blue1 = new Image(new File("stick figure - grey.png").toURI().toString());
		blue2 = new Image(new File("stick figure - grey.png").toURI().toString());
		blue3 = new Image(new File("stick figure - grey.png").toURI().toString());
		red1 = new Image(new File("stick-person-red.png").toURI().toString());
		red2 = new Image(new File("stick-person-red.png").toURI().toString());
		red3 = new Image(new File("stick-person-red.png").toURI().toString());
		tree = new Image(new File("tree-icon.png").toURI().toString());
		water = new Image(new File("water.png").toURI().toString());
		hole = new Image(new File("hole.png").toURI().toString());
		rock = new Image(new File("minerals_pure_silver-256.png").toURI().toString());
		rTower = new Image(new File("castle_red.png").toURI().toString());
		bTower = new Image(new File("castle_blue.png").toURI().toString());
		
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
		stats.setPrefSize(150, 400);
		stats.setStyle("-fx-background-color:red");
			
		title = new Text("Game Start!"); //creating a title and adding it to the vertical box.
		title.setFont(Font.font("Arial", FontWeight.THIN, 16));
		stats.getChildren().add(title);
		//stats.getChildren().add(title);
		//Creates the name Text object (used later to print name of the characters
		name = new Text();
		hp = new Text();
		//stats.getChildren().add(name);
		
		//Sets the Left border to the status box
		border.setLeft(stats);
		
		//Creates the GridPane
		//Also sets the image of the obstacles if there is one
		GridPane grid = new GridPane();
		board = new Button[8][8];
		grid.setHgap(0);
		grid.setVgap(0);
		grid.setStyle("-fx-background-color:blue");
		for (int i = 0; i<8; i++){
			for (int j = 0; j<8; j++){
				board[i][j] = new Button();
				if (map[0][i].getNode(j).getCharacter() != null){
					if (map[0][i].getNode(j).getCharacter().getTeam().equals("B"))
						board[i][j].setStyle("-fx-border-color: lightblue; -fx-background-color: green;");
					else
						board[i][j].setStyle("-fx-border-color: red; -fx-background-color: green;");
				}
				else
					board[i][j].setStyle("-fx-border-color: black; -fx-background-color: green;");
				board[i][j].setMinSize(80, 80);
				board[i][j].setMaxSize(80, 80);
				if (map[0][i].getNode(j).getObstacle() != null){
					Obstacle o = map[0][i].getNode(j).getObstacle();
					if (o.getName().equals("Tree"))
						board[i][j].setGraphic(new ImageView(tree));
					else if (o.getName().equals("Water"))
						board[i][j].setGraphic(new ImageView(water));
					else if (o.getName().equals("Hole"))
						board[i][j].setGraphic(new ImageView(hole));
					else
						board[i][j].setGraphic(new ImageView(rock));
				}
					
				board[i][j].setOnAction(this::processButtonPress);
				grid.add(board[i][j],j,i);
			}
		}
		grid.setPadding(new Insets(10,10,10,10));
		
		//Set Towers images to the board
		board[0][0].setGraphic(new ImageView(bTower));
		board[7][7].setGraphic(new ImageView(rTower));
		
		//Sets the characters to their Starting Position on the board GUI (Alpha - using Color coded letters to display character)
		//(will replace with pictures of characters when available)
		board[1][0].setGraphic(new ImageView(blue1));
		board[1][1].setGraphic(new ImageView(blue2));
		board[0][1].setGraphic(new ImageView(blue3));
		board[6][7].setGraphic(new ImageView(red1));
		board[6][6].setGraphic(new ImageView(red2));
		board[7][6].setGraphic(new ImageView(red3));
		
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
					Node location = map[0][i].getNode(j);
					if(location.getCharacter() != null){
						//Display characters stats
						Character c = location.getCharacter();
						stats.getChildren().clear();
						title.setText("Charcter");
						name.setText(c.getName());
						stats.getChildren().addAll(title,name);
						//checks to see if the character is on the current player's team
						if (c.getTeam().equals("B")||c.getTeam().equals("R")){
							resetButtonAction();
							//sets the Action of the button to move/attack with the character
							if(j+1 < 8 && map[0][i].getNode(j+1).getEmptySpace() != null){
								board[i][j+1].setOnAction(this::processMoveCharRight);
								board[i][j+1].setStyle("-fx-border-color: yellow;-fx-background-color: green;");
							}
							if(j-1 >= 0 && map[0][i].getNode(j-1).getEmptySpace() != null){
								board[i][j-1].setOnAction(this::processMoveCharLeft);
								board[i][j-1].setStyle("-fx-border-color: yellow;-fx-background-color: green;");
							}
							if(i-1 >= 0 && map[0][i-1].getNode(j).getEmptySpace() != null){
								board[i-1][j].setOnAction(this::processMoveCharUp);
								board[i-1][j].setStyle("-fx-border-color: yellow;-fx-background-color: green;");
							}
							if(i+1 < 8 && map[0][i+1].getNode(j).getEmptySpace() != null){
								board[i+1][j].setOnAction(this::processMoveCharDown);
								board[i+1][j].setStyle("-fx-border-color: yellow;-fx-background-color: green;");
							}
						}
					}
					else if (location.getObstacle() != null){
						stats.getChildren().clear();
						//Display name of obstacle
						title.setText("Obstacle");
						name.setText(location.getObstacle().getName());
						stats.getChildren().addAll(title,name);
					}
					else if(location.getObjective() != null){
						stats.getChildren().clear();
						//Display team name and HP remaining
						title.setText("Objective");
						name.setText("Team "+location.getObjective().getTeam());
						hp.setText("HP: "+location.getObjective().getHp()+"/100");
						stats.getChildren().addAll(title,name,hp);
					}
					else if(location.getEmptySpace() != null){
						//Clear stats board, Nothing to show
						stats.getChildren().clear();
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
						board[i][j].setStyle("-fx-border-color: lightblue;-fx-background-color: green;");
					}
					else {
						board[i][j].setGraphic(new ImageView(red1));
						board[i][j].setStyle("-fx-border-color: red;-fx-background-color: green;");
					}
					//System.out.println("Move Right");
					//g.displayMap();
					if (i-1 >=0 && j-1 >=0 && map[0][i-1].getNode(j-1).getCharacter() == null){
						board[i-1][j-1].setOnAction(this::processButtonPress);
						board[i-1][j-1].setStyle("-fx-border-color: black;-fx-background-color: green;");
					}
					if (j-2 >=0 && map[0][i].getNode(j-2).getCharacter() == null){
						board[i][j-2].setOnAction(this::processButtonPress);
						board[i][j-2].setStyle("-fx-border-color: black;-fx-background-color: green;");
					}
					if (i+1 < 8 && j-1 >= 0 && map[0][i+1].getNode(j-1).getCharacter() == null){
						board[i+1][j-1].setOnAction(this::processButtonPress);
						board[i+1][j-1].setStyle("-fx-border-color: black;-fx-background-color: green;");
					}
					board[i][j].setOnAction(this::processButtonPress);
					board[i][j-1].setStyle("-fx-border-color: black;-fx-background-color: green;");
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
						board[i][j].setStyle("-fx-border-color: lightblue;-fx-background-color: green;");
					}
					else {
						board[i][j].setGraphic(new ImageView(red1));
						board[i][j].setStyle("-fx-border-color: red;-fx-background-color: green;");
					}
					//System.out.println("Move Left");
					//g.displayMap();
					if(j+2 < 8 && map[0][i].getNode(j+2).getCharacter() == null){
						board[i][j+2].setOnAction(this::processButtonPress);
						board[i][j+2].setStyle("-fx-border-color: black;-fx-background-color: green;");
					}
					if (i + 1 < 8 && j + 1 < 8 && map[0][i+1].getNode(j+1).getCharacter() == null){
						board[i+1][j+1].setOnAction(this::processButtonPress);
						board[i+1][j+1].setStyle("-fx-border-color: black;-fx-background-color: green;");
					}
					if (i-1 >= 0 && j+1 < 8 && map[0][i-1].getNode(j+1).getCharacter() == null){
						board[i-1][j+1].setOnAction(this::processButtonPress);
						board[i-1][j+1].setStyle("-fx-border-color: black;-fx-background-color: green;");
					}
					board[i][j].setOnAction(this::processButtonPress);
					board[i][j+1].setStyle("-fx-border-color: black;-fx-background-color: green;");
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
						board[i][j].setStyle("-fx-border-color: lightblue;-fx-background-color: green;");
					}
					else {
						board[i][j].setGraphic(new ImageView(red1));
						board[i][j].setStyle("-fx-border-color: red;-fx-background-color: green;");
					}
					//System.out.println("Move Up");
					//g.displayMap();
					if (i+1 < 8 && j+1 < 8 && map[0][i+1].getNode(j+1).getCharacter() == null){
						board[i+1][j+1].setOnAction(this::processButtonPress);
						board[i+1][j+1].setStyle("-fx-border-color: black;-fx-background-color: green;");
					}
					if (i+1 < 8 && j-1 >= 0 && map[0][i+1].getNode(j-1).getCharacter() == null){
						board[i+1][j-1].setOnAction(this::processButtonPress);
						board[i+1][j-1].setStyle("-fx-border-color: black;-fx-background-color: green;");
					}
					if (i+2 < 8 && map[0][i+2].getNode(j).getCharacter() == null){
						board[i+2][j].setOnAction(this::processButtonPress);
						board[i+2][j].setStyle("-fx-border-color: black;-fx-background-color: green;");
					}
					board[i][j].setOnAction(this::processButtonPress);
					board[i+1][j].setStyle("-fx-border-color: black;-fx-background-color: green;");
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
						board[i][j].setStyle("-fx-border-color: lightblue;-fx-background-color: green;");
					}
					else {
						board[i][j].setGraphic(new ImageView(red1));
						board[i][j].setStyle("-fx-border-color: red;-fx-background-color: green;");
					}
					//System.out.println("Move Down");
					//g.displayMap();
					//Resets the buttons (if There was a button in the first place
					if (i-1 >= 0 && j+1 < 8 && map[0][i-1].getNode(j+1).getCharacter() == null){
						board[i-1][j+1].setOnAction(this::processButtonPress);
						board[i-1][j+1].setStyle("-fx-border-color: black;-fx-background-color: green;");
					}
					if (i-1 >=0 && j-1 >=0 && map[0][i-1].getNode(j-1).getCharacter() == null){
						board[i-1][j-1].setOnAction(this::processButtonPress);
						board[i-1][j-1].setStyle("-fx-border-color: black;-fx-background-color: green;");
					}
					if (i-2 >= 0 && map[0][i-2].getNode(j).getCharacter() == null){
						board[i-2][j].setOnAction(this::processButtonPress);
						board[i-2][j].setStyle("-fx-border-color: black;-fx-background-color: green;");
					}
					board[i][j].setOnAction(this::processButtonPress);
					board[i-1][j].setStyle("-fx-border-color: black;-fx-background-color: green;");
				}
			}
		}
	}
	
	//Method that sets all the button's actions back to processButtonPress
	public void resetButtonAction(){
		for(int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				board[i][j].setOnAction(this::processButtonPress);
				if (map[0][i].getNode(j).getCharacter() != null){
					if (map[0][i].getNode(j).getCharacter().getTeam().equals("B"))
						board[i][j].setStyle("-fx-border-color: lightblue; -fx-background-color: green;");
					else
						board[i][j].setStyle("-fx-border-color: red; -fx-background-color: green;");
				}
				else
					board[i][j].setStyle("-fx-border-color: black; -fx-background-color: green;");
			}
		}
	}
	
	public static void main(String[] args){
		Application.launch(args);
	}
}
