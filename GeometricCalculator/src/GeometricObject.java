
abstract class GeometricObject {
	private String name = "";

	public GeometricObject(String name) {
		this.name = name;
	}
	
	abstract public Double calculate();
	
	public String getName() {
		return this.name;
	}
}
