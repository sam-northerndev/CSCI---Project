
public class ObstNode extends Node{
	private Obstacle data;
	public ObstNode(ObstNode n) {
		super(n);
		Obstacle o = new Obstacle();
		data = o;
	}
	public Obstacle getData() {
	
		return data;
	}
	public void setData(Obstacle d) {
	
		data = d;
	}
	public String toString() {
	
		return data + "-->";
	}

}
