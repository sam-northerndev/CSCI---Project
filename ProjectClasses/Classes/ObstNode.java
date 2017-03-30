
public class ObstNode {
	private Obstacle data;
	private ObstNode next;
	public ObstNode(ObstNode n) {
		Obstacle o = new Obstacle();
	
		data = o;
		next = n;
	}
	public Obstacle getData() {
	
		return data;
	}
	public ObstNode getNext() {
	
		return next;
	}
	public void setData(Obstacle d) {
	
		data = d;
	}
	public void setNext(ObstNode n) {
	
		next = n;
	}
	public String toString() {
	
		return data + "-->";
	}

}
