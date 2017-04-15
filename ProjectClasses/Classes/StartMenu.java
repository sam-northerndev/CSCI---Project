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


public class StartMenu extends Application {
	@Override public void start(Stage stage) {
		//Making with padding of 30
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(30,30,30,30));
		
		//Font for each title
		Font gameFont = Font.font("Algerian", FontWeight.BOLD, 50);//for menuTitle
		Font playerFont = Font.font("Algerian", FontWeight.BOLD, 20);//for playerTitle

		
		//menu items
		Button startButton = new Button("Start The Game");
		int buttonSize = 50;
		startButton.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.45 * buttonSize)));
		Button endButton = new Button("Quit The Game");
		endButton.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.45 * buttonSize)));

		//startButton.setPadding(new Insets(30,30,30,30));
		
		//text
		Text menuTitle = new Text("Welcome to Hero Battles");
		menuTitle.setFont(gameFont);
		Text team1 = new Text("Player one, choose your Heros:");
		Text team2 = new Text("Player two, choose your Heros:");
		team2.setVisible(false);
		
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
		Button loadButton = new Button("Load");
		Button warriorButton = new Button("Warrior");
		Button rangerButton = new Button("Ranger");
		Button tankButton = new Button("Tank");
		Button mageButton = new Button("Mage");
		HBox charButtons = new HBox();
		
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
		

		//user Enters name
		Label nameLabel = new Label("Name:");
		TextField nameInput = new TextField();
		HBox nameField = new HBox();
		nameField.setPadding(new Insets(20, 20, 20, 20));
		nameField.getChildren().addAll(nameLabel, nameInput);
		pane.add(nameField, 0, 5);
		
		GridPane.setColumnSpan(nameField, 4);
		nameField.setAlignment(Pos.CENTER);
		
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
		
		
	}
	
	public static void main(String[] args){
		launch(args);
	}
	

}
