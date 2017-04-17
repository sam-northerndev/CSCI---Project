/* This Class extends the character class to the Tank class
 * The tank has high HP, mid strength and  defense, low magic and resistance
 * Started March 25, 2017
 */
import javafx.scene.image.*;
import java.io.*;
public class Tank extends Character{
	public Tank(String name, String team){
		super (name,team,30,2,0,1,4);
		setType(3);
		if(team.equals("B")){
			setImage(new Image(new File("bluetank.png").toURI().toString()));
		}
		else
			setImage(new Image(new File("redtank.png").toURI().toString()));
	}
	public String toString(){
		return "Tank";
	}

}