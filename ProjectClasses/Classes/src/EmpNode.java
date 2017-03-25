
public class EmpNode {
	private EmptySpace data;
	private EmpNode next;
	public EmpNode(EmptySpace d, EmpNode n) {
	
		data = d;
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
