
public class EmptySpace {
	private String data;
	
	public EmptySpace() { // to take up space in the grid
		data = "hi";
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String toString(){
		return data;
	}

}
