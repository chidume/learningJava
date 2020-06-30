/** computes the volume and surface area of a sphere with a radius r,
a cylinder with a circular base with radius r and height h, 
and a cone with a circular base with radius r and height h
*/

public class Geometry{
    public static double sphereVolume(double r){
	return (4 * Math.PI * r * r * r) / 3.0;
    }

    public static double sphereSurface(double r){
	return 4 * Math.PI * r * r;
    }

    public static double cylinderVolume(double r, double h){
	return Math.PI * r * r * h;
    }

    public static double cylinderSurface(double r, double h){
	return 2 * Math.PI * r * r + 2 * Math.PI * r * h;
    }

    public static double coneVolume(double r, double h){
	return (Math.PI * r * r * h) / 3.0;
    }

    public static double coneSurface(double r, double h){
	return Math.PI * r * (r + Math.sqrt(h * h + r * r));
    }

}