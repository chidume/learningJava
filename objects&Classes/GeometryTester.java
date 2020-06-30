import java.util.Scanner;

public class GeometryTester{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.print("radius: ");
	double radius = in.nextDouble();
	System.out.print("height: ");
	double height = in.nextDouble();

	System.out.println();

	System.out.println("Sphere volume: " + Geometry.sphereVolume(radius));
	System.out.println("Sphere surface area: " + Geometry.sphereSurface(radius));
	System.out.println("Cylinder volume: " + Geometry.cylinderVolume(radius, height));
	System.out.println("Cylinder surface area: " + Geometry.cylinderSurface(radius, height));
	System.out.println("Cone volume: " + Geometry.coneVolume(radius, height));
	System.out.println("Cone surface area:" + Geometry.coneSurface(radius, height));
    }
}