
public class Obstacle {
	
	private String name;
	
	public Obstacle() {
		int num = (int)(Math.random() * 4 + 1); // generates a random number
		if (num == 1) {							// determines which obstacle 
			name = "Tree";
		}
		else if (num == 2) { 
			name = "Rock";
		}
		else if (num == 3) {
			name = "Water";
		}
		else if (num == 4) {
			name = "Hole";
		}
 	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}
	
	
	

}
