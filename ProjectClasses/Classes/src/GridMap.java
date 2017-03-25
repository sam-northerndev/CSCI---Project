import java.util.LinkedList;
import java.util.Random;

public class GridMap {
  
	private LinkedList<E>[][] grid = new LinkedList[1][32];
	
	public GridMap() {
		
	}
	public void generateObstacles() { //method to populate the board with obstacles
		Random rnd = new Random();
		int target = rnd.nextInt(10);
		int guess;	// call linkedlist at [i], if a randomly generated number satisfies requirement place object.
		for (int i = 0; i < grid.length; i++ ) { 
			while (grid[1][i] != null) {
				guess = rnd.nextInt(10);
				if (guess == target) {
					Obstacles obst = new Obstacle();
					grid[1][i].addToEnd(obst); //setting the data at [1][i] to append to the end.
				}				 
		}
			
		
	}
	public void  generateObjective() {
		
	}
	
	public void  displayMap() {
		
	}
	
	public void moveChar()
	
	

}
