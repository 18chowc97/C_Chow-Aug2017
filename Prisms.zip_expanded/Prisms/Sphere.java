
public class Sphere extends ThreeDShape{
	private double radius;
	public Sphere(double r) {
		radius = r;
	}
	public double calcVolume() {
		return 4 * Math.PI / 3 * radius * radius * radius;
	}
	public double calcSA() {
		return 4 * Math.PI * radius * radius;
	}
}
