package extra;

import java.util.HashSet;
import java.util.Set;

public class ExplanationSet {
    public static void main(String[] args) {
    	Set<String> animal = new HashSet<>();
    	
    	animal.add("Tiger");
    	animal.add("Parrot");
    	animal.add("Panda");
    	animal.add("Lion");
    	animal.add("Dolphin");
    	animal.add("Dolphin"); //Duplicate aren't allowed in Sets
    	
    	animal.remove("Panda");
    	// animal.remove(2);
    	
    	//We use for each for Sets as it is not ordered
    	for (String i : animal){
    		System.out.println(i);
    	}
    	
    	System.out.println(animal.size());
    	// System.out.println(sizeOf(animal));
    }
}
