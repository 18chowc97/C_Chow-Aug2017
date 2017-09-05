/* Carl Chow
 * September 5, 2017
 * This is the runner class for my Calculate Library methods.
 */
public class DoMath {

	public static void main(String[] args) {
		System.out.println(Calculate.square(5));
		System.out.println(Calculate.cube(5));
		System.out.println(Calculate.average(10, 20));
		System.out.println(Calculate.average(10, 20, 30));
		System.out.println(Calculate.toDegrees(3.141592));
		System.out.println(Calculate.toRadians(180));
		System.out.println(Calculate.discriminant(1, 2, 1));
		System.out.println(Calculate.toImproperFrac(3, 1, 2));
	}

}
