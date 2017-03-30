
public class ObjNode {
	private Objective data;
	private ObjNode next;
	public ObjNode(ObjNode n) {
		Objective o = new Objective();
		data = o;
		next = n;
	}
	public Objective getData() {
	
		return data;
	}
	public ObjNode getNext() {
	
		return next;
	}
	public void setData(Objective o) {
	
		data = o;
	}
	public void setNext(ObjNode n) {
	
		next = n;
	}
	public String toString() {
	
		return data + "-->";
	}
}


