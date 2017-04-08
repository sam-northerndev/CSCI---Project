/* Node class */
public class Node{

   //attributes
   private Node next; 
   private EmptySpace empSpace;
   private Character character;
   private Obstacle obstacle;
   private Objective objective;
   
   //constructor for EmptySpace
   public Node(EmptySpace emp, Node n){
	  empSpace = emp;
      next=n; 
   }
   
   //Constructor for Character
   public Node(Character c, Node n){
	  character = c;
      next=n; 
   }
   
   //Constructor for Obstacle
   public Node(Obstacle o, Node n){
	  obstacle = o;
      next=n; 
   }
   
   //Constructor for Objective
   public Node(Objective ob, Node n){
	  objective = ob;
      next=n; 
   }
   
   //get and set methods
   public void setNext(Node n){
      next=n;
   }
   
   public Node getNext(){
      return next; 
   }
   
   //Get and set Data for EmptySpace
	public EmptySpace getEmptySpace() {
		return empSpace;
	}
	
	public void setData(EmptySpace emp){
		empSpace = emp;
		character = null;
		obstacle = null;
		objective = null;
	}
	//Get and Set Data for Character
	public Character getCharacter() {
		return character;
	}

	public void setData(Character character) {
		this.character = character;
		empSpace = null;
		obstacle = null;
		objective = null;
	}
	//Get and Set Data for Obstacles
	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setData(Obstacle obstacle) {
		this.obstacle = obstacle;
		empSpace = null;
		character = null;
		objective = null;
	}
	//Get and Set Data for Onjective
	public Objective getObjective() {
		return objective;
	}

	public void setData(Objective objective) {
		this.objective = objective;
		empSpace = null;
		character = null;
		obstacle = null;
	}
}                     