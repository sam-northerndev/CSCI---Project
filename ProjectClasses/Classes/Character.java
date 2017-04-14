/* This Class Contains the attributes and the methods of a Character class
 * Started March 25, 2017
 */
public class Character {
   //type of character
   private int type;
   //Team this character belongs to (Either R(red) or B(blue))
   private String team;
   //Name of the character
   private String name;
	//hp is the hit points (Health) of the character)
	private int hp;
	//Strength is the physical damage done to a character
	private int strength;
   //Dexterity
   private int dexterity;
	//Magic is the magic damage done to a character
	private int magic;
	//resistance is the magic defense
	private int resistance;
	//physical defense
	private int defense;
	//XP that increases when the character attacks/kills an enemy
	private boolean alive;
	
	//Constructor that sets alive as true
	public Character(int hp, int str, int dex, int mag, int res, int def){
		this.hp = hp;
		strength = str;
		magic = mag;
		resistance = res;
		defense = def;
		alive = true;
	}
	
	public Character(String n, String t){
		name = n;
		team = t;
		type = 1;
	}
	
	//Method that calculates the damage done to an enemy unit
	//Takes into account the strength of the character
	public double attack(){
		//The damage done by the character can be calculated in a different way
      //ranger
      if(type == 0)
		   return dexterity*1.2;
      //warrior
      else if (type == 1)
         return strength*2;
      //mage
      else if (type == 2)
         return magic*2;
      //tank
      else
         return strength*1.7;
	}
   
   //sets type of character
   public void setType(int t)
   {
      type = t;
   }
   
   public int getType()
   {
      return type;
   }
	
	//Method that calculates the damage taken from an attack
	//Removes the HP taken from another characters damage
	//also checks if the character is dead (i.e if hp is less than or equal to 0)
	public void defend(Character r){
      //checks if attacking character is a mage or not
      if(r.getType() == 2)
         hp = (int)(hp - (r.attack()/resistance));
      else 
		   hp = (int)(hp - (r.attack()/defense));
		if (hp <= 0){
			alive = false;
		}
	}
	
	
	//Method that checks if the character is alive.
	//If not, sets the alive attribute to false
	public boolean isAlive(){
		return alive;
	}
	
	//Get name
	public String getName(){
		return name;
	}
	
	//Get team name 
	public String getTeam(){
		return team;
	}
   
   public int getHp(){
      return hp;
   }
	
}