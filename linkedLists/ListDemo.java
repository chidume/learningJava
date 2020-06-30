import java.util.LinkedList;
import java.util.ListIterator;

/**
    This program demonstrates the LinkedList class.
*/
public class ListDemo{

    public static void main(String[] args){
        LinkedList<String> staff = new LinkedList<String>();
	staff.addLast("Diana");
	staff.addLast("Harry");
	staff.addLast("Romeo");
	staff.addLast("Tom");

	// | in the comments indicates the iterator position
	//ListIterator<String> iterator = staff.listIterator();	//|DHRT

	// Print all elements
	System.out.println(staff);
    }
}