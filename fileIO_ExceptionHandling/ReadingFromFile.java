import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

/*
    Reads string input from numbers.txt to the screen
*/

public class ReadingFromFile{
    public static void main(String[] args) throws FileNotFoundException{
	System.out.println("This program prints out the contents of numbers.txt");

	JFileChooser chooser = new JFileChooser();
	Scanner in = null;
	if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
	    File selectedFile = chooser.getSelectedFile();
	    in = new Scanner(selectedFile);
	}
	
	while(in.hasNextDouble()){
	    System.out.println(in.nextDouble());
	}
    }
}