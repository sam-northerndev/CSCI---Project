
public class CharNode extends Node {
	private Character data;
	
	//Constructor w/ Super
	public CharNode(Character d, CharNode n) {
		super(n);
		data = d;
	}
	public Character getData() {
	
		return data;
	}
	public void setData(Character d) {
	
		data = d;
	}
	public String toString() {
	
		return data + "-->";
	}
	

}
