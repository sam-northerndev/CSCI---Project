/*Written March 25th, 2017
 the Grid map will be made up of blank space will include methods to:
**** generate obstacles, generate objective, add three character objects, move a character ****
 */
import java.util.LinkedList;
import java.util.Random;

import javax.xml.soap.Node;

public class GridMap {
  
	private LinkedList[][] grid = new LinkedList<Space>[1][8];
	
	public GridMap() {
		for(int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++){
				EmptySpace tempData = new EmptySpace();
				EmpNode temp = new EmpNode(tempData, grid[0][i].getFirst()); //*need linked list get front..
				grid[0][i].add(temp);
			}
		}
	}
		
	}
	public void generateObstacles() { //method to populate the board with obstacles
		Random rnd = new Random();
		int target = rnd.nextInt(10);
		int guess;	// call linkedlist at [i], if a randomly generated number satisfies requirement place object.
		for (int i = 0; i < grid.length; i++ ) {
			Node temp = grid[0][i].getFirst();//*need linked list first method
			int count = 0; //keep track of where to place the new obstacle
			while (temp != null) {
				guess = rnd.nextInt(10);
				if (guess == target && temp.getClass() == EmpNode.class) { //the node is an empty space
					Obstacles obst = new Obstacle();
					grid[0][i].addAt(obst,count); //*setting the node to replace the node at current index
				}
				temp = temp.getNext(); //* get next
				count++;
			}
				
		}	
	}
	public void  generateObjective() {
		
	}
	
	public void  displayMap() {
		
	}
	
	public void moveChar()
	
	

}
