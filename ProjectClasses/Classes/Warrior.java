import java.io.File;
import javafx.scene.image.Image;

/* This class extends the Character class to a warrior class
 * The Warrior has high base attack stats, medium defense  and HP, and low magic and resistance
 * Started March 25, 2017
 */
public class Warrior extends Character {
	public Warrior(String name, String team){
		super(name,team,20,3,0,2,3);
		setType(1);
		if(team.equals("B")){
			setImage(new Image(new File("bluewarrior.png").toURI().toString()));
		}
		else
			setImage(new Image(new File("redwarrior.png").toURI().toString()));
	}
	public String toString(){
		return "Warrior";
	}

}
