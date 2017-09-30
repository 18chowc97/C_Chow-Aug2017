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
		System.out.println(Calculate.toDegrees(-3.141592653589));
		System.out.println(Calculate.toRadians(180));
		System.out.println(Calculate.discriminant(1, 0, 0));
		System.out.println(Calculate.toImproperFrac(0, 1, 2));
		System.out.println(Calculate.toMixedNum(-2, -3));
		System.out.println(Calculate.foil(1,0,14,-0,"x"));
		System.out.println(Calculate.isDivisibleBy(3, -123));
		System.out.println(Calculate.max(-100, -101));
		System.out.println(Calculate.max(101, 102, 104));
		System.out.println(Calculate.min(100, -121));
		System.out.println(Calculate.round2(-10.8955));
		System.out.println(Calculate.exponent(-2, 5));
		System.out.println(Calculate.factorial(5));
		System.out.println(Calculate.isPrime(1));
		System.out.println(Calculate.gcf(110, 550));
		System.out.println(Calculate.sqrt(1));
		System.out.println(Calculate.quadForm(1, 0,-1));
	}
}
