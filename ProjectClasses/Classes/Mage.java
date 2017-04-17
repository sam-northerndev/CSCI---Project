/* This class extends the Character class to the Mage class
 * The mage has high magic and resistance, low hp, strength and defense
 * A mage is also able to attack from a further distance than the warrior and a tank
 * Started March 25, 2017
 */
import javafx.scene.image.*;
import java.io.*;
public class Mage extends Character {
	public Mage(String name,String team){
		super (name,team,20,0,4,3,1);
		setType(2);
		if(team.equals("B")){
			setImage(new Image(new File("bluemage.png").toURI().toString()));
		}
		else
			setImage(new Image(new File("redmage.png").toURI().toString()));
	}
	public String toString(){
		return "Mage";
	}

}