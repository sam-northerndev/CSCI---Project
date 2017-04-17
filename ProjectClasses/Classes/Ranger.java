import java.io.File;
import javafx.scene.image.Image;
/* This class extends the Character class to the Ranger class
 * The Ranger has high strength, mid hp and magic, but low defense and resistance
 * Can also attack from a further distance than any class
 * Started March 25, 2017
 */
public class Ranger extends Character {

	public Ranger(String name,String team){
		super (name, team, 20,3,1,3,2);
		setType(0);
		if(team.equals("B")){
			setImage(new Image(new File("bluerogue.png").toURI().toString()));
		}
		else
			setImage(new Image(new File("redrogue.png").toURI().toString()));
	}
	public String toString(){
		return "Ranger";
	}
  
}