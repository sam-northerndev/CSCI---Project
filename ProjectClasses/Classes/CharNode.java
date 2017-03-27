
public class CharNode {
	private Character data;
	private CharNode next;
	public CharNode(Character d, CharNode n) {
	
		data = d;
		next = n;
	}
	public Character getData() {
	
		return data;
	}
	public CharNode getNext() {
	
		return next;
	}
	public void setData(Character d) {
	
		data = d;
	}
	public void setNext(CharNode n) {
	
		next = n;
	}
	public String toString() {
	
		return data + "-->";
	}
	

}
