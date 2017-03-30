
public class EmpNode extends Node{
	private EmptySpace data;
	public EmpNode(Node n) {
		super(n);
		EmptySpace e = new EmptySpace();
		data = e;
	}
	public EmptySpace getData() {
		return data;
	}
	public void setData(EmptySpace d) {
	
		data = d;
	}
	public String toString() {
	
		return data + "-->";
	}

}
