
class Line extends GeometricObject {
	private Point start;
	private Point end;
	
	public Line(Point start, Point end) {
		super("Line");
		this.start = start;
		this.end = end;
	}
	
	public Point getStartPoint() {
		return this.start;
	}
	
	public Point getEndPoint() {
		return this.end;
	}

	@Override
	public Double calculate() {
		return Utils.getDistanceBetweenPoints(this.start, this.end);
	}
	
}
