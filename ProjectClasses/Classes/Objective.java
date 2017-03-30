public class Objective {
	private int hp;
	
	public Objective() {
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

<<<<<<< HEAD
		hp -= c.Attack();
=======
		hp -= c.attack();
>>>>>>> origin/master

	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	
}