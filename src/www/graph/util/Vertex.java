package www.graph.util;

public class Vertex {

	private int data;
	private String name;
	private boolean isVisited=false;
	
	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public Vertex(int data, String name){
		this.data = data;
		this.name = name;
	}

	public int getData() {
		return data;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public int hashCode(){
		return data;
	}
	
	public boolean equals(Object obj){
		
		if(obj instanceof Vertex 
				&& ((Vertex) obj).getData() == this.getData() 
				&& ((Vertex)obj).getName().equals(this.getName())){
			return true;
		}
		return false;
	}
}
