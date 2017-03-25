
public class Objective {
	public int hp;
	
	public Objective() {
		hp = 1000;
		
	}
	public boolean Destroyed() {
		if (hp < 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void Attacked(Character c) {
		if (c.attack) {
			hp -= c.getattack;
		}
	}
	
}
