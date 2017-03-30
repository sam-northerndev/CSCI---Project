
public class Objective {
	private String team;
	private int hp;
	
	public Objective(String color) {
		team = color;
		hp = 1000;
		
	}
	public boolean destroyed() { // if the objective is destroyed
		if (hp < 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void attacked(Character c) { // loses hp if objective is attacked

		hp -= c.attack();

	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String toString() {
		return team;
	}
	
}
