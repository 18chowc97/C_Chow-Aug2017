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
		System.out.println(Calculate.toDegrees(3.141592653589));
		System.out.println(Calculate.toRadians(180));
		System.out.println(Calculate.discriminant(1, -4, 4));
		System.out.println(Calculate.toImproperFrac(-3, 1, 2));
		System.out.println(Calculate.toMixedNum(-7, -3));
		System.out.println(Calculate.foil(1,81,14,-2,"x"));
		System.out.println(Calculate.max(100, 101));
		System.out.println(Calculate.max(101, 102, 103));
		System.out.println(Calculate.min(100, -101));
		System.out.println(Calculate.round2(-100.986));
	}

}
