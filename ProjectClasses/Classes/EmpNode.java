
public class EmpNode {
	private EmptySpace data;
	private EmpNode next;
	public EmpNode(EmpNode n) {
		EmptySpace e = new EmptySpace();
	
		data = e;
		next = n;
	}
	public EmptySpace getData() {
	
		return data;
	}
	public EmpNode getNext() {
	
		return next;
	}
	public void setData(EmptySpace d) {
	
		data = d;
	}
	public void setNext(EmpNode n) {
	
		next = n;
	}
	public String toString() {
	
		return data + "-->";
	}

}
