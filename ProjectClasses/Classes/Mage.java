/* This class extends the Character class to the Mage class
 * The mage has high magic and resistance, low hp, strength and defense
 * A mage is also able to attack from a further distance than the warrior and a tank
 * Started March 25, 2017
 */
public class Mage extends Character {
	public Mage(String name,String team){
		super (name,team,15,1,1,4,5,2);
		setType(2);
	}

}