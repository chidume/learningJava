import java.util.Scanner;

/*
    Calculates volume of a cube
*/

public class CubeVolume{
    public static int cubeVolume(int sideLength){
	return sideLength * sideLength * sideLength;
    }

    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	boolean done = false;

	do{
	    System.out.print("Side length (Q to quit): ");
	    if(in.hasNext("Q")){
		done = true;
	    }else if(in.hasNextInt()){
		int sideLength = in.nextInt();
		if(sideLength > 0){
		    System.out.println("Volume " + cubeVolume(sideLength));
		}
	    }else{
		in.next();
	    }	
	}while(!done);

	in.close();
    }
}