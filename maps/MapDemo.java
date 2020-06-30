import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.awt.Color;
/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo{
    public static void main(String[] args){
        Map<String, Color> favoriteColors = new HashMap<String, Color>();
	favoriteColors.put("Juliet", Color.BLUE);
	favoriteColors.put("Romeo", Color.GREEN);
	favoriteColors.put("Adam", Color.RED);
	favoriteColors.put("Eve", Color.BLUE);

	// Print all the keys and values in the map

	for(String key : favoriteColors.keySet()){
	    Color value = favoriteColors.get(key);
	    System.out.println(key + " : " + value);
	}
    }
}