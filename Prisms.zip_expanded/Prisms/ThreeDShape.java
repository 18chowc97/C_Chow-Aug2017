public abstract class ThreeDShape {
	//private double volume;
	//private double surfaceArea;

	public ThreeDShape() {
		//this.volume = calcVolume();
		//this.surfaceArea = calcSA();
	}

	// Can you write this code for this class or does it need to be overridden by
	// every subclass?
	public abstract double calcVolume();

	// Can you write this code for this class or does it need to be overridden by
	// every subclass?
	public abstract double calcSA();
}