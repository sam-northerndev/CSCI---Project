
import java.util.Random;
public class GridMap {
  
	private LinkedList[][] grid = new LinkedList[1][8];
	
	public GridMap() {
		for(int i = 0; i < 8; i++) {
			grid[0][i] = new LinkedList();
			for (int j = 0; j < 8; j++){
				Node temp = new Node(new EmptySpace(), grid[0][i].getFront()); //*need linked list get front..
				grid[0][i].addToFront(temp);
			}
		}
	}

	public void generateObstacles() { //method to populate the board with obstacles
		Random rnd = new Random();
		int target = rnd.nextInt(10);
		int guess;	// call linkedlist at [i], if a randomly generated number satisfies requirement place object.
		for (int i = 0; i < 8; i++ ) {
			Node temp = grid[0][i].getFront();//*need linked list first method
			int count = 0; //keep track of where to place the new obstacle
			while (temp != null) {
				guess = rnd.nextInt(10);
				if (guess == target && temp.getEmptySpace() != null && temp.getEmptySpace().getData().equals("hi")) { //the node is an empty space
					Obstacle obst = new Obstacle();
					grid[0][i].replace(count,new Node(obst,temp.getNext())); //*setting the node to replace the node at current index
				}
				temp = temp.getNext(); //* get next
				count++;
			}
				
		}	
	}
	public void  generateObjective() {
		grid[0][0].replace(0, new Node(new Objective("blue"), grid[0][0].getFront().getNext()));//place blue teams objective
		grid[0][7].replace(7, new Node(new Objective("red"), grid[0][7].getNode(7).getNext()));//place red teams objective
		
	}
	
	public void generateCharacter(Character ch1, Character ch2, Character ch3, String team) {
		if ( team.equals("blue")){
			grid[0][0].replace(1, new Node(ch1, grid[0][0].getNode(1).getNext()));
			grid[0][1].replace(1, new Node(ch2, grid[0][1].getNode(1).getNext()));
			grid[0][1].replace(0, new Node(ch3, grid[0][1].getFront().getNext()));
		}
		else if (team.equals("red")){
			grid[0][6].replace(6, new Node(ch1, grid[0][6].getNode(6).getNext()));
			grid[0][6].replace(7, new Node(ch2, grid[0][6].getNode(7).getNext()));
			grid[0][7].replace(6, new Node(ch3, grid[0][7].getNode(6).getNext()));
		}
	}
	
	public void  displayMap() {
		for(int i = 0; i < 8; i++){
			System.out.println();
			Node temp = grid[0][i].getFront();
			while (temp != null){
				if (temp.getObstacle() != null){
					System.out.print(temp.getObstacle().getName()+" - ");
				}
				else if (temp.getEmptySpace() != null){
					System.out.print(temp.getEmptySpace().getData()+" - ");
				}
				else if (temp.getObjective() != null) {
					System.out.print(temp.getObjective() + " - ");
				}
				else if(temp.getCharacter() != null) {
					System.out.print(temp.getCharacter().getName()+" - ");
				}
				temp = temp.getNext();
			}
		}
	}
	
	public void moveChar(){
	
	}
	public static void main (String[] args){
		GridMap map = new GridMap();
		map.generateCharacter(new Character("Steve"), new Character("Craig"), new Character("Sam"),"blue");
		map.generateCharacter(new Character("Man"), new Character("Woman"), new Character("Child"),"red");
		map.generateObstacles();
		map.generateObjective();
		map.displayMap();
	}
	

}
