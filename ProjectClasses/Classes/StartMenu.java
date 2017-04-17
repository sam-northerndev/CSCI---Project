import java.io.*;

import com.sun.prism.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;


public class StartMenu extends Application {
	private Button endButton;
	private Button startButton;
	private Text team1;
	private Text team2;
	
	//Hbox's
	private HBox charButtons;
	private HBox nameField;
	private HBox loadField;
	
	//textFields
	private TextField nameInput;
	private TextField loadInput;
	private String currentName;
	private String currentFile;
	
	//character buttons
	private Button warriorButton;
	private Button rangerButton;
	private Button mageButton;
	private Button tankButton;
	private Button loadButton;
	
	//character Arrays
	private Character[] newTeam1 = new Character[3];
	private Character[] newTeam2 = new Character[3];
	private static int team1Count = 0;
	private static int team2Count = 0;
	
	
	@Override public void start(Stage stage) {
		//Making with padding of 30
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(30,30,30,30));
		
		//Font for each title
		Font gameFont = Font.font("Algerian", FontWeight.BOLD, 50);//for menuTitle
		Font playerFont = Font.font("Algerian", FontWeight.BOLD, 20);//for playerTitle

		
		//menu items
		startButton = new Button("Start The Game");
		int buttonSize = 50;
		startButton.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.45 * buttonSize)));
		endButton = new Button("Quit The Game");
		endButton.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.45 * buttonSize)));

		//startButton.setPadding(new Insets(30,30,30,30));
		
		//text
		Text menuTitle = new Text("Welcome to Hero Battles");
		menuTitle.setFont(gameFont);
		team1 = new Text("Player one, choose your Heros:");
	    team2 = new Text("Player two, choose your Heros:");
		
		//setting team selection visibilty to false
		team2.setVisible(false);
		team1.setVisible(false);
		
		team1.setFont(playerFont);
		team2.setFont(playerFont);
        
		
		//centering title
		pane.add(menuTitle, 0, 0);
		
		GridPane.setColumnSpan(menuTitle, 4);
		GridPane.setHalignment(menuTitle, HPos.CENTER);
		pane.setMargin(menuTitle, new Insets(20,20,20,20));
		
		
		//centering start and end 
		HBox startEnd = new HBox();
		startEnd.getChildren().addAll(startButton, endButton);
	
		pane.add(startEnd, 0, 1);
		GridPane.setColumnSpan(startEnd, 4);
		GridPane.setHalignment(startEnd, HPos.CENTER);
		startEnd.setSpacing(20);
		startEnd.setAlignment(Pos.CENTER);
		pane.setMargin(startEnd, new Insets(20,20,20,20));
		
		//team hero choosing
		pane.add(team1, 0, 2);
		pane.add(team2, 0, 2);
		GridPane.setHalignment(team1, HPos.CENTER);
		GridPane.setHalignment(team2, HPos.CENTER);
		GridPane.setColumnSpan(team1, 4);
		GridPane.setColumnSpan(team2, 4);
		pane.setMargin(team1, new Insets(20,20,20,20));
		pane.setMargin(team2, new Insets(20,20,20,20));

		

		
		
		//character selection items
		loadButton = new Button("Load");
		warriorButton = new Button("Warrior");
		rangerButton = new Button("Ranger");
		tankButton = new Button("Tank");
		mageButton = new Button("Mage");
		charButtons = new HBox();
		
		//setting character selection button visibility to false
		charButtons.setVisible(false);
		
		//formatting buttons
		loadButton.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.45 * 30)));
		warriorButton.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.45 * 30)));
		rangerButton.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.45 * 30)));
		tankButton.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.45 * 30)));
		mageButton.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.45 * 30)));

		
		charButtons.getChildren().addAll(loadButton, warriorButton, rangerButton, tankButton, mageButton);
		pane.add(charButtons, 0, 3);
		
		GridPane.setColumnSpan(charButtons, 4);
		GridPane.setHalignment(charButtons, HPos.CENTER);
		pane.setMargin(charButtons, new Insets(20,20,20,20));
		charButtons.setSpacing(20);
		charButtons.setAlignment(Pos.CENTER);
		

		//user Load text file of character into the game -----------------------
		Label loadLabel = new Label("Load File Name:");
		
		//styling character naming/loading.
		loadLabel.setTextFill(Paint.valueOf("#ffffff"));
		loadLabel.setFont(playerFont);
		
		loadInput = new TextField();
		loadField = new HBox();
		loadField.setPadding(new Insets(20, 20, 20, 20));
		loadField.getChildren().addAll(loadLabel, loadInput);
		pane.add(loadField, 0, 5);

		//name text field start here------------------------
		Label nameLabel = new Label("Name:");
		
		//styling character naming/loading.
		nameLabel.setTextFill(Paint.valueOf("#ffffff"));
		nameLabel.setFont(playerFont);
		
		nameInput = new TextField();
		nameField = new HBox();
		nameField.setPadding(new Insets(20, 20, 20, 20));
		nameField.getChildren().addAll(nameLabel, nameInput);
		pane.add(nameField, 0, 5);
								//----------------------
		
		//setting name text field visibilty to false and load field
		nameField.setVisible(false);
		loadField.setVisible(false);
	
		//centering both text fields
		GridPane.setColumnSpan(nameField, 4);
		nameField.setAlignment(Pos.CENTER);
		GridPane.setColumnSpan(loadField, 4);
		loadField.setAlignment(Pos.CENTER);
		
		//creating image for the background
		Image image = new Image(new File("GameBackground.jpg").toURI().toString());
		BackgroundSize backgroundSize = new BackgroundSize(675,750, true,true,true,true);
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		Background background = new Background(backgroundImage);
		
		pane.setBackground(background);
		
		//Adding music
		String musicString = new File("main.mp3").toURI().toString();
		MediaPlayer musicPlayer = new MediaPlayer(new Media(musicString));
		musicPlayer.play();
		
		//set up the stage
		Scene scene = new Scene(pane, 750, 675);
		stage.setScene(scene);
		stage.setTitle("Game");
		stage.show();
		
		
		
		
		
		///////////////////////////////////////////////// Button presses
		//Quit button
		endButton.setOnAction(this::processButtonPress);
		startButton.setOnAction(this::processButtonPress);
		warriorButton.setOnAction(this::processButtonPress);
		rangerButton.setOnAction(this::processButtonPress);
		mageButton.setOnAction(this::processButtonPress);
		tankButton.setOnAction(this::processButtonPress);
		nameInput.setOnAction(this::processReturn);
		loadButton.setOnAction(this::processButtonPress);
		loadInput.setOnAction(event -> {
			try {
				processReturn1(event);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		

		
		
		
		
		
	}
		//////////////////////////////////// Button actions
		public void processButtonPress(ActionEvent event) {
			if (event.getSource() == endButton) { //End the game
				System.exit(0);
			}
			else if (event.getSource() == startButton) { 
				startButton.setVisible(false);//set start and quit buttons visible:false
				endButton.setVisible(false);
				team1.setVisible(true);
				charButtons.setVisible(true);

			}
			else if (event.getSource() == loadButton){
				nameField.setVisible(false);
				if (team1Count == 0) {
					loadField.setVisible(true);
				}
				else if (team2Count == 0) {
					loadField.setVisible(true);
				}
			}
			else if (event.getSource() == warriorButton) {
				loadField.setVisible(false);
				if (team1Count < 3) {
					nameField.setVisible(true);
					Warrior w = new Warrior (currentName, "B");
					newTeam1[team1Count] = w;
				}
				else if (team2Count < 3) {
					nameField.setVisible(true);
					Warrior w = new Warrior (currentName, "R");
					newTeam2[team2Count] = w;
				}
				warriorButton.setOnAction(this::processButtonPress);
			}
			else if (event.getSource() == mageButton) {
				loadField.setVisible(false);
				if (team1Count < 3) {
					nameField.setVisible(true);
					Mage m = new Mage (currentName, "B");
					newTeam1[team1Count] = m;
				}
				else if (team2Count < 3) {
					nameField.setVisible(true);
					Mage m = new Mage (currentName, "R");
					newTeam2[team2Count] = m;
				}
				mageButton.setOnAction(this::processButtonPress);
			}
			else if (event.getSource() == rangerButton) {
				loadField.setVisible(false);
				if (team1Count < 3) {
					nameField.setVisible(true);
					Ranger r = new Ranger (currentName, "B");
					newTeam1[team1Count] = r;
				}
				else if (team2Count < 3) {
					nameField.setVisible(true);
					Ranger r = new Ranger (currentName, "R");
					newTeam2[team2Count] = r;
				}
				rangerButton.setOnAction(this::processButtonPress);
			}
			else if (event.getSource() == tankButton) {
				loadField.setVisible(false);
				if (team1Count < 3) {
					nameField.setVisible(true);
					Tank t = new Tank (currentName, "B");
					newTeam1[team1Count] = t;
				}
				else if (team2Count < 3) {
					nameField.setVisible(true);
					Tank t = new Tank (currentName, "R");
					newTeam2[team2Count] = t;
				}
				tankButton.setOnAction(this::processButtonPress);
			}


		}
		public void processReturn(ActionEvent event) {
			if(event.getSource() == nameInput) {
					currentName = nameInput.getText();
					if (team1Count < 3) {
						newTeam1[team1Count].setName(currentName);
						team1Count++;
					}
					else if (team2Count < 3){
						newTeam2[team2Count].setName(currentName);
						team2Count++;
					}
			}
			if (team1Count == 3) {
				team1.setVisible(false);
				team2.setVisible(true);
				
			}
			nameInput.clear();
			nameInput.setOnAction(this::processReturn);
			nameField.setVisible(false);
		}
		public void processReturn1(ActionEvent event) throws IOException {
			if (event.getSource() == loadInput) {
				currentFile = loadInput.getText();
				GameFile load;
				if(team1Count == 0) {
					load = new GameFile(currentFile);
					for(int i =1; i < 4; i++) {
						String name = load.getCharName(i);
						int type = load.getCharType(name);
						newTeam1[i-1] = generateCharacter(name,type,"B");
						team1Count++;
						System.out.print(newTeam1[i-1].getName() + newTeam1[i-1].getType() );
					}
				}
				else if(team2Count == 0) {
					load = new GameFile(currentFile);
					for(int i = 1; i < 4; i++) {
						String name = load.getCharName(i);
						int type = load.getCharType(name);
						newTeam2[i - 1] = generateCharacter(name,type,"R");
						team2Count++;
						System.out.print(newTeam2[i-1].getName() + newTeam2[i-1].getType() );
					}
				}
			}
			loadInput.clear();
			loadField.setVisible(false);

			team1.setVisible(false);
			team2.setVisible(true);
		}
		
		public static Character generateCharacter(String name, int type, String team) {
			Character c = null;
			if (type == 1) {
				Warrior w = new Warrior (name, team);
				return w;
			}
			if (type == 2) {
				Mage m = new Mage (name, team);
				return m;
			}
			if (type == 3) {
				Tank t = new Tank (name, team);
				return t;
			}
			if (type == 0) {
				Ranger r = new Ranger (name, team);
				return r;
			}
			return c;
			
			
		}

		
		
	
	public static void main(String[] args){
		launch(args);
	}
}
