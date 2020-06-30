import java.util.Scanner;

/*
    practicing the use of character patterns
*/

public class PlayingWithScanner{
    public static void main(String[] args){
	String string = "ewlrj2 o3ijroi23j ro2j3r9023r -2390 320e-923r0-23-r230ri2-ri2-3ir2-30ir2ri23pr k-2kf 2-kf -";
        Scanner in = new Scanner(string);
	in.useDelimiter("[^0-9]+");

	while(in.hasNext()){
	    System.out.println(in.next());
	}
    }
}