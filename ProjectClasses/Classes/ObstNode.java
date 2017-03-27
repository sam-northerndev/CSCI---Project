
public class ObstNode {
	private Obstacle data;
	private ObstNode next;
	public ObstNode(Obstacle d, ObstNode n) {
	
		data = d;
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
