/* Write this concrete (non-abstract) class called RectangularPrism.  
 * It has 2 private fields (length and width).
 * It inherits its height from its superclass, Prism (because all prisms have a height).
 * Provide a constructor and the methods required by its abstract superclass.  
 */

public class RectangularPrism extends Prism{
	private double length;
	private double width;
	public RectangularPrism(double w, double l, double h) {
		super(h);
		length = l;
		width = w;
	}
	public double calcAreaOfBase() {
		return length * width;
	}
	public double calcPerimeter() {
		return 2 * (length + width);
	}
}

