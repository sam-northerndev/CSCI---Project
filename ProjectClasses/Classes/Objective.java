
public class Objective {
	private int hp;
	
	public Objective() {
		hp = 1000;
		
	}
	public boolean Destroyed() { // if the objective is destroyed
		if (hp < 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void Attacked(Character c) { // loses hp if objective is attacked
		if (c.attack) {
			hp -= c.getattack;
		}
	}
	
}
