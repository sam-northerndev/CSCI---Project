/* This Class contains the information for the GUI of the game & the main method to launch it
 * April 1, 2017
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
public class Game extends Application{
	@Override	public void start(Stage stage){
		GridPane pane = new GridPane();
		Button[][] board = new Button[8][8];
		pane.setHgap(0);
		pane.setVgap(0);
		pane.setStyle("-fx-background-color:blue");
		for (int i = 0; i<8; i++){
			for (int j = 0; j<8; j++){
				board[i][j] = new Button();
				board[i][j].setText("K");
				board[i][j].setStyle("-fx-border-color: black; -fx-background-color: white;"
						+ "-fx-text-fill:white;-fx-font-size:30");
				pane.add(board[i][j],i,j+1);
			}
		}
		pane.setPadding(new Insets(10,10,10,10));
		Scene scene = new Scene(pane);
		stage.setTitle("Game Board");
		stage.setScene(scene);
		stage.setResizable(true);
		stage.show();
	}
}
