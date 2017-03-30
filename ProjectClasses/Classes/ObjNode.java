
public class ObjNode extends Node{
	private Objective data;
	public ObjNode(ObjNode n) {
		super(n);
		Objective o = new Objective();
		data = o;
	}
	public Objective getData() {
	
		return data;
	}

	public void setData(Objective o) {
	
		data = o;
	}
	public String toString() {
	
		return data + "-->";
	}
}


