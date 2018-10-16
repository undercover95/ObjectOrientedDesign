import java.util.ArrayList;
import java.util.List;

public class GeometricCalculator {
	
	public ArrayList<Point> getPoints() {
		Point p1 = new Point(1.0, 1.0);
		Point p2 = new Point(6.0, 1.0);
		Point p3 = new Point(6.0, 8.0);
		Point p4 = new Point(1.0, 8.0);
		
		ArrayList<Point> points = new ArrayList<>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		
		return points;
	}
	
	public static void main(String[] args) {
		
		GeometricCalculator gc = new GeometricCalculator();
		List<Point> points = gc.getPoints();
		List<GeometricObject> objects = new ArrayList<GeometricObject>();
		
		try {
			GeometricObject triangle = new Triangle(points.subList(0, 3));
			GeometricObject rectangle = new Rectangle(points);
			GeometricObject circle = new Circle(2.0);
			GeometricObject line = new Line(points.get(0), points.get(1));
			GeometricObject exp = new Func(new ExpFunc(), points.get(0).getX(), points.get(1).getX());
			GeometricObject sin = new Func(new SinFunc(), points.get(0).getX(), points.get(1).getX());
			
			objects.add(triangle);
			objects.add(rectangle);
			objects.add(circle);
			objects.add(line);
			objects.add(exp);
			objects.add(sin);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(GeometricObject ob : objects) {
			System.out.println("Hello, I am a: "+ob.getName()+"!");
			System.out.println("I calculated my area: "+ob.calculate());
			System.out.println();
		}
		
	}
}
