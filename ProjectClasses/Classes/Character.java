/* This Class Contains the attributes and the methods of a Character class
 * Started March 25, 2017
 */
public class Character {
	private int level;
	//hp is the hit points (Health) of the character)
	private int hp;
	//Strength is the physical damage done to a character
	private int strength;
	//Magic is the magic damage done to a character
	private int magic;
	//resistance is the magic defense
	private int resistance;
	//physical defense
	private int defense;
	//XP that increases when the character attacks/kills an enemy
	private int XP;
	//This boolean might not be necessary
	private boolean alive;
	
	//no-args Constructor that sets alive as true
	public Character(int hp, int str, int mag, int res, int def){
		this.hp = hp;
		strength = str;
		magic = mag;
		resistance = res;
		defense = def;
		level = 1;
		alive = true;
	}
	
	//Method that calculates the damage done to an enemy unit
	//Takes into account the strength of the character
	public int Attack(){
		//The damage done by the character can be calculated in a different way
		return strength*2;
	}
	
	//Method that calculates the damage taken from an attack
	//Removes the HP taken from another characters damage
	//also checks if the character is dead (i.e if hp is less than or equal to 0)
	public void Defend(int damage){
		hp = hp - (damage/defense);
		if (hp <= 0){
			alive = false;
		}
	}
	
	
	//Method that checks if the character is alive.
	//If not, sets the alive attribute to false
	public boolean isAlive(){
		return alive;
	}
}
