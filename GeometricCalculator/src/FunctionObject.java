interface FunctionObject {
	public Double getValue(Double x);
}

class ExpFunc implements FunctionObject {

	@Override
	public Double getValue(Double x) {
		return Math.exp(x);
	}
	
}

class SinFunc implements FunctionObject {

	@Override
	public Double getValue(Double x) {
		return Math.sin(x);
	}
	
}