import java.util.List;

abstract class Shape extends GeometricObject {

	public Shape(String name) {
		super(name);
	}

}


abstract class Polygon extends Shape {
	private  List<Point> points;
	
	public Polygon(String name, List<Point> points) {
		super(name);
		this.points = points;
	}

	public List<Point> getPolygonPoints() {
		return this.points;
	}
}


class Circle extends Shape {
	private Double radius;
	
	public Circle(Double radius) {
		super("Circle");
		this.radius = radius;
	}
	
	@Override
	public Double calculate() {
		return Math.PI*Math.pow(this.radius, 2.0);
	}
}

class Triangle extends Polygon {
	
	public Triangle(List<Point> trianglePoints) throws Exception {
		super("Triangle", trianglePoints);
		
		if (trianglePoints.size() != 3) {
			throw new Exception("Error - you can specify only 3 points for Triangle!");
		} else if (!checkIfCanExists(trianglePoints)) {
			throw new Exception("Triangle cannot be created from those points!");
		}
	}
	
	public Boolean checkIfCanExists(List<Point> trianglePoints) {
		List<Point> points = this.getPolygonPoints();
		Point p1 = points.get(0);
		Point p2 = points.get(1);
		Point p3 = points.get(2);
		
		Double a = Utils.getDistanceBetweenPoints(p1, p2);
		Double b = Utils.getDistanceBetweenPoints(p2, p3);
		Double c = Utils.getDistanceBetweenPoints(p3, p1);
		
		return (a+b>c && a+c>b && b+c>a);
	}

	@Override
	public Double calculate() {
		List<Point> points = this.getPolygonPoints();
		Point p1 = points.get(0);
		Point p2 = points.get(1);
		Point p3 = points.get(2);
		return Math.abs(0.5*(p1.getX()*(p2.getY()-p3.getY())+p2.getX()*(p3.getY()-p1.getY())+p3.getX()*(p1.getY()-p2.getY())));
	}
}


class Rectangle extends Polygon {
	private  List<Point> points;
	
	public Rectangle(List<Point> rectanglePoints) throws Exception {
		super("Rectangle", rectanglePoints);
		if (rectanglePoints.size() != 4) {
			throw new Exception("Error - you can specify only 4 points for Rectangle!");
		}
		
		this.points = rectanglePoints;
	}

	@Override
	public Double calculate() {
		Point p1 = this.points.get(0);
		Point p2 = this.points.get(1);
		Point p3 = this.points.get(2);
		return Utils.getDistanceBetweenPoints(p1, p2)*Utils.getDistanceBetweenPoints(p2, p3);
	}
}