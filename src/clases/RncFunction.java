package clases;

public class RncFunction {

	private int id;

	public RncFunction() {

	}

	public RncFunction(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RncFunction [id=" + id + "]";
	}

}