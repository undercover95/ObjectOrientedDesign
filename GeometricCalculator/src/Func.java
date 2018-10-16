
public class Func extends GeometricObject {

	private FunctionObject fun;
	private Double start;
	private Double end;
	
	public Func(FunctionObject f, Double start, Double end) {
		super("Function");
		
		this.fun = f;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public Double calculate() {
		// calculates area under plot - integral
		Double step = 0.001;
		
		Double area = 0.0;
		for(Double x = this.start; x < this.end; x += step) {
			area += this.fun.getValue(x)*step;
		}
		
		return area;
	}

}
