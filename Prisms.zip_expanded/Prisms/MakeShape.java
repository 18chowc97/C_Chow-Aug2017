
public class MakeShape {

	public static void main(String[] args) 
	{
		ThreeDShape p1 = new RectangularPrism(5, 6, 10);     // V = 300, SA = 280
		Prism p2 = new RectangularPrism(5, 3, 10);     // V = 150, SA = 190

		ThreeDShape p3 = new TriangularPrism(6, 8, 10, 20);  // V = 480, SA = 528
		Prism p4 = new TriangularPrism(8, 8, 8*Math.sqrt(2), 10);  // V = 320, SA = 337.1
		
		ThreeDShape p5 = new Cylinder(5, 10);                // V = 785.4, SA = 471.2
		Prism p6 = new Cylinder(10, 20);               // V = 6283.2,  SA = 1885.0
		
		ThreeDShape p7 = new Sphere(1);
		Sphere p8 = new Sphere(2);
		
		
		ThreeDShape[] prisms = {p1, p2, p3, p4, p5, p6, p7, p8};
		
		for (int i=0; i<prisms.length; i++)
		{
			System.out.println("The volume of p" + (i+1) +": " + prisms[i].calcVolume());
			System.out.println("The surface area of p" + (i+1) +": " + prisms[i].calcSA());
			System.out.println();
		}
	}

}
